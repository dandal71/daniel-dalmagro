package com.es.xcale.whatsapp.controller;

import com.es.xcale.whatsapp.model.entity.Mensaje;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WahtsappController {

    @MessageMapping("/whatsapp.registro")
    @SendTo("/topic/public")
    public Mensaje register(@Payload Mensaje mensaje, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", mensaje.getAutor());
        return mensaje;
    }

    @MessageMapping("/whatsapp.enviar")
    @SendTo("/topic/public")
    public Mensaje sendMessage(@Payload Mensaje mensaje) {
        return mensaje;
    }
    
}
