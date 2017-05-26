package cn.didano.robot.core;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.didano.base.exception.DBExceptionEnums;
import cn.didano.base.exception.ServiceException;
import cn.didano.remotecontrol.app.config.GetHttpSessionConfigurator;
import cn.didano.remotecontrol.exception.VideoExceptionEnums;
import cn.didano.robot.controller.RobotUpController;
import cn.didano.util.ContextUtil;
import cn.didano.video.json.Out;

/**
 * 机器人websocket连接，该连接由http协议建立，然后由tcp协议保持通信
 * 
 * 理论上每个设备可以有多个websocket连接,应该用wesocket httpsession id作为票据，但这里强制，每一个设备最多只有一个websocket连接，新创建一个连接后，将会把以前的冲掉，并关闭以前的连接
 * @author stephen Created on 2016年12月23日 下午6:30:26
 * @Component
 */
@Component
@ServerEndpoint(value = "/robot/api/ws/{service_no}", configurator = GetHttpSessionConfigurator.class)
public class RobotWebsocketServer {
	static Logger logger = Logger.getLogger(RobotWebsocketServer.class);
	//设备编号
	private String service_no;
	// 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
	private static int onlineCount = 0;

	//与某个客户端的连接Tcp Session会话，需要通过它来给客户端发送数据,一个session可能包括多个websocket会话
	private Session session;

	private static ConcurrentHashMap<String, RobotSession> robotInfoMap = new ConcurrentHashMap<String, RobotSession>();

	/**
	 * 连接建立成功调用的方法，应该放到session里面，每个通道不论时间都可由管理员或者园长关闭
	 * 
	 * @Todo
	 * 
	 * @param session
	 *            可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
	 */
	@OnOpen
	public void onOpen(@PathParam("service_no") String service_no, Session session, EndpointConfig config)
			throws Exception {
		logger.debug("RobotWebsocket连接建立,连接设备号为：" + service_no);
		this.session = session;
		this.service_no = service_no;
		// 与某个客户端的连接会话，需要通过它来给客户端发送数据
		HttpSession httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
		// 如果正在看视频已经存在，那么将被替换
		RobotSession info = new RobotSession();
		info.setHttpSession(httpSession);
		info.setHttpSessionId(httpSession.getId());
		info.setRobotWebsocketServer(this);
		info.setService_no(service_no);
		addOnlineCount(); // 在线数加1
		//增加连接
		RobotWebsocketServer.addRobotInfo(info);
		logger.info("当前在线机器人为：" + getOnlineCount());
	}

	/**
	 * 连接关闭调用的方法
	 */
	@OnClose
	public void onClose() {
		subOnlineCount(); // 在线数减1
		logger.info("有一连接关闭！当前在线机器人为" + getOnlineCount());
	}

	/**
	 * 收到客户端消息后调用的方法 //websocket的双工，只有发送->接收，无需返回任何信息，完全异步，保持高速 这个和restful api
	 * json同步发送不同
	 * 
	 * @param message
	 *            客户端发送过来的消息
	 * @param session
	 *            可选的参数
	 */
	@OnMessage
	public void onMessage(String message, Session session) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			logger.info("RobotWebsocket收到消息：" + message);
			System.err.println(message);
			UpInfo report = mapper.readValue(message, UpInfo.class);
			RobotUpController robotController = ContextUtil.act.getBean(RobotUpController.class);
			RobotDelegator delegator = new RobotDelegator();
			delegator.handle(service_no,robotController, report);
		} catch (Exception ex) {
			logger.error(message);
			ex.printStackTrace();
		}
	}
	/**
	 * 发生错误时调用 此方法被自动调用，同时之后会自动调用onClose
	 * 
	 * @param session
	 * @param error
	 */
	@OnError
	public void onError(Session session, Throwable error) {
		// 管理器里面如何删除呢?
		logger.debug("robotWebsocket 发生错误" + error.getMessage());
	}

	/**
	 * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。
	 * 
	 * @param message
	 * @throws IOException
	 */
	public void sendMessage(String message) {
		try {
			logger.debug("websocket:sendMessage="+message);
			this.session.getBasicRemote().sendText(message);
		} catch (IOException e) {
			logger.debug(VideoExceptionEnums.FAIL_WEBSOCKET_SEND + ":websocket已经关闭sessionid[" + session.getId() + "]"
					+ ":" + e.getMessage());
		} catch (Exception ex) {
			logger.debug(VideoExceptionEnums.FAIL_WEBSOCKET_SEND + ":websocket已经关闭sessionid[" + session.getId() + "]"
					+ ":" + ex.getMessage());
		}
	}

	public static synchronized int getOnlineCount() {
		return onlineCount;
	}

	public static synchronized void addOnlineCount() {
		RobotWebsocketServer.onlineCount++;
	}

	public static synchronized void subOnlineCount() {
		RobotWebsocketServer.onlineCount--;
	}

	/**
	 * 给单个客户端发信息
	 * 
	 * @return
	 */
	public static synchronized void sendMessage(String service_no, DownInfo downInfo) throws ServiceException{
		ConcurrentHashMap<String, RobotSession> tmp = RobotWebsocketServer.getRobotInfoMap();
		RobotSession session = RobotWebsocketServer.getRobotInfoMap().get(service_no);
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
			session.getRobotWebsocketServer().sendMessage(data);
			Session ASession = session.getRobotWebsocketServer().getSession();
			ASession.getMessageHandlers().clear();
			int a =ASession.getMessageHandlers().size();
			System.err.println(a);
		} else {
			logger.warn("设备编号:" + service_no + "，不存在robotWebsocket客户端连接");
			throw new ServiceException(DBExceptionEnums.ERROR_DIAGNOSE_DIVICENO_NOT_EXIST);
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

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
	
	
}