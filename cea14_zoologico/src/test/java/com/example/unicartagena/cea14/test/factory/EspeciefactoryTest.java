package com.example.unicartagena.cea14.test.factory;

import com.example.unicartagena.cea14.domain.factory.EspecieFactory;
import com.example.unicartagena.cea14.domain.valueobjects.ZonaId;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class EspeciefactoryTest {
    @Test
    void debeCrearEspecieConFactory() {
        var zonaId = ZonaId.generate();
        
        var especie = EspecieFactory.crear(
            "León",
            "Panthera",
            "leo",
            "Gran felino africano",
            zonaId
        );
        
        assertThat(especie).isNotNull();
        assertThat(especie.getId()).isNotNull();
        assertThat(especie.getNombreEspanol()).isEqualTo("León");
        assertThat(especie.getNombreCientifico().getNombreCompleto()).isEqualTo("Panthera leo");
    }

    @Test
    void debeCrearEspecieConBuilder() {
        var zonaId = ZonaId.generate();
        
        var especie = EspecieFactory.builder()
            .conNombreEspanol("Tigre")
            .conNombreCientifico("Panthera", "tigris")
            .conDescripcion("Gran felino asiático")
            .enZona(zonaId)
            .build();
        
        assertThat(especie).isNotNull();
        assertThat(especie.getNombreEspanol()).isEqualTo("Tigre");
        assertThat(especie.getNombreCientifico().getNombreCompleto()).isEqualTo("Panthera tigris");
    }

    @Test
    void debeReconstruirEspecieConId() {
        var especieId = "especie-123";
        var zonaId = "zona-456";
        
        var especie = EspecieFactory.reconstruir(
            especieId,
            "Elefante",
            "Loxodonta",
            "africana",
            "Elefante africano",
            zonaId
        );
        
        assertThat(especie).isNotNull();
        assertThat(especie.getId().value()).isEqualTo(especieId);
        assertThat(especie.getNombreEspanol()).isEqualTo("Elefante");
    }
}
