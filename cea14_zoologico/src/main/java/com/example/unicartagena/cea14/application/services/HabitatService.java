package com.example.unicartagena.cea14.application.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.unicartagena.cea14.application.ports.in.HabitatInPort;
import com.example.unicartagena.cea14.application.ports.out.HabitatOutPort;
import com.example.unicartagena.cea14.application.services.dto.HabitatDTO;
import com.example.unicartagena.cea14.application.services.mappers.HabitatMapper;
import com.example.unicartagena.cea14.domain.valueobjects.HabitatId;

public class HabitatService implements HabitatInPort {
    private final HabitatOutPort repository;

    public HabitatService(HabitatOutPort repository) {
        this.repository = repository;
    }

    @Override
    public void guardar(HabitatDTO dto) {
        repository.guardar(HabitatMapper.toDomain(dto));
    }

    @Override
    public Optional<HabitatDTO> buscarPorPrefijo(String prefijo) {
        return repository.buscarPorPrefijo(prefijo).map(HabitatMapper::toDTO);
    }

    @Override
    public List<HabitatDTO> buscarTodos() {
        return repository.buscarTodos().stream().map(HabitatMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<HabitatDTO> buscarPorId(String id) {
        return Optional.ofNullable(id)
                .map(HabitatId::of)
                .flatMap(repository::buscarPorId)
                .map(HabitatMapper::toDTO);
    }
}
