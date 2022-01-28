package com.es.xcale.whatsapp.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Grupo {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
    private Long id;    

    private Long descripcion;
               
     @JoinTable(
        name = "grupo_contacto", 
        joinColumns = @JoinColumn(name = "grupo_id"), 
        inverseJoinColumns = @JoinColumn(name = "contacto_id"))
    private List<Contacto> integrantes;    

    @JsonIgnoreProperties(value = {"mensajes"}, allowSetters = true)  
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "grupo", orphanRemoval = true)
	private List<Mensaje> mensajes;
	

    public void addContacto(Contacto contacto){
        this.integrantes.add(contacto);
    }

    public void addMensaje(Mensaje mensaje) {
		mensaje.setGrupo(this);		
		this.mensajes.add(mensaje);
	}

}
