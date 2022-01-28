package com.es.xcale.whatsapp.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Contacto {
    private Long id;
    private String nombre;
    private String numero;
             
     @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
     @JoinTable(name = "grupo_contacto",
     joinColumns = {@JoinColumn(name = "contacto_id", referencedColumnName = "id",
                     nullable = false, updatable = false)},
     inverseJoinColumns = {@JoinColumn(name = "grupo_id", referencedColumnName = "id",
                     nullable = false, updatable = false)})
    private List<Grupo> grupos;    

    
}
