package com.example.unicartagena.cea14.test.models;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.unicartagena.cea14.domain.exceptions.EspecieException;
import com.example.unicartagena.cea14.domain.models.Especie;
import com.example.unicartagena.cea14.domain.valueobjects.EspecieId;
import com.example.unicartagena.cea14.domain.valueobjects.HabitatId;
import com.example.unicartagena.cea14.domain.valueobjects.NombreCientificoEspecies;
import com.example.unicartagena.cea14.domain.valueobjects.ZonaId;


class EspecieTest {

    private EspecieId especieId;
    private NombreCientificoEspecies nombreCientifico;
    private ZonaId zonaId;

    @BeforeEach
    void setUp() {
        especieId = EspecieId.generate();
        nombreCientifico = new NombreCientificoEspecies("Panthera", "leo");
        zonaId = ZonaId.generate();
    }

    @Test
    void debeCrearEspecieValida() {
        var especie = new Especie(especieId, "León", nombreCientifico, 
                                  "Gran felino africano", zonaId);
        
        assertThat(especie.getId()).isEqualTo(especieId);
        assertThat(especie.getNombreEspanol()).isEqualTo("León");
        assertThat(especie.getNombreCientifico()).isEqualTo(nombreCientifico);
        assertThat(especie.getDescripcion()).isEqualTo("Gran felino africano");
        assertThat(especie.getZonaAsignada()).isEqualTo(zonaId);
    }

    @Test
    void debeFallarConIdNulo() {
        assertThatThrownBy(() -> new Especie(null, "León", nombreCientifico, 
                                             "Descripción", zonaId))
            .isInstanceOf(EspecieException.class)
            .hasMessageContaining("ID de la especie no puede ser nulo");
    }

    @Test
    void debeFallarConNombreEspanolVacio() {
        assertThatThrownBy(() -> new Especie(especieId, "", nombreCientifico, 
                                             "Descripción", zonaId))
            .isInstanceOf(EspecieException.class)
            .hasMessageContaining("nombre en español no puede estar vacío");
    }

    @Test
    void debeActualizarDescripcion() {
        var especie = new Especie(especieId, "León", nombreCientifico, 
                                  "Descripción original", zonaId);
        
        especie.actualizarDescripcion("Nueva descripción detallada");
        
        assertThat(especie.getDescripcion()).isEqualTo("Nueva descripción detallada");
    }

    @Test
    void debeReasignarZona() {
        var especie = new Especie(especieId, "León", nombreCientifico, 
                                  "Descripción", zonaId);
        var nuevaZona = ZonaId.generate();
        
        especie.reasignarZona(nuevaZona);
        
        assertThat(especie.getZonaAsignada()).isEqualTo(nuevaZona);
    }

    @Test
    void debeAgregarHabitat() {
        var especie = new Especie(especieId, "León", nombreCientifico, 
                                  "Descripción", zonaId);
        var habitatId = HabitatId.generate();
        
        especie.agregarHabitat(habitatId);
        
        assertThat(especie.habitaEn(habitatId)).isTrue();
        assertThat(especie.getHabitats()).contains(habitatId);
    }

    @Test
    void debeRemoverHabitat() {
        var especie = new Especie(especieId, "León", nombreCientifico, 
                                  "Descripción", zonaId);
        var habitatId = HabitatId.generate();
        
        especie.agregarHabitat(habitatId);
        especie.removerHabitat(habitatId);
        
        assertThat(especie.habitaEn(habitatId)).isFalse();
    }

    @Test
    void debeFallarAlRemoverHabitatInexistente() {
        var especie = new Especie(especieId, "León", nombreCientifico, 
                                  "Descripción", zonaId);
        var habitatId = HabitatId.generate();
        
        assertThatThrownBy(() -> especie.removerHabitat(habitatId))
            .isInstanceOf(EspecieException.class)
            .hasMessageContaining("no habita en ese hábitat");
    }
}
