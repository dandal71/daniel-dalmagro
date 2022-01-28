package com.es.xcale.whatsapp.model.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Contacto {
    private Long id;
    private String nombre;
    private String numero;
             
    @ManyToMany(mappedBy = "grupos", fetch = FetchType.LAZY)
    private Set<Grupo> grupos = new HashSet<Grupo>();
    
}
