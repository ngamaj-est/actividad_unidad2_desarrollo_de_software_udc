package com.example.unicartagena.cea14.application.ports.in;

import java.util.List;
import java.util.Optional;

import com.example.unicartagena.cea14.application.dto.ZonaDTO;

public interface ZonaInPort {
    void guardar(ZonaDTO dto);
    Optional<ZonaDTO> buscarPorId(String id);
    Optional<ZonaDTO> buscarPorPrefijo(String prefijo);
    List<ZonaDTO> buscarTodas();
}
