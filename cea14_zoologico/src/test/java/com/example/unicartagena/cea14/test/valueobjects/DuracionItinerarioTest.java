package com.example.unicartagena.cea14.test.valueobjects;
import org.junit.jupiter.api.Test;

import com.example.unicartagena.cea14.domain.models.Itinerario;
import com.example.unicartagena.cea14.domain.specifications.ItinerarioGrupoPequeñoSpecs;
import com.example.unicartagena.cea14.domain.specifications.ItinerarioLargaDuracionSpecs;
import com.example.unicartagena.cea14.domain.valueobjects.CapacidadVisitantes;
import com.example.unicartagena.cea14.domain.valueobjects.DuracionItinerario;
import com.example.unicartagena.cea14.domain.valueobjects.ItinerarioId;

import static org.assertj.core.api.Assertions.*;

class DuracionItinerarioTest {

    @Test
    void debeCumplirSpecificationDeLargaDuracion() {
        var itinerario = new Itinerario(
            ItinerarioId.generate(),
            "IT-001",
            new DuracionItinerario(180), // 3 horas
            2.5,
            new CapacidadVisitantes(20),
            10
        );
        
        var spec = new ItinerarioLargaDuracionSpecs(2);
        
        assertThat(spec.isSatisfiedBy(itinerario)).isTrue();
    }

    @Test
    void debeCumplirSpecificationDeLargaDuracionConDuracionExacta() {
        var itinerario = new Itinerario(
            ItinerarioId.generate(),
            "IT-002",
            new DuracionItinerario(120), // 2 horas exactas
            2.0,
            new CapacidadVisitantes(20),
            10
        );
        
        var spec = new ItinerarioLargaDuracionSpecs(2);
        
        assertThat(spec.isSatisfiedBy(itinerario)).isTrue();
    }

    @Test
    void noDebeCumplirSpecificationDeLargaDuracion() {
        var itinerario = new Itinerario(
            ItinerarioId.generate(),
            "IT-001",
            new DuracionItinerario(90), // 1.5 horas
            2.5,
            new CapacidadVisitantes(20),
            10
        );
        
        var spec = new ItinerarioLargaDuracionSpecs(2);
        
        assertThat(spec.isSatisfiedBy(itinerario)).isFalse();
    }

    @Test
    void debeCumplirSpecificationDeGrupoPequeno() {
        var itinerario = new Itinerario(
            ItinerarioId.generate(),
            "IT-001",
            new DuracionItinerario(120),
            2.5,
            new CapacidadVisitantes(15),
            10
        );
        
        var spec = new ItinerarioGrupoPequeñoSpecs(20);
        
        assertThat(spec.isSatisfiedBy(itinerario)).isTrue();
    }

    @Test
    void debeComponerSpecificationsConAnd() {
        var itinerario = new Itinerario(
            ItinerarioId.generate(),
            "IT-001",
            new DuracionItinerario(180), // 3 horas
            2.5,
            new CapacidadVisitantes(15), // grupo pequeño
            10
        );
        
        var specLarga = new ItinerarioLargaDuracionSpecs(2);
        var specPequeno = new ItinerarioGrupoPequeñoSpecs(20);
        var specCompuesta = specLarga.and(specPequeno);
        
        assertThat(specCompuesta.isSatisfiedBy(itinerario)).isTrue();
    }

    @Test
    void debeComponerSpecificationsConOr() {
        var itinerario = new Itinerario(
            ItinerarioId.generate(),
            "IT-001",
            new DuracionItinerario(90), // corta duración
            2.5,
            new CapacidadVisitantes(15), // grupo pequeño
            10
        );
        
        var specLarga = new ItinerarioLargaDuracionSpecs(2);
        var specPequeno = new ItinerarioGrupoPequeñoSpecs(20);
        var specCompuesta = specLarga.or(specPequeno);
        
        assertThat(specCompuesta.isSatisfiedBy(itinerario)).isTrue();
    }

    @Test
    void debeNegarSpecification() {
        var itinerario = new Itinerario(
            ItinerarioId.generate(),
            "IT-001",
            new DuracionItinerario(90),
            2.5,
            new CapacidadVisitantes(20),
            10
        );
        
        var spec = new ItinerarioLargaDuracionSpecs(2);
        var specNegada = spec.not();
        
        assertThat(specNegada.isSatisfiedBy(itinerario)).isTrue();
    }
}
