package com.es.xcale.whatsapp.model.repository;

import com.es.xcale.whatsapp.model.entity.Contacto;

import org.springframework.data.repository.CrudRepository;

public interface ContactoRepository  extends CrudRepository<Contacto, Long>  {
    
}
