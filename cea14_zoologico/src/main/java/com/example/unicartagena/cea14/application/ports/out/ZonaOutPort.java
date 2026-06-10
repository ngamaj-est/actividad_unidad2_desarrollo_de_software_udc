package com.example.unicartagena.cea14.application.ports.out;

import com.example.unicartagena.cea14.domain.models.Zona;
import com.example.unicartagena.cea14.domain.valueobjects.ZonaId;

import java.util.List;
import java.util.Optional;

public interface ZonaOutPort {
    void guardar(Zona zona);
    Optional<Zona> buscarPorId(ZonaId id);
    Optional<Zona> buscarPorPrefijo(String prefijo);
    List<Zona> buscarTodas();
}
