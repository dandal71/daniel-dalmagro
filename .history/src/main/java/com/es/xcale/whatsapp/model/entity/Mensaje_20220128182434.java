package com.es.xcale.whatsapp.model.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mensaje {
    
    public enum TipoMensaje {
        CHAT, JOIN, LEAVE
    }

    private Long id;
    private String contenido;
    private Contacto autor;
    private TipoMensaje tipoMensaje;

    public void setTipo(TipoMensaje tipoMensaje) {
        this.tipoMensaje = tipoMensaje;
    }

    public TipoMensaje getType() {
        return tipoMensaje;
    }
}
