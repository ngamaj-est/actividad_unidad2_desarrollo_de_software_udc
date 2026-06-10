package com.example.unicartagena.cea14.application.ports.in;

import com.example.unicartagena.cea14.domain.models.ExamenMedico;
import com.example.unicartagena.cea14.domain.valueobjects.EspecieId;

import java.time.LocalDateTime;
import java.util.List;

public interface ProgramacionExamenesInPort {
    List<ExamenMedico> crearProgramaAnual(EspecieId especieId, LocalDateTime fechaInicio);
    int obtenerFrecuenciaDias(com.example.unicartagena.cea14.domain.enums.TiposDeExamenMedicos tipoExamen);
}
