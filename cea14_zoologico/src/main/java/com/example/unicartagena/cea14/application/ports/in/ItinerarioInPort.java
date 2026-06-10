package com.example.unicartagena.cea14.application.ports.in;

import java.util.List;
import java.util.Optional;

import com.example.unicartagena.cea14.application.dto.ItinerarioDTO;

public interface ItinerarioInPort {
    void guardar(ItinerarioDTO dto);
    Optional<ItinerarioDTO> buscarPorId(String id);
    Optional<ItinerarioDTO> buscarPorPrefijo(String prefijo);
    List<ItinerarioDTO> buscarTodos();
}
