package com.es.xcale.whatsapp.model.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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

    public void addContacto(Contacto contacto){
        this.integrantes.add(contacto);
    }

}
