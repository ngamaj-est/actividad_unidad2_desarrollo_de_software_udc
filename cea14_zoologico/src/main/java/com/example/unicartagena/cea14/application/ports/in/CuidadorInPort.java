package com.example.unicartagena.cea14.application.ports.in;

import com.example.unicartagena.cea14.application.dto.CuidadorDTO;

import java.util.List;
import java.util.Optional;

public interface CuidadorInPort {
    void guardar(CuidadorDTO dto);
    Optional<CuidadorDTO> buscarPorId(String id);
    List<CuidadorDTO> buscarTodos();
}
