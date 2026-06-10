package com.example.unicartagena.cea14.application.services;

import com.example.unicartagena.cea14.application.mappers.ItinerarioMapper;
import com.example.unicartagena.cea14.application.ports.out.ItinerarioOutPort;
import com.example.unicartagena.cea14.application.dto.ItinerarioDTO;
import com.example.unicartagena.cea14.application.ports.in.ItinerarioInPort;
import com.example.unicartagena.cea14.domain.valueobjects.ItinerarioId;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ItinerarioService implements ItinerarioInPort {
    private final ItinerarioOutPort repository;

    public ItinerarioService(ItinerarioOutPort repository) {
        this.repository = repository;
    }

    @Override
    public void guardar(ItinerarioDTO dto) {
        repository.guardar(ItinerarioMapper.toDomain(dto));
    }

    @Override
    public Optional<ItinerarioDTO> buscarPorPrefijo(String prefijo) {
        return repository.buscarPorPrefijo(prefijo).map(ItinerarioMapper::toDTO);
    }

    @Override
    public List<ItinerarioDTO> buscarTodos() {
        return repository.buscarTodos().stream().map(ItinerarioMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<ItinerarioDTO> buscarPorId(String id) {
        return Optional.ofNullable(id)
                .map(ItinerarioId::of)
                .flatMap(repository::buscarPorId)
                .map(ItinerarioMapper::toDTO);
    }
}
