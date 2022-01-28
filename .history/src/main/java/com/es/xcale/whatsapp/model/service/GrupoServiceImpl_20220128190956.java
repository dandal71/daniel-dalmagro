package com.es.xcale.whatsapp.model.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.es.xcale.whatsapp.model.entity.Grupo;
import com.es.xcale.whatsapp.model.repository.GrupoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public class GrupoServiceImpl implements GrupoService{
    @Autowired
	protected GrupoRepository grupoRepository;
	
	@Override	
	public List<Grupo> findAll() {		
		return (List<Grupo>)this.grupoRepository.findAll();
	}
	
	@Override	
	public Page<Grupo> findAll(Pageable pageable) {		
		return this.grupoRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Grupo> findById(Long id) {
		return this.grupoRepository.findById(id);
	}

	@Override
	@Transactional
	public Grupo save(Grupo entidad) {
		return this.grupoRepository.save(entidad);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		this.grupoRepository.deleteById(id);
}
