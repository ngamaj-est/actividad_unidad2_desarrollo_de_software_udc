package com.example.unicartagena.cea14.application.ports.in;

import java.util.List;
import java.util.Optional;

import com.example.unicartagena.cea14.application.services.dto.EspecieDTO;


public interface EspecieInPort {
    void guardar(EspecieDTO dto);
    Optional<EspecieDTO> buscarPorId(String id);
    Optional<EspecieDTO> buscarPorPrefijo(String prefijo);
    List<EspecieDTO> buscarTodas();
}
