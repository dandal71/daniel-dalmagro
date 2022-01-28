package com.es.xcale.whatsapp.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Grupo {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
    private Long id;    

    private Long descripcion;
   
        
     //Indicamos carga lazy y que cuando insertemos/eliminemos un usuario tambien se haga en usuario-roles
     @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
     //Indicamos la tabla asociativa y el nombre de sus campos. Tambien el unique
     @JoinTable(name = "grupo_contacto")
    private List<Contacto> integrantes;    

}
