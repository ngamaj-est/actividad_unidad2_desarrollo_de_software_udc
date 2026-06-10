package com.example.unicartagena.cea14.infrastructure.entrypoint.desktop.dto;

import com.example.unicartagena.cea14.domain.enums.TiposDeExamenMedicos;

public record CreateExamenMedicoRequest(
    String especieId,
    TiposDeExamenMedicos tipoExamen,
    String fechaProgramada // ISO datetime: yyyy-MM-dd'T'HH:mm:ss
) {

}
