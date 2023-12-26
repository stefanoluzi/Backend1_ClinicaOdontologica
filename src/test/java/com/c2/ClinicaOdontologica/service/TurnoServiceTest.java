package com.c2.ClinicaOdontologica.service;

import com.c2.ClinicaOdontologica.dto.TurnoDTO;
import com.c2.ClinicaOdontologica.entity.Domicilio;
import com.c2.ClinicaOdontologica.entity.Odontologo;
import com.c2.ClinicaOdontologica.entity.Paciente;
import com.c2.ClinicaOdontologica.entity.Turno;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.parameters.P;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class TurnoServiceTest {
    @Autowired
    private TurnoService turnoService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;


    @Test
    @Order(1)
    public void guardarTurno(){
        Odontologo odontologo= new Odontologo("MP123456","Roberto","Cyrus");
        odontologoService.registrarOdontologo(odontologo);
        Paciente paciente= new Paciente("Stefano","Luzi","123456", LocalDate.of(2023,11,28),new Domicilio("9 de julio",200,"Capital Federal","Buenos Aires"),"stefanoluzi@hotmail.com");
        pacienteService.registrarPaciente(paciente);
        Turno turno= new Turno(paciente,odontologo,LocalDate.of(2023,05,25));
        turnoService.guardarTurno(turno);
        assertEquals(1L,turno.getId());
    }
    @Test
    @Order(2)
    public void buscarTurnoPorId(){
        Long id=1L;
        Optional<TurnoDTO> turnoBuscado= turnoService.buscarTurnoPorId(id);
        assertNotNull(turnoBuscado);
    }

    @Test
    @Order(3)
    public void buscarTodos(){
        List<TurnoDTO> turnos= turnoService.buscarTodos();
        assertEquals(1,turnos.size());
    }
    @Test
    @Order(4)
    public void actualizarTurnos(){
        Odontologo odontologo2= new Odontologo("MP9999","Anibal","Odontologo");
        odontologoService.registrarOdontologo(odontologo2);
        TurnoDTO turnoDTO= new TurnoDTO(1L,LocalDate.of(2023,05,25),1L,2L);
        turnoService.actualizarTurno(turnoDTO);
        Optional<TurnoDTO> turnoDTOencontrado= turnoService.buscarTurnoPorId(1L);
        assertEquals(2L,turnoDTOencontrado.get().getOdontologoId());
    }


    @Test
    @Order(5)
    public void eliminarTurno(){
        Long idEliminar= 1L;
        turnoService.eliminarTurno(1L);
        Optional<TurnoDTO> turnoEliminado= turnoService.buscarTurnoPorId(1L);
        assertFalse(turnoEliminado.isPresent());
    }

}