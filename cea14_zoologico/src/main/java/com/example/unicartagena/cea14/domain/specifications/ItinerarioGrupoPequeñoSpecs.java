package com.example.unicartagena.cea14.domain.specifications;

import com.example.unicartagena.cea14.domain.models.Itinerario;

public class ItinerarioGrupoPequeñoSpecs implements Specification<Itinerario> {
    private int capacidadMaxima = 0;
    
    public ItinerarioGrupoPequeñoSpecs(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }
    
    @Override
    public boolean isSatisfiedBy(Itinerario itinerario) {
        return itinerario != null && 
               itinerario.getCapacidadMaxima().capacidad() <= capacidadMaxima;
    }
}
