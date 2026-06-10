package com.example.unicartagena.cea14.application.services.mappers;


import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.example.unicartagena.cea14.application.services.dto.EspecieDTO;
import com.example.unicartagena.cea14.domain.models.Especie;
import com.example.unicartagena.cea14.domain.valueobjects.EspecieId;
import com.example.unicartagena.cea14.domain.valueobjects.HabitatId;
import com.example.unicartagena.cea14.domain.valueobjects.NombreCientificoEspecies;
import com.example.unicartagena.cea14.domain.valueobjects.ZonaId;

public final class EspecieMapper {

    private EspecieMapper() {}

    public static Especie toDomain(EspecieDTO dto) {
        EspecieId id = (dto.id() == null || dto.id().isBlank())
                ? EspecieId.generate()
                : EspecieId.of(dto.id());

        NombreCientificoEspecies nombreCientifico = new NombreCientificoEspecies(
                dto.nombreCientificoGenero(), dto.nombreCientificoEspecie());

        Especie especie = new Especie(id, dto.nombreEspanol(), nombreCientifico,
                dto.descripcion(), ZonaId.of(dto.zonaId()));

        List<String> habitats = dto.habitats() == null ? Collections.emptyList() : dto.habitats();
        habitats.forEach(h -> especie.agregarHabitat(HabitatId.of(h)));

        return especie;
    }

    public static EspecieDTO toDTO(Especie especie) {
        if (especie == null) return null;
        List<String> habitats = especie.getHabitats().stream()
                .map(HabitatId::value)
                .collect(Collectors.toList());

        return new EspecieDTO(
                especie.getId().value(),
                especie.getNombreEspanol(),
                especie.getNombreCientifico().genero(),
                especie.getNombreCientifico().especie(),
                especie.getDescripcion(),
                especie.getZonaAsignada().value(),
                habitats
        );
    }
}
