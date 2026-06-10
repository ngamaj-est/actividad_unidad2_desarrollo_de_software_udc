package com.example.unicartagena.cea14.application.ports.out;

import com.example.unicartagena.cea14.domain.models.Especie;
import com.example.unicartagena.cea14.domain.valueobjects.EspecieId;

import java.util.List;
import java.util.Optional;

public interface EspecieOutPort {
    void guardar(Especie especie);
    Optional<Especie> buscarPorId(EspecieId id);
    Optional<Especie> buscarPorPrefijo(String prefijo);
    List<Especie> buscarTodas();
}
