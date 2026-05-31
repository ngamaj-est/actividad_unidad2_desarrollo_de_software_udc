package com.example.unicartagena.cea14.test.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.unicartagena.cea14.domain.models.ExamenMedico;
import com.example.unicartagena.cea14.domain.services.ProgramacionExamenesService;
import com.example.unicartagena.cea14.domain.valueobjects.EspecieId;
import com.example.unicartagena.cea14.domain.enums.TiposDeExamenMedicos;

class ProgramacionExamenesServiceTest {

    private ProgramacionExamenesService service;
    private EspecieId especieId;

    @BeforeEach
    void setUp() {
        service = new ProgramacionExamenesService();
        especieId = EspecieId.generate();
    }

    @Test
    void debeCrearProgramaAnualCompleto() {
        var fechaInicio = LocalDateTime.now().plusDays(1);
        
        List<ExamenMedico> programa = service.crearProgramaAnual(especieId, fechaInicio);
        
        assertThat(programa).isNotEmpty();
        assertThat(programa).hasSizeGreaterThan(5);
        
        // Verificar que incluye chequeos físicos
        long chequeosFisicos = programa.stream()
            .filter(e -> e.getTipoExamen() == TiposDeExamenMedicos.ESTADO_FISICO)
            .count();
        assertThat(chequeosFisicos).isEqualTo(4); // Trimestral
        
        // Verificar análisis de sangre
        long analisisSangre = programa.stream()
            .filter(e -> e.getTipoExamen() == TiposDeExamenMedicos.ANALISIS_SANGRE)
            .count();
        assertThat(analisisSangre).isEqualTo(2); // Semestral
    }

    @Test
    void debeObtenerFrecuenciaCorrecta() {
        assertThat(service.obtenerFrecuenciaDias(TiposDeExamenMedicos.ESTADO_FISICO)).isEqualTo(90);
        assertThat(service.obtenerFrecuenciaDias(TiposDeExamenMedicos.ANALISIS_SANGRE)).isEqualTo(180);
        assertThat(service.obtenerFrecuenciaDias(TiposDeExamenMedicos.REVISION_DENTAL)).isEqualTo(365);
    }

    @Test
    void debeDetectarExamenProximoAVencer() {
        var fechaProgramada = LocalDateTime.now().plusDays(5);
        var examen = new ExamenMedico(especieId, TiposDeExamenMedicos.ESTADO_FISICO, fechaProgramada);
        
        assertThat(service.estaProximoAVencer(examen)).isTrue();
    }

    @Test
    void noDebeDetectarExamenLejano() {
        var fechaProgramada = LocalDateTime.now().plusDays(30);
        var examen = new ExamenMedico(especieId, TiposDeExamenMedicos.ESTADO_FISICO, fechaProgramada);
        
        assertThat(service.estaProximoAVencer(examen)).isFalse();
    }

    @Test
    void debeCalcularProximaFecha() {
        var ultimaFecha = LocalDateTime.now();
        var proximaFecha = service.calcularProximaFecha(TiposDeExamenMedicos.ESTADO_FISICO, ultimaFecha);
        
        assertThat(proximaFecha).isAfter(ultimaFecha);
        assertThat(proximaFecha).isEqualTo(ultimaFecha.plusDays(90));
    }
}
