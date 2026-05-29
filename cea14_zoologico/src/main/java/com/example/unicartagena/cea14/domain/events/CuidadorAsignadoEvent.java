package com.example.unicartagena.cea14.domain.events;

import java.time.Instant;
import java.time.LocalDate;

import com.example.unicartagena.cea14.domain.valueobjects.CuidadorId;
import com.example.unicartagena.cea14.domain.valueobjects.EspecieId;

public record CuidadorAsignadoEvent(
    String eventId,
    CuidadorId cuidadorId,
    EspecieId especieId,
    LocalDate fechaAsignacion,
    Instant fechaEvento
) {
    public CuidadorAsignadoEvent(CuidadorId cuidadorId, EspecieId especieId, 
                                 LocalDate fechaAsignacion) {
        this(
            java.util.UUID.randomUUID().toString(),
            cuidadorId,
            especieId,
            fechaAsignacion,
            Instant.now()
        );
    }
}
