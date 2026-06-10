package com.example.unicartagena.cea14.domain.repository;

import java.util.List;
import java.util.Optional;

import com.example.unicartagena.cea14.domain.models.Habitat;
import com.example.unicartagena.cea14.domain.valueobjects.HabitatId;

public interface HabitatRepository {
    void guardar(Habitat habitat);
    Optional<Habitat> buscarPorPrefijo(String prefijo);
    Optional<Habitat> buscarPorId(HabitatId id);
    List<Habitat> buscarTodos();
}
