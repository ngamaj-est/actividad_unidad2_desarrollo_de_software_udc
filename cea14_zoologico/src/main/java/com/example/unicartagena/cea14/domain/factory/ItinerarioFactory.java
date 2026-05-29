package com.example.unicartagena.cea14.domain.factory;

import com.example.unicartagena.cea14.domain.models.Itinerario;
import com.example.unicartagena.cea14.domain.valueobjects.CapacidadVisitantes;
import com.example.unicartagena.cea14.domain.valueobjects.ItinerarioId;
import com.example.unicartagena.cea14.domain.valueobjects.DuracionItinerario;

public class ItinerarioFactory {

    /**
     * Crea un nuevo itinerario con ID generado automáticamente
     */
    public static Itinerario crear(String codigo, int duracionMinutos, 
                                   double longitudKm, int capacidad, 
                                   int numeroEspecies) {
        ItinerarioId id = ItinerarioId.generate();
        DuracionItinerario duracion = new DuracionItinerario(duracionMinutos);
        CapacidadVisitantes capacidadVisitantes = new CapacidadVisitantes(capacidad);
        
        return new Itinerario(id, codigo, duracion, longitudKm, 
                             capacidadVisitantes, numeroEspecies);
    }

    /**
     * Builder para construcción fluida de Itinerario
     */
    public static class Builder {
        private String codigo;
        private int duracionMinutos;
        private double longitudKm;
        private int capacidad;
        private int numeroEspecies;

        public Builder conCodigo(String codigo) {
            this.codigo = codigo;
            return this;
        }

        public Builder conDuracion(int minutos) {
            this.duracionMinutos = minutos;
            return this;
        }

        public Builder conDuracionHoras(int horas, int minutos) {
            this.duracionMinutos = (horas * 60) + minutos;
            return this;
        }

        public Builder conLongitud(double km) {
            this.longitudKm = km;
            return this;
        }

        public Builder conCapacidad(int capacidad) {
            this.capacidad = capacidad;
            return this;
        }

        public Builder visitaEspecies(int numero) {
            this.numeroEspecies = numero;
            return this;
        }

        public Itinerario build() {
            return ItinerarioFactory.crear(codigo, duracionMinutos, longitudKm, 
                                          capacidad, numeroEspecies);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
