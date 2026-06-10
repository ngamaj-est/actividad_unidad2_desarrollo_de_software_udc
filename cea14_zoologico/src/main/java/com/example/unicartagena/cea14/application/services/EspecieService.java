package com.example.unicartagena.cea14.application.services;

import com.example.unicartagena.cea14.application.dto.EspecieDTO;
import com.example.unicartagena.cea14.application.mappers.EspecieMapper;
import com.example.unicartagena.cea14.domain.repository.EspecieRepository;
import com.example.unicartagena.cea14.domain.valueobjects.EspecieId;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EspecieService {

    private final EspecieRepository repository;

    public EspecieService(EspecieRepository repository) {
        this.repository = repository;
    }

    public void guardar(EspecieDTO dto) {
        repository.guardar(EspecieMapper.toDomain(dto));
    }

    public Optional<EspecieDTO> buscarPorId(String id) {
        return Optional.ofNullable(id)
                .map(EspecieId::of)
                .flatMap(repository::buscarPorId)
                .map(EspecieMapper::toDTO);
    }

    public Optional<EspecieDTO> buscarPorPrefijo(String prefijo) {
        return repository.buscarPorPrefijo(prefijo).map(EspecieMapper::toDTO);
    }

    public List<EspecieDTO> buscarTodas() {
        return repository.buscarTodas().stream().map(EspecieMapper::toDTO).collect(Collectors.toList());
    }
}
