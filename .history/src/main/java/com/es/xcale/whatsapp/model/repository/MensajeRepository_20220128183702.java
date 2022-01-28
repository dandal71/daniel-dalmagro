package com.es.xcale.whatsapp.model.repository;

import com.es.xcale.whatsapp.model.entity.Mensaje;

import org.springframework.data.repository.CrudRepository;

public interface MensajeRepository extends CrudRepository<Mensaje, Long> {
    
}
