package com.es.xcale.whatsapp.controller;

import com.es.xcale.whatsapp.model.entity.Mensaje;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * Controlador de mensajeria
 */
@RestController
@Slf4j
public class WahtsappController {

  
    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    @MessageMapping("/ws/{grupoId}/enviarMensaje")
    public void sendMessage(@DestinationVariable String grupoId, @Payload Mensaje mensaje) {
        log.info("GrupoID: " + grupoId +" Mensaje recibido "+ mensaje.getContenido());
        messagingTemplate.convertAndSend(String.format("/ws-grupo/%s", grupoId), mensaje);
    }

    @MessageMapping("/chat/{grupoId}/addContacto")
    public void addUser(@DestinationVariable String grupoId, @Payload Mensaje mensaje,
                        SimpMessageHeaderAccessor headerAccessor) {
        String currentRoomId = (String) headerAccessor.getSessionAttributes().put("grupo_id", grupoId);
        if (currentRoomId != null) {
            Mensaje nuevoMensaje = new Mensaje();
            nuevoMensaje.setTipo(Mensaje.TipoMensaje.LEAVE);
            nuevoMensaje.setAutor(mensaje.getAutor());
            messagingTemplate.convertAndSend(String.format("/chat-room/%s", grupoId), nuevoMensaje);
        }
        headerAccessor.getSessionAttributes().put("nombre", mensaje.getAutor().getNombre());
        messagingTemplate.convertAndSend(String.format("/chat-room/%s", grupoId), mensaje);
    }
    
}
