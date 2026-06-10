package com.example.unicartagena.cea14.application.ports.out;

import com.example.unicartagena.cea14.domain.models.Itinerario;
import com.example.unicartagena.cea14.domain.valueobjects.ItinerarioId;

import java.util.List;
import java.util.Optional;

public interface ItinerarioOutPort {
    void guardar(Itinerario itinerario);
    Optional<Itinerario> buscarPorId(ItinerarioId id);
    Optional<Itinerario> buscarPorPrefijo(String prefijo);
    List<Itinerario> buscarTodos();
}
