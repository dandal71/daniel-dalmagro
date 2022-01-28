package com.es.xcale.whatsapp.model.service;

import com.es.xcale.whatsapp.model.repository.ContactoRepository;
import com.es.xcale.whatsapp.model.repository.GrupoRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GrupoServiceImplTest {
    
    GrupoRepository grupoRepositorio;
    
    ContactoRepository contactoRepositorio;

      /**
     * Se ejecuta antes de cada método de test
     */
    @BeforeEach
    public void setUp() {
        
        this.grupoRepositorio = mock(GrupoRepository.class);
        this.contactoRepositorio = mock(ContactoRepository.class);
                  

    }
    
    @Test
    void testDeleteById() {

    }

    @Test
    void testFindAll() {

    }

    @Test
    void testFindById() {

    }

    @Test
    void testSave() {

    }
}
