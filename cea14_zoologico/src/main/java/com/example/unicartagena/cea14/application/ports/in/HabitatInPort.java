package com.example.unicartagena.cea14.application.ports.in;

import com.example.unicartagena.cea14.application.dto.HabitatDTO;

import java.util.List;
import java.util.Optional;

public interface HabitatInPort {
    void guardar(HabitatDTO dto);
    Optional<HabitatDTO> buscarPorId(String id);
    Optional<HabitatDTO> buscarPorPrefijo(String prefijo);
    List<HabitatDTO> buscarTodos();
}
