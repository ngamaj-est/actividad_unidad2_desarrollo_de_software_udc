package com.example.unicartagena.cea14.application.services;

import com.example.unicartagena.cea14.application.dto.ZonaDTO;
import com.example.unicartagena.cea14.application.mappers.ZonaMapper;
import com.example.unicartagena.cea14.domain.repository.ZonaRepository;
import com.example.unicartagena.cea14.domain.valueobjects.ZonaId;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ZonaService {
    private final ZonaRepository repository;

    public ZonaService(ZonaRepository repository) {
        this.repository = repository;
    }

    public void guardar(ZonaDTO dto) {
        repository.guardar(ZonaMapper.toDomain(dto));
    }

    public Optional<ZonaDTO> buscarPorId(String id) {
        return Optional.ofNullable(id)
                .map(ZonaId::of)
                .flatMap(repository::buscarPorId)
                .map(ZonaMapper::toDTO);
    }

    public Optional<ZonaDTO> buscarPorPrefijo(String prefijo) {
        return repository.buscarPorPrefijo(prefijo).map(ZonaMapper::toDTO);
    }

    public List<ZonaDTO> buscarTodas() {
        return repository.buscarTodas().stream().map(ZonaMapper::toDTO).collect(Collectors.toList());
    }
}
