package com.example.unicartagena.cea14.infrastructure.entrypoint.desktop.dto;

import com.example.unicartagena.cea14.domain.enums.TiposDeExamenMedicos;

public record UpdateExamenMedicoRequest(
    String id,
    String especieId,
    TiposDeExamenMedicos tipoExamen,
    String fechaProgramada, // ISO datetime: yyyy-MM-dd'T'HH:mm:ss
    String resultado,
    String observaciones,
    Boolean completado
) {

}
