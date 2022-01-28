package com.es.xcale.whatsapp.model.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mensaje {
    
    public enum MessageType {
        CHAT, JOIN, LEAVE
    }
    
    private Long id;
    private String contenido;
    private Contacto autor;
}
