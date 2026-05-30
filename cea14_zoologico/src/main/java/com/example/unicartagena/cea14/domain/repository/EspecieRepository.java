package com.example.unicartagena.cea14.domain.repository;

import java.util.List;
import java.util.Optional;

import com.example.unicartagena.cea14.domain.models.Especie;
import com.example.unicartagena.cea14.domain.valueobjects.EspecieId;

public interface EspecieRepository {
    void guardar(Especie especie);
    Optional<Especie> buscarPorId(EspecieId id);
    Optional<Especie> buscarPorPrefijo(String prefijo);
    List<Especie> buscarTodas();
}
