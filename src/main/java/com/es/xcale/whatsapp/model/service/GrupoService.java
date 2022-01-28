package com.es.xcale.whatsapp.model.service;

import java.util.Optional;

import com.es.xcale.whatsapp.model.entity.Grupo;

public interface GrupoService {
    public Iterable<Grupo> findAll();
	
	public Optional<Grupo> findById(Long id);
	
	public Grupo save(Grupo user);
	
	public void deleteById(Long id);	
 
}
