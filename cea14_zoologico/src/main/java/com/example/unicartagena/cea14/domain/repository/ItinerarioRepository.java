package com.example.unicartagena.cea14.domain.repository;

import java.util.List;
import java.util.Optional;

import com.example.unicartagena.cea14.domain.models.Itinerario;
import com.example.unicartagena.cea14.domain.valueobjects.ItinerarioId;

public interface ItinerarioRepository {
    void guardar(Itinerario itinerario);
    Optional<Itinerario> buscarPorPrefijo(String prefijo);
    Optional<Itinerario> buscarPorId(ItinerarioId id);
    List<Itinerario> buscarTodos();
}
