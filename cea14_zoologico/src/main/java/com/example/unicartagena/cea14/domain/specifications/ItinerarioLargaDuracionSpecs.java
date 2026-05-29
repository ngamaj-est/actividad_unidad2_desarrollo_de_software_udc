package com.example.unicartagena.cea14.domain.specifications;

import com.example.unicartagena.cea14.domain.models.Itinerario;

public class ItinerarioLargaDuracionSpecs implements Specification<Itinerario> {

    private int duracionMinima;

    public ItinerarioLargaDuracionSpecs(int duracionMinima) {
        this.duracionMinima = duracionMinima;
    }

     @Override
    public boolean isSatisfiedBy(Itinerario itinerario) {
        return itinerario != null &&
                itinerario.getDuracion().esMayorQueHoras(duracionMinima);
    }

}
