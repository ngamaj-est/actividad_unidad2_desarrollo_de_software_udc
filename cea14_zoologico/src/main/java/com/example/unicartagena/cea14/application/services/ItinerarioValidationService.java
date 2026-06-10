package com.example.unicartagena.cea14.application.services;

import com.example.unicartagena.cea14.application.ports.in.ItinerarioValidationInPort;
import com.example.unicartagena.cea14.domain.exceptions.ItinerarioExceptions;
import com.example.unicartagena.cea14.domain.models.Itinerario;
import com.example.unicartagena.cea14.domain.models.Zona;

import java.util.List;

public class ItinerarioValidationService implements ItinerarioValidationInPort {

    @Override
    public boolean validarDuracionPorZonas(Itinerario itinerario, List<Zona> zonas) {
        if (itinerario == null) {
            throw new ItinerarioExceptions("El itinerario no puede ser nulo");
        }
        if (zonas == null || zonas.isEmpty()) {
            throw new ItinerarioExceptions("Debe haber al menos una zona");
        }

        int cantidadZonas = itinerario.cantidadZonasRecorridas();
        int duracionMinutos = itinerario.getDuracion().minutos();

        int duracionMinimaRequerida = cantidadZonas * 15;

        return duracionMinutos >= duracionMinimaRequerida;
    }

    @Override
    public int calcularEspeciesVisitables(Itinerario itinerario, List<Zona> zonas) {
        if (itinerario == null || zonas == null) {
            return 0;
        }

        return zonas.stream()
            .filter(zona -> itinerario.atraviesa(zona.getId()))
            .mapToInt(Zona::cantidadEspecies)
            .sum();
    }

    @Override
    public boolean validarCapacidadParaEspecies(Itinerario itinerario) {
        if (itinerario == null) {
            return false;
        }

        int especiesVisitadas = itinerario.getNumeroEspeciesVisitadas();
        int capacidadMinima = Math.min(especiesVisitadas * 2, 10); // mínimo 10 personas

        return itinerario.getCapacidadMaxima().capacidad() >= capacidadMinima;
    }
}
