package com.example.unicartagena.cea14.domain.repository;

import java.util.List;
import java.util.Optional;

import com.example.unicartagena.cea14.domain.models.Guia;

public interface GuiaRepository {
    void guardar(Guia guia);
    Optional<Guia> buscarPorPrefijo(String prefijo);
    List<Guia> buscarTodas();
}
