package com.example.unicartagena.cea14.domain.events;

import java.time.Instant;

import com.example.unicartagena.cea14.domain.enums.TiposDeExamenMedicos;
import com.example.unicartagena.cea14.domain.valueobjects.EspecieId;

public record ExamenMedicoCompletadoEvent(
    String eventId,
    String examenId,
    EspecieId especieId,
    TiposDeExamenMedicos tipoExamen,
    String resultado,
    Instant fechaEvento
) {
    public ExamenMedicoCompletadoEvent(String examenId, EspecieId especieId, 
                                       TiposDeExamenMedicos tipoExamen, String resultado) {
        this(
            java.util.UUID.randomUUID().toString(),
            examenId,
            especieId,
            tipoExamen,
            resultado,
            Instant.now()
        );
    }
}

