package com.example.unicartagena.cea14.domain.services;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.unicartagena.cea14.domain.exceptions.ZoologicoException;
import com.example.unicartagena.cea14.domain.models.ExamenMedico;
import com.example.unicartagena.cea14.domain.valueobjects.EspecieId;

import com.example.unicartagena.cea14.domain.enums.TiposDeExamenMedicos;

/**
 * Servicio de Dominio: Gestiona la programación de exámenes médicos
 */
public class ProgramacionExamenesService {

    /**
     * Crea un programa completo de exámenes para una especie
     */
    public List<ExamenMedico> crearProgramaAnual(EspecieId especieId, 
                                                  LocalDateTime fechaInicio) {
        if (especieId == null) {
            throw new ZoologicoException("La especie no puede ser nula");
        }
        if (fechaInicio == null) {
            throw new ZoologicoException("La fecha de inicio no puede ser nula");
        }

        List<ExamenMedico> programa = new ArrayList<>();

        // Chequeo físico trimestral (4 veces al año)
        for (int i = 0; i < 4; i++) {
            programa.add(new ExamenMedico(
                especieId,
                TiposDeExamenMedicos.ESTADO_FISICO,
                fechaInicio.plusMonths(3L * i)
            ));
        }

        // Análisis de sangre semestral (2 veces al año)
        programa.add(new ExamenMedico(especieId, TiposDeExamenMedicos.ANALISIS_SANGRE, fechaInicio));
        programa.add(new ExamenMedico(especieId, TiposDeExamenMedicos.ANALISIS_SANGRE, 
                                      fechaInicio.plusMonths(6)));

        // Evaluación dental anual
        programa.add(new ExamenMedico(especieId, TiposDeExamenMedicos.REVISION_DENTAL, fechaInicio));

        return programa;
    }

    /**
     * Determina la frecuencia recomendada de exámenes según el tipo
     */
    public int obtenerFrecuenciaDias(TiposDeExamenMedicos tipoExamen) {
        return switch (tipoExamen) {
            case ESTADO_FISICO -> 90;        // Cada 3 meses
            case ANALISIS_SANGRE -> 180;      // Cada 6 meses
            case ANALISIS_HECES -> 60;        // Cada 2 meses
            case REVISION_DENTAL -> 365;    // Anual
            case ANALISIS_GENETICO -> -1;     // Bajo demanda
        };
    }

    /**
     * Valida si un examen está próximo a vencer (menos de 7 días)
     */
    public boolean estaProximoAVencer(ExamenMedico examen) {
        if (examen == null || examen.isCompletado()) {
            return false;
        }

        LocalDateTime ahora = LocalDateTime.now();
        LocalDateTime limite = ahora.plusDays(7);

        return examen.getFechaProgramada().isBefore(limite) && 
               examen.getFechaProgramada().isAfter(ahora);
    }

    /**
     * Calcula la próxima fecha para un examen según su frecuencia
     */
    public LocalDateTime calcularProximaFecha(TiposDeExamenMedicos tipoExamen, LocalDateTime ultimaFecha) {
        int diasFrecuencia = obtenerFrecuenciaDias(tipoExamen);
        
        if (diasFrecuencia < 0) {
            throw new ZoologicoException("Este tipo de examen no tiene frecuencia programada");
        }

        return ultimaFecha.plusDays(diasFrecuencia);
    }
}
