package com.example.unicartagena.cea14.application.mappers;

import com.example.unicartagena.cea14.application.dto.ItinerarioDTO;
import com.example.unicartagena.cea14.domain.models.Itinerario;
import com.example.unicartagena.cea14.domain.valueobjects.CapacidadVisitantes;
import com.example.unicartagena.cea14.domain.valueobjects.DuracionItinerario;
import com.example.unicartagena.cea14.domain.valueobjects.ItinerarioId;
import com.example.unicartagena.cea14.domain.valueobjects.ZonaId;

import java.util.List;
import java.util.stream.Collectors;

public final class ItinerarioMapper {
    private ItinerarioMapper() {}

    public static Itinerario toDomain(ItinerarioDTO dto) {
        ItinerarioId id = (dto.id() == null || dto.id().isBlank()) ? ItinerarioId.generate() : ItinerarioId.of(dto.id());
        DuracionItinerario duracion = new DuracionItinerario(dto.duracionMinutos());
        CapacidadVisitantes capacidad = new CapacidadVisitantes(dto.capacidadMaxima());
        Itinerario it = new Itinerario(id, dto.codigo(), duracion, dto.longitudKm(), capacidad, dto.numeroEspeciesVisitadas());
        if (dto.zonasRecorridas() != null) {
            dto.zonasRecorridas().forEach(z -> it.agregarZona(ZonaId.of(z)));
        }
        return it;
    }

    public static ItinerarioDTO toDTO(Itinerario it) {
        if (it == null) return null;
        List<String> zonas = it.getZonasRecorridas().stream().map(ZonaId::value).collect(Collectors.toList());
        return new ItinerarioDTO(
                it.getId().value(),
                it.getCodigo(),
                it.getDuracion().minutos(),
                it.getLongitudKm(),
                it.getCapacidadMaxima().capacidad(),
                it.getNumeroEspeciesVisitadas(),
                zonas
        );
    }
}
