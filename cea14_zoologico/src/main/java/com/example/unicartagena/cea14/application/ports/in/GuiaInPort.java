package com.example.unicartagena.cea14.application.ports.in;

import java.util.List;
import java.util.Optional;

import com.example.unicartagena.cea14.application.dto.GuiaDTO;

public interface GuiaInPort {
    void guardar(GuiaDTO dto);
    Optional<GuiaDTO> buscarPorPrefijo(String prefijo);
    List<GuiaDTO> buscarTodas();
}
