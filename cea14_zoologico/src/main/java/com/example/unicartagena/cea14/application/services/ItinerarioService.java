package com.example.unicartagena.cea14.application.services;

import com.example.unicartagena.cea14.application.dto.ItinerarioDTO;
import com.example.unicartagena.cea14.application.mappers.ItinerarioMapper;
import com.example.unicartagena.cea14.domain.repository.ItinerarioRepository;
import com.example.unicartagena.cea14.domain.valueobjects.ItinerarioId;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ItinerarioService {
    private final ItinerarioRepository repository;

    public ItinerarioService(ItinerarioRepository repository) {
        this.repository = repository;
    }

    public void guardar(ItinerarioDTO dto) {
        repository.guardar(ItinerarioMapper.toDomain(dto));
    }

    public Optional<ItinerarioDTO> buscarPorPrefijo(String prefijo) {
        return repository.buscarPorPrefijo(prefijo).map(ItinerarioMapper::toDTO);
    }

    public List<ItinerarioDTO> buscarTodos() {
        return repository.buscarTodos().stream().map(ItinerarioMapper::toDTO).collect(Collectors.toList());
    }

    public Optional<ItinerarioDTO> buscarPorId(String id) {
        return Optional.ofNullable(id)
                .map(ItinerarioId::of)
                .flatMap(repository::buscarPorId)
                .map(ItinerarioMapper::toDTO);
    }
}
