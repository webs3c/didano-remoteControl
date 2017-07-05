package cn.didano.remotecontrol.robot.core;

import org.springframework.web.socket.WebSocketSession;

/**
 * websocket事物信息
 * @author stephen.wang 2017-03-02 
 */
public class RobotSession {
	//sessionid  取webSocketSession的id，这个id是以个位数往上增
	private String sessionId;
	//设备号
	private String service_no;
	private WebSocketSession webSocketSession;
	
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
	public String getService_no() {
		return service_no;
	}
	public void setService_no(String service_no) {
		this.service_no = service_no;
	}
	public WebSocketSession getWebSocketSession() {
		return webSocketSession;
	}
	public void setWebSocketSession(WebSocketSession webSocketSession) {
		this.webSocketSession = webSocketSession;
	}
}