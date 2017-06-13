package cn.didano.remotecontrol.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;

import cn.didano.remotecontrol.robot.core.RobotWebSocketHandler;

/**
 * Robot websocket配置
 * @author stephen
 * Created on 2016年12月19日 下午5:31:09 
 */
@Configuration
@EnableWebSocket
public class RobotWebSocketConfig implements WebSocketConfigurer {

    @Bean
    public ServletServerContainerFactoryBean createWebSocketContainer() {
        ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
        container.setMaxTextMessageBufferSize(8192);
        container.setMaxBinaryMessageBufferSize(8192);
        //1个小时太长，改为5分钟
        //container.setMaxSessionIdleTimeout(3600000);
        container.setMaxSessionIdleTimeout(300000);
        container.setAsyncSendTimeout(300000);
        return container;
    }

    @Autowired
    protected RobotWebSocketHandler robotWebSocketHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
    	//需要设定允许任何
    	registry.addHandler(robotWebSocketHandler, "/robot/api/ws/{service_no}").setAllowedOrigins("*");
    }
}