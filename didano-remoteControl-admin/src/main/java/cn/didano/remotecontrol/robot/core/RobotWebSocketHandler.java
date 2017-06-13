package cn.didano.remotecontrol.robot.core;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.PathMatcher;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.didano.remotecontrol.base.exception.BackType;
import cn.didano.remotecontrol.base.exception.ServiceException;
import cn.didano.remotecontrol.base.exception.TransExceptionEnums;
import cn.didano.remotecontrol.base.json.Out;
import cn.didano.remotecontrol.base.util.ContextUtil;
import cn.didano.remotecontrol.robot.controller.RobotUpController;

@Component
public class RobotWebSocketHandler extends TextWebSocketHandler {
	static Logger logger = Logger.getLogger(RobotWebSocketHandler.class);
	// 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
	private static int onlineCount = 0;
	

	@Autowired
	PathMatcher pathMatcher;
	
	private static ConcurrentHashMap<String, RobotSession> robotInfoMap = new ConcurrentHashMap<String, RobotSession>();

	// 异常关闭
	@Override
	public void handleTransportError(WebSocketSession session, Throwable throwable) throws Exception {
		// 管理器里面如何删除呢?
		logger.debug("有一连接异常关闭！" + throwable.getMessage());
		subOnlineCount(); // 在线数减1
		logger.info("当前在线机器人为:" + getOnlineCount());
	}

	// 正常关闭
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		String urlPath = session.getUri().getPath();
		Map<String, String> vars = pathMatcher
				.extractUriTemplateVariables("/robot/api/ws/{service_no}", urlPath);
		String service_no = vars.get("service_no");
		subOnlineCount(); // 在线数减1
		logger.info("有一连接关闭！设备号为:"+service_no+"当前在线机器人为:" + getOnlineCount());
	}

	// 连接
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		String urlPath = session.getUri().getPath();
		Map<String, String> vars = pathMatcher
				.extractUriTemplateVariables("/robot/api/ws/{service_no}", urlPath);
		String service_no = vars.get("service_no");
		logger.debug("RobotWebsocket连接建立,连接设备号为：" + service_no);
		RobotSession info = new RobotSession();
		info.setWebSocketSession(session);
		info.setSessionId(session.getId());
		info.setService_no(service_no);
		addOnlineCount(); // 在线数加1
		//增加连接
		RobotWebSocketHandler.addRobotInfo(info);
		logger.info("当前在线机器人为：" + getOnlineCount());
	}

	// 接收信息
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage jsonTextMessage) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		try {
			String urlPath = session.getUri().getPath();
			Map<String, String> vars = pathMatcher
					.extractUriTemplateVariables("/robot/api/ws/{service_no}", urlPath);
			String service_no = vars.get("service_no");
			logger.info("RobotWebsocket收到消息：" + jsonTextMessage.getPayload());
			UpInfo report = mapper.readValue(jsonTextMessage.getPayload(), UpInfo.class);
			RobotUpController robotController = ContextUtil.act.getBean(RobotUpController.class);
			RobotDelegator delegator = new RobotDelegator();
			delegator.handle(service_no,robotController, report);
		} catch (Exception ex) {
			logger.error(jsonTextMessage.getPayload());
			ex.printStackTrace();
		}
	}




	public static synchronized int getOnlineCount() {
		return onlineCount;
	}

	public static synchronized void addOnlineCount() {
		onlineCount++;
	}

	public static synchronized void subOnlineCount() {
		onlineCount--;
	}
	
	/**
	 * 给单个客户端发信息
	 * 
	 * @return
	 */
	public static synchronized void sendMessage(String service_no, DownInfo downInfo) throws ServiceException{
		RobotSession session = robotInfoMap.get(service_no);
		if (session != null) {
			ObjectMapper mapper = new ObjectMapper();
			String data = null;
			try {
				System.err.println("给客户端发送消息");
				data = mapper.writeValueAsString(downInfo);
				System.err.println(data);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				session.getWebSocketSession().sendMessage(new TextMessage(data));
			} catch (IOException e) {
				logger.debug(BackType.FAIL_DIAGNOSE_WEBSOCKET_DISCONNECT + ":websocket已经关闭");
				e.printStackTrace();
			}
		} else {
			logger.warn("设备编号:" + service_no + "，不存在robotWebsocket客户端连接");
			throw new ServiceException(new TransExceptionEnums(BackType.FAIL_DIAGNOSE_WEBSOCKET_NO_EXIT));
		}
	}

	/**
	 * 给单个客户端发信息
	 * 
	 * @return
	 */
	public static synchronized void sendMessage(String service_no, Out<String> backError) {
		DownInfo downInfo = new DownInfo();
		downInfo.setMethodName("go_backError");
		ObjectMapper mapper = new ObjectMapper();
		String JsonString = null;
		JsonNode rootNode = null;
		String message = null;
		try {
			JsonString = mapper.writeValueAsString(backError);
			rootNode = mapper.readTree(JsonString);
		} catch (JsonProcessingException e1) {
			message = e1.getMessage();
			e1.printStackTrace();
		} catch (IOException e) {
			message = e.getMessage();
			e.printStackTrace();
		}
		if(rootNode!=null){
			downInfo.setInfo(rootNode);
		}else{
			downInfo.setInfo(null);
			try{
				rootNode = mapper.readTree("{\"code\": 0,\"data\": \"\",\"message\": \"返回信息格式转换异常:\""+message+",\"success\": false}"); 
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}
		sendMessage(service_no, downInfo);
	}

	/**
	 * 采用简单的hashmap技术，效率不是很高，将来用netty一并改写提升 获取连接池
	 * 
	 * @return
	 */
	public static synchronized ConcurrentHashMap<String, RobotSession> getRobotInfoMap() {
		return robotInfoMap;
	}

	/**
	 * 增加连接
	 * 理论上每个设备可以有多个websocket连接,应该用wesocket httpsession id作为票据，但这里强制，每一个设备最多只有一个websocket连接，新创建一个连接后，将会把以前的冲掉，并关闭以前的连接
	 * @param channelId
	 */
	public static synchronized void addRobotInfo(RobotSession robotInfo) {
		if(robotInfoMap.get(robotInfo.getService_no())!=null){
			logger.warn("编号为:"+robotInfo.getService_no()+"的设备已经有连接，此socket仍然存在，但不受管理");
		}
		robotInfoMap.put(robotInfo.getService_no(), robotInfo);
	}

	/**
	 * 删除连接
	 * 
	 * @param websocketChannel
	 */
	public static synchronized void delRobotInfo(String service_no) {
		robotInfoMap.remove(service_no);
	}
	
}
