package com.es.xcale.whatsapp.model.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import com.es.xcale.whatsapp.model.entity.Grupo;
import com.es.xcale.whatsapp.model.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;


public class GrupoServiceImpl implements GrupoService{
    @Autowired
	protected GrupoRepository grupoRepository;
	
	@Override	
	public List<Grupo> findAll() {		
		return (List<Grupo>)this.grupoRepository.findAll();
	}
	
	@Override
	public Optional<Grupo> findById(Long id) {
		return this.grupoRepository.findById(id);
	}

	@Override
	@Transactional
	public Grupo save(Grupo grupo) {
		return this.grupoRepository.save(grupo);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		this.grupoRepository.deleteById(id);
    }
}



