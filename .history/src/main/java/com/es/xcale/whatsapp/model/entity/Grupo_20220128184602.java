package com.es.xcale.whatsapp.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    
    @JsonIgnoreProperties(value = {"contacto"}, allowSetters = true)  
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "contacto", orphanRemoval = true)
    private List<Contacto> integrantes;
    
}
