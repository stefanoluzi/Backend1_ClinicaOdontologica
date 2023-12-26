package com.c2.ClinicaOdontologica.dto;

import lombok.Data;
import lombok.Setter;

import java.time.LocalDate;

@Data
//POJO
public class TurnoDTO {
    private Long id;
    private LocalDate fechaTurno;
    private Long pacienteId;
    private Long odontologoId;

    public TurnoDTO(Long id, LocalDate fechaTurno, Long pacienteId, Long odontologoId) {
        this.id = id;
        this.fechaTurno = fechaTurno;
        this.pacienteId = pacienteId;
        this.odontologoId = odontologoId;
    }

    public TurnoDTO(LocalDate fechaTurno, Long pacienteId, Long odontologoId) {
        this.fechaTurno = fechaTurno;
        this.pacienteId = pacienteId;
        this.odontologoId = odontologoId;
    }

    public TurnoDTO() {
    }

}
