package com.c2.ClinicaOdontologica.service;

import com.c2.ClinicaOdontologica.entity.Domicilio;
import com.c2.ClinicaOdontologica.entity.Odontologo;
import com.c2.ClinicaOdontologica.entity.Paciente;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class OdontologoServiceTest {
    @Autowired
    private OdontologoService odontologoService;

    @Test
    @Order(1)
    public void registrarOdontologo(){
        //Registro de un paciente modelo
        Odontologo odontologo= new Odontologo("123456","Stefano","Luzi");
        odontologoService.registrarOdontologo(odontologo);
        assertEquals(1L,odontologo.getId());
    }
    @Test
    @Order(2)
    public void buscarPorId(){
        Long id=1L;
        Optional<Odontologo> odontologoBuscado= odontologoService.buscarPorId(id);
        assertNotNull(odontologoBuscado);
    }

    @Test
    @Order(3)
    public void listarTodos(){
        List<Odontologo> odontologos= odontologoService.listarTodos();
        assertEquals(1,odontologos.size());
    }

    @Test
    @Order(4)
    public void actualizarOdontologo(){
        Odontologo odontologoActualizar= new Odontologo(1L,"123456","Jose","Luzi");
        odontologoService.actualizarOdontologo(odontologoActualizar);
        Optional<Odontologo> odontologoBuscado= odontologoService.buscarPorId(1L);
        assertEquals("Jose",odontologoBuscado.get().getNombre());
    }

    @Test
    @Order(5)
    public void eliminarOdontologo(){
        Long idEliminar= 1L;
        odontologoService.eliminarOdontologo(1L);
        Optional<Odontologo> odontologoEliminado= odontologoService.buscarPorId(1L);
        assertFalse(odontologoEliminado.isPresent());
    }
    @Test
    @Order(6)
    public void buscarPorMatricula(){
        Odontologo odontologo= new Odontologo("123456","Stefano","Luzi");
        odontologoService.registrarOdontologo(odontologo);
        Optional<Odontologo> odontologoEliminado= odontologoService.buscarPorId(1L);
        assertEquals("123456",odontologo.getMatricula());
    }
}