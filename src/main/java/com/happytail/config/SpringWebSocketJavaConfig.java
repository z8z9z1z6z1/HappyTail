package com.happytail.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import com.happytail.config.websocket.SpringWebSocketHandler;

@Configuration
@EnableWebSocketMessageBroker
public class SpringWebSocketJavaConfig  implements WebSocketMessageBrokerConfigurer  {
	
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		// Endpoint no use "/notice" will happen connect fail

		registry.addEndpoint("/inform")
		.addInterceptors(new HttpSessionHandshakeInterceptor())
		.setHandshakeHandler(new SpringWebSocketHandler())
		.withSockJS();
		
		//Cause we do not know the sessionId of user, we find the userId to notice the user
	}
		
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.enableSimpleBroker("/topic/","/queue/");
		registry.setApplicationDestinationPrefixes("/app");
	}

}
