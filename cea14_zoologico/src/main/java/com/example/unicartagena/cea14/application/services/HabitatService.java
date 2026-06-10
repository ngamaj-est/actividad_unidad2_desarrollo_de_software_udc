package com.example.unicartagena.cea14.application.services;

import com.example.unicartagena.cea14.application.dto.HabitatDTO;
import com.example.unicartagena.cea14.application.mappers.HabitatMapper;
import com.example.unicartagena.cea14.domain.repository.HabitatRepository;
import com.example.unicartagena.cea14.domain.valueobjects.HabitatId;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class HabitatService {
    private final HabitatRepository repository;

    public HabitatService(HabitatRepository repository) {
        this.repository = repository;
    }

    public void guardar(HabitatDTO dto) {
        repository.guardar(HabitatMapper.toDomain(dto));
    }

    public Optional<HabitatDTO> buscarPorPrefijo(String prefijo) {
        return repository.buscarPorPrefijo(prefijo).map(HabitatMapper::toDTO);
    }

    public List<HabitatDTO> buscarTodos() {
        return repository.buscarTodos().stream().map(HabitatMapper::toDTO).collect(Collectors.toList());
    }

    public Optional<HabitatDTO> buscarPorId(String id) {
        return Optional.ofNullable(id)
                .map(HabitatId::of)
                .flatMap(repository::buscarPorId)
                .map(HabitatMapper::toDTO);
    }
}
