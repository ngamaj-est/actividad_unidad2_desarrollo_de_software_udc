package com.example.unicartagena.cea14.test.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.unicartagena.cea14.domain.exceptions.CapacidadException;
import com.example.unicartagena.cea14.domain.exceptions.ItinerarioExceptions;
import com.example.unicartagena.cea14.domain.models.Itinerario;
import com.example.unicartagena.cea14.domain.valueobjects.*;

import static org.assertj.core.api.Assertions.*;

class ItinerarioTest {

    private ItinerarioId itinerarioId;
    private DuracionItinerario duracion;
    private CapacidadVisitantes capacidad;

    @BeforeEach
    void setUp() {
        itinerarioId = ItinerarioId.generate();
        duracion = new DuracionItinerario(120);
        capacidad = new CapacidadVisitantes(25);
    }

    @Test
    void debeCrearItinerarioValido() {
        var itinerario = new Itinerario(itinerarioId, "IT-001", duracion, 
                                        2.5, capacidad, 10);
        
        assertThat(itinerario.getId()).isEqualTo(itinerarioId);
        assertThat(itinerario.getCodigo()).isEqualTo("IT-001");
        assertThat(itinerario.getDuracion()).isEqualTo(duracion);
        assertThat(itinerario.getLongitudKm()).isEqualTo(2.5);
        assertThat(itinerario.getCapacidadMaxima()).isEqualTo(capacidad);
        assertThat(itinerario.getNumeroEspeciesVisitadas()).isEqualTo(10);
    }

    @Test
    void debeFallarConCodigoVacio() {
        assertThatThrownBy(() -> new Itinerario(itinerarioId, "", duracion, 
                                                2.5, capacidad, 10))
            .isInstanceOf(ItinerarioExceptions.class)
            .hasMessageContaining("código no puede estar vacío");
    }

    @Test
    void debeFallarConLongitudInvalida() {
        assertThatThrownBy(() -> new Itinerario(itinerarioId, "IT-001", duracion, 
                                                -1, capacidad, 10))
            .isInstanceOf(ItinerarioExceptions.class)
            .hasMessageContaining("longitud debe ser mayor a 0");
    }

    @Test
    void debeAgregarZona() {
        var itinerario = new Itinerario(itinerarioId, "IT-001", duracion, 
                                        2.5, capacidad, 10);
        var zonaId = ZonaId.generate();
        
        itinerario.agregarZona(zonaId);
        
        assertThat(itinerario.atraviesa(zonaId)).isTrue();
        assertThat(itinerario.cantidadZonasRecorridas()).isEqualTo(1);
    }

    @Test
    void debeFallarAlAgregarZonaDuplicada() {
        var itinerario = new Itinerario(itinerarioId, "IT-001", duracion, 
                                        2.5, capacidad, 10);
        var zonaId = ZonaId.generate();
        
        itinerario.agregarZona(zonaId);
        
        assertThatThrownBy(() -> itinerario.agregarZona(zonaId))
            .isInstanceOf(ItinerarioExceptions.class)
            .hasMessageContaining("zona ya está incluida");
    }

    @Test
    void debeValidarCapacidad() {
        var itinerario = new Itinerario(itinerarioId, "IT-001", duracion, 
                                        2.5, new CapacidadVisitantes(20), 10);
        
        assertThatCode(() -> itinerario.validarCapacidad(15))
            .doesNotThrowAnyException();
    }

    @Test
    void debeFallarCuandoSeExcedeCapacidad() {
        var itinerario = new Itinerario(itinerarioId, "IT-001", duracion, 
                                        2.5, new CapacidadVisitantes(20), 10);
        
        assertThatThrownBy(() -> itinerario.validarCapacidad(25))
            .isInstanceOf(CapacidadException.class)
            .hasMessageContaining("excede la capacidad máxima");
    }

    @Test
    void debeActualizarDuracion() {
        var itinerario = new Itinerario(itinerarioId, "IT-001", duracion, 
                                        2.5, capacidad, 10);
        var nuevaDuracion = new DuracionItinerario(180);
        
        itinerario.actualizarDuracion(nuevaDuracion);
        
        assertThat(itinerario.getDuracion()).isEqualTo(nuevaDuracion);
    }

    @Test
    void debeActualizarNumeroEspecies() {
        var itinerario = new Itinerario(itinerarioId, "IT-001", duracion, 
                                        2.5, capacidad, 10);
        
        itinerario.actualizarNumeroEspecies(15);
        
        assertThat(itinerario.getNumeroEspeciesVisitadas()).isEqualTo(15);
    }
}
