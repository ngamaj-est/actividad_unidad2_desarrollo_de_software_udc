package com.example.unicartagena.cea14.application.services.mappers;

import com.example.unicartagena.cea14.application.services.dto.HabitatDTO;
import com.example.unicartagena.cea14.domain.enums.TiposDeClima;
import com.example.unicartagena.cea14.domain.enums.TiposDeVegetacion;
import com.example.unicartagena.cea14.domain.models.Habitat;
import com.example.unicartagena.cea14.domain.valueobjects.HabitatId;

public final class HabitatMapper {
    private HabitatMapper() {}

    public static Habitat toDomain(HabitatDTO dto) {
        HabitatId id = (dto.id() == null || dto.id().isBlank()) ? HabitatId.generate() : HabitatId.of(dto.id());
        TiposDeClima clima = TiposDeClima.valueOf(dto.clima());
        TiposDeVegetacion vegetacion = TiposDeVegetacion.valueOf(dto.vegetacion());
        return new Habitat(id, dto.nombre(), clima, vegetacion);
    }

    public static HabitatDTO toDTO(Habitat habitat) {
        if (habitat == null) return null;
        return new HabitatDTO(
                habitat.getId().value(),
                habitat.getNombre(),
                habitat.getClima().name(),
                habitat.getVegetacion().name()
        );
    }
}
