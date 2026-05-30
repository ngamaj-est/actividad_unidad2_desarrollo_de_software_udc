package com.example.unicartagena.cea14.domain.repository;

import java.util.List;
import java.util.Optional;

import com.example.unicartagena.cea14.domain.models.Habitat;

public interface HabitatRepository {
    void guardar(Habitat habitat);
    Optional<Habitat> buscarPorPrefijo(String prefijo);
    List<Habitat> buscarTodos();
}
