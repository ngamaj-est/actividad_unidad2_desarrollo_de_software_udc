package com.example.unicartagena.cea14.application.ports.in;

import com.example.unicartagena.cea14.application.dto.GuiaDTO;

import java.util.List;
import java.util.Optional;

public interface GuiaInPort {
    void guardar(GuiaDTO dto);
    Optional<GuiaDTO> buscarPorPrefijo(String prefijo);
    List<GuiaDTO> buscarTodas();
}
