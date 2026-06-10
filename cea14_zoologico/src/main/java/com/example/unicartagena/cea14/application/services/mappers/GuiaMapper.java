package com.example.unicartagena.cea14.application.mappers;

import com.example.unicartagena.cea14.application.dto.GuiaDTO;
import com.example.unicartagena.cea14.domain.models.Guia;
import com.example.unicartagena.cea14.domain.valueobjects.GuiaId;
import com.example.unicartagena.cea14.domain.valueobjects.InformacionContacto;

public final class GuiaMapper {
    private GuiaMapper() {}

    public static Guia toDomain(GuiaDTO dto) {
        GuiaId id = (dto.id() == null || dto.id().isBlank()) ? GuiaId.generate() : GuiaId.of(dto.id());
        InformacionContacto info = new InformacionContacto(dto.telefono(), dto.email());
        return new Guia(id, dto.nombre(), info, dto.fechaInicio());
    }

    public static GuiaDTO toDTO(Guia guia) {
        if (guia == null) return null;
        return new GuiaDTO(
                guia.getId().value(),
                guia.getNombre(),
                guia.getContacto().telefono(),
                guia.getContacto().email(),
                guia.getFechaInicio()
        );
    }
}
