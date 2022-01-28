package com.es.xcale.whatsapp.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Contacto {
    private Long id;
    private String nombre;
    private String numero;
             
     @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
     @JoinTable(name = "grupo_contacto")
    private List<Grupo> integrantes;    

    
}
