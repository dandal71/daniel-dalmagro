package com.es.xcale.whatsapp.model.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mensaje {
    
    private Long id;
    private String contenido;
    private Contacto autor;
}
