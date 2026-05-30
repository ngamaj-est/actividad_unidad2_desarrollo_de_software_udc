package com.example.unicartagena.cea14.domain.repository;

import java.util.List;
import java.util.Optional;

import com.example.unicartagena.cea14.domain.models.Zona;
import com.example.unicartagena.cea14.domain.valueobjects.ZonaId;

public interface ZonaRepository {
      void guardar(Zona zona);
    Optional<Zona> buscarPorId(ZonaId id);
    Optional<Zona> buscarPorPrefijo(String prefijo);
    List<Zona> buscarTodas();
}
