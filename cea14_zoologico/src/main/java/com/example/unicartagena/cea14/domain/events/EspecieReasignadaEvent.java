package com.example.unicartagena.cea14.domain.events;

import java.time.Instant;

import com.example.unicartagena.cea14.domain.valueobjects.EspecieId;
import com.example.unicartagena.cea14.domain.valueobjects.ZonaId;

public record EspecieReasignadaEvent(
    String eventId,
    EspecieId especieId,
    ZonaId zonaAnterior,
    ZonaId zonaNueva,
    Instant fechaEvento
) {
    public EspecieReasignadaEvent(EspecieId especieId, ZonaId zonaAnterior, ZonaId zonaNueva) {
        this(
            java.util.UUID.randomUUID().toString(),
            especieId,
            zonaAnterior,
            zonaNueva,
            Instant.now()
        );
    }
}
