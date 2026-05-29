package com.example.unicartagena.cea14.domain.factory;

import com.example.unicartagena.cea14.domain.models.Especie;
import com.example.unicartagena.cea14.domain.valueobjects.EspecieId;
import com.example.unicartagena.cea14.domain.valueobjects.NombreCientificoEspecies;
import com.example.unicartagena.cea14.domain.valueobjects.ZonaId; 

public class EspecieFactory {
    
    public static Especie crear(String nombreEspanol, String genero, String especie,
                                String descripcion, ZonaId zonaId) {
        EspecieId id = EspecieId.generate();
        NombreCientificoEspecies nombreCientifico = new NombreCientificoEspecies(genero, especie);
        
        return new Especie(id, nombreEspanol, nombreCientifico, descripcion, zonaId);
    }

    public static Especie reconstruir(String id, String nombreEspanol, String genero, 
                                      String especie, String descripcion, String zonaId) {
        EspecieId especieId = EspecieId.of(id);
        NombreCientificoEspecies nombreCientifico = new NombreCientificoEspecies(genero, especie);
        ZonaId zonaIdVO = ZonaId.of(zonaId);
        
        return new Especie(especieId, nombreEspanol, nombreCientifico, descripcion, zonaIdVO);
    }

    public static class Builder {
        private String nombreEspanol;
        private String genero;
        private String especie;
        private String descripcion;
        private ZonaId zonaId;

        public Builder conNombreEspanol(String nombreEspanol) {
            this.nombreEspanol = nombreEspanol;
            return this;
        }

        public Builder conNombreCientifico(String genero, String especie) {
            this.genero = genero;
            this.especie = especie;
            return this;
        }

        public Builder conDescripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }

        public Builder enZona(ZonaId zonaId) {
            this.zonaId = zonaId;
            return this;
        }

        public Especie build() {
            return EspecieFactory.crear(nombreEspanol, genero, especie, descripcion, zonaId);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
