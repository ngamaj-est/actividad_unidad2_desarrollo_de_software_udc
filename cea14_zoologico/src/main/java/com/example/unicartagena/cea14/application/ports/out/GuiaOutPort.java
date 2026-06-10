package com.example.unicartagena.cea14.application.ports.out;

import com.example.unicartagena.cea14.domain.models.Guia;

import java.util.List;
import java.util.Optional;

public interface GuiaOutPort {
    void guardar(Guia guia);
    Optional<Guia> buscarPorPrefijo(String prefijo);
    List<Guia> buscarTodas();
}
