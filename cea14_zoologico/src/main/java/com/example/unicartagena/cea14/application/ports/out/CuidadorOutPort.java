package com.example.unicartagena.cea14.application.ports.out;

import com.example.unicartagena.cea14.domain.models.Cuidador;
import com.example.unicartagena.cea14.domain.valueobjects.CuidadorId;

import java.util.List;
import java.util.Optional;

public interface CuidadorOutPort {
    void save(Cuidador cuidador);
    Optional<Cuidador> findById(CuidadorId id);
    List<Cuidador> findAll();
}
