package com.es.xcale.whatsapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
/**
 * Clase de configuración. La anotación @EnabledWeb...  habilita a esta aplicación para la gestión
 * de mensajes websocket, a través de un broker de mensajes
 */
@EnableWebSocketMessageBroker
@Configuration
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer  {
    
    /**
     *
     * @param config
     *
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        //Todos los mensajes enviados a /ws serán leidos por todos los suscriptores
        config.enableSimpleBroker("/ws"); 
        //Todos los mensajes enviados al servidor deberán tener el prefijo /ws-app. 
        //Por ejemplo para enviar un mensaje la url deberá ser /ws-app/ws
        config.setApplicationDestinationPrefixes("/ws-app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //Indica que el endpoint sock estará habilitado para SockJS si websocket no está disponible
        registry.addEndpoint("/sock").setAllowedOrigins("*").withSockJS();
    }
}
