package com.example.unicartagena.cea14.domain.repository;

import java.util.List;
import java.util.Optional;

import com.example.unicartagena.cea14.domain.models.Itinerario;

public interface ItinerarioRepository {
    void guardar(Itinerario itinerario);
    Optional<Itinerario> buscarPorPrefijo(String prefijo);
    List<Itinerario> buscarTodos();
}
