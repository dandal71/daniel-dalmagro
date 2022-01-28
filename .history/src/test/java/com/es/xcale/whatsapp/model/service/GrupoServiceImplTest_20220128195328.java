package com.es.xcale.whatsapp.model.service;

import com.es.xcale.whatsapp.model.repository.ContactoRepository;
import com.es.xcale.whatsapp.model.repository.GrupoRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        
        this.grupoRepositorio = mock(ExamenRepository.class);
        this.contactoRepositorio = mock(PreguntaRepository.class);
        //this.examenService = new ExamenServiceImpl(this.examenRepositorio, this.preguntaRepositorio);

        //Habilitamos las anotaciones como Mock y InjectMock
        MockitoAnnotations.openMocks(this);

        this.examenes =  Arrays.asList(new Examen(1L, "Programación")
                , new Examen(2L, "Estructura de las Organizaciones")
                , new Examen(3L, "Computacion 1"));
        this.preguntas =  Arrays.asList("Flujo de Control", "Condicionales", "operadores");                

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
