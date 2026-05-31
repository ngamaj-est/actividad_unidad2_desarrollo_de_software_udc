package com.example.unicartagena.cea14.test.valueobjects;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.unicartagena.cea14.domain.valueobjects.NombreCientificoEspecies;

class NombreCientificoEspeciesTest {

    @Test
    void debeCrearNombreCientificoValido() {
        var nombreCientifico = new NombreCientificoEspecies("Panthera", "leo");

        assertThat(nombreCientifico.genero()).isEqualTo("Panthera");
        assertThat(nombreCientifico.especie()).isEqualTo("leo");
        assertThat(nombreCientifico.nombreCompleto()).isEqualTo("Panthera leo");
        assertThat(nombreCientifico.getNombreCompleto()).isEqualTo("Panthera leo");
        assertThat(nombreCientifico.toString()).isEqualTo("Panthera leo");
    }

    @Test
    void debeFallarConGeneroNulo() {
        assertThatThrownBy(() -> new NombreCientificoEspecies(null, "leo"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("El género no puede estar vacío");
    }

    @Test
    void debeFallarConEspecieNula() {
        assertThatThrownBy(() -> new NombreCientificoEspecies("Panthera", null))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("La especie no puede estar vacía");
    }

    @Test
    void debeFallarSiGeneroNoIniciaConMayuscula() {
        assertThatThrownBy(() -> new NombreCientificoEspecies("panthera", "leo"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("El género debe comenzar con mayúscula");
    }

    @Test
    void debeFallarSiEspecieNoIniciaConMinuscula() {
        assertThatThrownBy(() -> new NombreCientificoEspecies("Panthera", "Leo"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("La especie debe comenzar con minúscula");
    }

    @Test
    void debeSerIgualSiTienenMismoGeneroYEspecie() {
        var nombre1 = new NombreCientificoEspecies("Panthera", "leo");
        var nombre2 = new NombreCientificoEspecies("Panthera", "leo");

        assertThat(nombre1).isEqualTo(nombre2);
        assertThat(nombre1.hashCode()).isEqualTo(nombre2.hashCode());
    }
}
