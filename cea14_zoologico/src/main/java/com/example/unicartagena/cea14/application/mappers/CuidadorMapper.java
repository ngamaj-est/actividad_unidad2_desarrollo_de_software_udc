package com.example.unicartagena.cea14.application.mappers;

import com.example.unicartagena.cea14.application.dto.CuidadorDTO;
import com.example.unicartagena.cea14.domain.models.Cuidador;
import com.example.unicartagena.cea14.domain.valueobjects.CuidadorId;
import com.example.unicartagena.cea14.domain.valueobjects.InformacionContacto;

public final class CuidadorMapper {
    private CuidadorMapper() {}

    public static Cuidador toDomain(CuidadorDTO dto) {
        CuidadorId id = (dto.id() == null || dto.id().isBlank()) ? CuidadorId.generate() : CuidadorId.of(dto.id());
        InformacionContacto info = new InformacionContacto(dto.telefono(), dto.email());
        return new Cuidador(id, dto.nombre(), info, dto.fechaIngreso());
    }

    public static CuidadorDTO toDTO(Cuidador cuidador) {
        if (cuidador == null) return null;
        return new CuidadorDTO(
                cuidador.getId().value(),
                cuidador.getNombre(),
                cuidador.getContacto().telefono(),
                cuidador.getContacto().email(),
                cuidador.getFechaIngreso()
        );
    }
}
