package com.example.unicartagena.cea14.application.ports.out;

import com.example.unicartagena.cea14.domain.models.Habitat;
import com.example.unicartagena.cea14.domain.valueobjects.HabitatId;

import java.util.List;
import java.util.Optional;

public interface HabitatOutPort {
    void guardar(Habitat habitat);
    Optional<Habitat> buscarPorId(HabitatId id);
    Optional<Habitat> buscarPorPrefijo(String prefijo);
    List<Habitat> buscarTodos();
}
