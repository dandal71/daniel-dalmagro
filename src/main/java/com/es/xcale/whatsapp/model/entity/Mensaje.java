package com.es.xcale.whatsapp.model.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
public class Mensaje {
    
    public enum TipoMensaje {
        CHAT, JOIN, LEAVE
    }

    private Long id;
    private String contenido;
    private Contacto autor;
    private TipoMensaje tipoMensaje;
        
	@ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "grupo_id")
	private Grupo grupo;
    
    public void setTipo(TipoMensaje tipoMensaje) {
        this.tipoMensaje = tipoMensaje;
    }

    public TipoMensaje getType() {
        return tipoMensaje;
    }



}
