package com.example.unicartagena.cea14.application.services;

import com.example.unicartagena.cea14.application.dto.GuiaDTO;
import com.example.unicartagena.cea14.application.mappers.GuiaMapper;
import com.example.unicartagena.cea14.application.ports.out.GuiaOutPort;
import com.example.unicartagena.cea14.application.ports.in.GuiaInPort;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GuiaService implements GuiaInPort {
    private final GuiaOutPort repository;

    public GuiaService(GuiaOutPort repository) {
        this.repository = repository;
    }

    @Override
    public void guardar(GuiaDTO dto) {
        repository.guardar(GuiaMapper.toDomain(dto));
    }

    @Override
    public Optional<GuiaDTO> buscarPorPrefijo(String prefijo) {
        return repository.buscarPorPrefijo(prefijo).map(GuiaMapper::toDTO);
    }

    @Override
    public List<GuiaDTO> buscarTodas() {
        return repository.buscarTodas().stream().map(GuiaMapper::toDTO).collect(Collectors.toList());
    }
}
