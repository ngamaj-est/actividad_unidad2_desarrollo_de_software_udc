package com.example.unicartagena.cea14.application.services;

import com.example.unicartagena.cea14.application.dto.GuiaDTO;
import com.example.unicartagena.cea14.application.mappers.GuiaMapper;
import com.example.unicartagena.cea14.domain.repository.GuiaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GuiaService {
    private final GuiaRepository repository;

    public GuiaService(GuiaRepository repository) {
        this.repository = repository;
    }

    public void guardar(GuiaDTO dto) {
        repository.guardar(GuiaMapper.toDomain(dto));
    }

    public Optional<GuiaDTO> buscarPorPrefijo(String prefijo) {
        return repository.buscarPorPrefijo(prefijo).map(GuiaMapper::toDTO);
    }

    public List<GuiaDTO> buscarTodas() {
        return repository.buscarTodas().stream().map(GuiaMapper::toDTO).collect(Collectors.toList());
    }
}
