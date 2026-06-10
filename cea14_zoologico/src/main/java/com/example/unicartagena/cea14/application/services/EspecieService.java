package com.example.unicartagena.cea14.application.services;

import com.example.unicartagena.cea14.application.mappers.EspecieMapper;
import com.example.unicartagena.cea14.application.ports.out.EspecieOutPort;
import com.example.unicartagena.cea14.application.dto.EspecieDTO;
import com.example.unicartagena.cea14.application.ports.in.EspecieInPort;
import com.example.unicartagena.cea14.domain.valueobjects.EspecieId;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EspecieService implements EspecieInPort {

    private final EspecieOutPort repository;

    public EspecieService(EspecieOutPort repository) {
        this.repository = repository;
    }

    @Override
    public void guardar(EspecieDTO dto) {
        repository.guardar(EspecieMapper.toDomain(dto));
    }

    @Override
    public Optional<EspecieDTO> buscarPorId(String id) {
        return Optional.ofNullable(id)
                .map(EspecieId::of)
                .flatMap(repository::buscarPorId)
                .map(EspecieMapper::toDTO);
    }

    @Override
    public Optional<EspecieDTO> buscarPorPrefijo(String prefijo) {
        return repository.buscarPorPrefijo(prefijo).map(EspecieMapper::toDTO);
    }

    @Override
    public List<EspecieDTO> buscarTodas() {
        return repository.buscarTodas().stream().map(EspecieMapper::toDTO).collect(Collectors.toList());
    }
}
