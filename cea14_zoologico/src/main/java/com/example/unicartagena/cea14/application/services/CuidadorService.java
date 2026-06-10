package com.example.unicartagena.cea14.application.services;

import com.example.unicartagena.cea14.application.dto.CuidadorDTO;
import com.example.unicartagena.cea14.application.mappers.CuidadorMapper;
import com.example.unicartagena.cea14.domain.repository.CuidadorRepository;
import com.example.unicartagena.cea14.domain.valueobjects.CuidadorId;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CuidadorService {
    private final CuidadorRepository repository;

    public CuidadorService(CuidadorRepository repository) {
        this.repository = repository;
    }

    public void guardar(CuidadorDTO dto) {
        repository.save(CuidadorMapper.toDomain(dto));
    }

    public Optional<CuidadorDTO> buscarPorId(String id) {
        return Optional.ofNullable(id)
                .map(CuidadorId::of)
                .flatMap(repository::findById)
                .map(CuidadorMapper::toDTO);
    }

    public List<CuidadorDTO> buscarTodos() {
        return repository.findAll().stream().map(CuidadorMapper::toDTO).collect(Collectors.toList());
    }
}
