package com.example.unicartagena.cea14.application.services.mappers;

import com.example.unicartagena.cea14.application.services.dto.ZonaDTO;
import com.example.unicartagena.cea14.domain.models.Zona;
import com.example.unicartagena.cea14.domain.valueobjects.ExtensionTerreno;
import com.example.unicartagena.cea14.domain.valueobjects.ZonaId;

public final class ZonaMapper {
    private ZonaMapper() {}

    public static Zona toDomain(ZonaDTO dto) {
        ZonaId id = (dto.id() == null || dto.id().isBlank()) ? ZonaId.generate() : ZonaId.of(dto.id());
        ExtensionTerreno ext = new ExtensionTerreno(dto.extensionMetrosCuadrados());
        return new Zona(id, dto.nombre(), ext);
    }

    public static ZonaDTO toDTO(Zona zona) {
        if (zona == null) return null;
        return new ZonaDTO(zona.getId().value(), zona.getNombre(), zona.getExtension().metrosCuadrados());
    }
}
