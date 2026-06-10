package com.example.unicartagena.cea14.application.services;

import com.example.unicartagena.cea14.application.ports.in.CuidadorInPort;
import com.example.unicartagena.cea14.application.ports.out.CuidadorOutPort;
import com.example.unicartagena.cea14.application.services.dto.CuidadorDTO;
import com.example.unicartagena.cea14.application.services.mappers.CuidadorMapper;
import com.example.unicartagena.cea14.domain.valueobjects.CuidadorId;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CuidadorService implements CuidadorInPort {
    private final CuidadorOutPort repository;

    public CuidadorService(CuidadorOutPort repository) {
        this.repository = repository;
    }

    @Override
    public void guardar(CuidadorDTO dto) {
        repository.save(CuidadorMapper.toDomain(dto));
    }

    @Override
    public Optional<CuidadorDTO> buscarPorId(String id) {
        return Optional.ofNullable(id)
                .map(CuidadorId::of)
                .flatMap(repository::findById)
                .map(CuidadorMapper::toDTO);
    }

    @Override
    public List<CuidadorDTO> buscarTodos() {
        return repository.findAll().stream().map(CuidadorMapper::toDTO).collect(Collectors.toList());
    }
}
