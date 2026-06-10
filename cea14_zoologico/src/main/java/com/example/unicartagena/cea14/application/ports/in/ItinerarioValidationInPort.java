package com.example.unicartagena.cea14.application.ports.in;

import com.example.unicartagena.cea14.domain.models.Itinerario;
import com.example.unicartagena.cea14.domain.models.Zona;

import java.util.List;

public interface ItinerarioValidationInPort {
    boolean validarDuracionPorZonas(Itinerario itinerario, List<Zona> zonas);
    int calcularEspeciesVisitables(Itinerario itinerario, List<Zona> zonas);
    boolean validarCapacidadParaEspecies(Itinerario itinerario);
}
