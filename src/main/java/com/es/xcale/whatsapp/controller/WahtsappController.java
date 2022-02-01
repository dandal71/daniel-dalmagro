package com.es.xcale.whatsapp.controller;

import java.util.Optional;

import com.es.xcale.whatsapp.model.entity.Grupo;
import com.es.xcale.whatsapp.model.entity.Mensaje;
import com.es.xcale.whatsapp.model.service.GrupoService;

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

    @Autowired
    private GrupoService grupoService;

    /**
     * Envia los mensajes al grupo y lo persiste
     * @param grupoId
     * @param mensaje
     */
    //Asegura que si el cliente envia un mensaes a ws/{grupoId}/enviarMensaje, este método será ejecutado.
    //Tener en cuenta que se agregar el prefijo ws-app 
    @MessageMapping("/ws/{grupoId}/enviarMensaje") 
    public void sendMessage(@DestinationVariable Long grupoId, @Payload Mensaje mensaje) {
        log.info("GrupoID: " + grupoId +" Mensaje recibido "+ mensaje.getContenido());

        if (mensaje.getTipoMensaje().equals(Mensaje.TipoMensaje.CHAT)){
            //El mensaje es enviado al broker de mensajes a /ws-grupo/{grupoId}
            //Esto hace que todos los suscripto al ws-grupo/grupoId reciban el mensaje
            messagingTemplate.convertAndSend(String.format("/ws/%s", grupoId), mensaje);

            //Persiste el mensaje en el grupo
            Optional<Grupo> optGrupo = this.grupoService.findById(grupoId);
            optGrupo.ifPresent( g -> {
                    g.addMensaje(mensaje);
                    this.grupoService.save(g);
            });
        }        
    } 

    /**
     * Agrega un usuario a un grupo
     * 
     * @param grupoId Grupo al que se quiere contactar
     * @param mensaje Mensaje del tipo jon
     * @param headerAccessor
     */
    @MessageMapping("/ws/{grupoId}/agregarContacto")
    public void addUser(@DestinationVariable Long grupoId, @Payload Mensaje mensaje,
                        SimpMessageHeaderAccessor headerAccessor) {
        String grupoConectado = (String) headerAccessor.getSessionAttributes().put("grupo_id", grupoId);
        if (grupoConectado != null) {
            Mensaje nuevoMensaje = new Mensaje();
            nuevoMensaje.setTipo(Mensaje.TipoMensaje.JOIN);
            nuevoMensaje.setAutor(mensaje.getAutor());
            messagingTemplate.convertAndSend(String.format("/chat-room/%s", grupoId), nuevoMensaje);
        }
        headerAccessor.getSessionAttributes().put("nombre", mensaje.getAutor().getNombre());
        messagingTemplate.convertAndSend(String.format("/ws-grupo/%s", grupoId), mensaje);

        //Persiste el usuario en el grupo
        Optional<Grupo> optGrupo = this.grupoService.findById(grupoId);
        optGrupo.ifPresent( g -> {
                g.addContacto(mensaje.getAutor());
                this.grupoService.save(g);
        });
    }
    
}
