package com.es.xcale.whatsapp.model.entity;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Mensaje {
    
    public enum TipoMensaje {
        CHAT, JOIN, LEAVE
    }

    private Long id;
    private String contenido;
    private Contacto autor;
    private TipoMensaje tipoMensaje;
    private Grupo grupo;

    public void setTipo(TipoMensaje tipoMensaje) {
        this.tipoMensaje = tipoMensaje;
    }

    public TipoMensaje getType() {
        return tipoMensaje;
    }
}
