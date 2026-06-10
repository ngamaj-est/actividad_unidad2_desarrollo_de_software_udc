package com.example.unicartagena.cea14.application.ports.in;

import java.util.List;
import java.util.Optional;

import com.example.unicartagena.cea14.application.services.dto.CuidadorDTO;

public interface CuidadorInPort {
    void guardar(CuidadorDTO dto);
    Optional<CuidadorDTO> buscarPorId(String id);
    List<CuidadorDTO> buscarTodos();
}
