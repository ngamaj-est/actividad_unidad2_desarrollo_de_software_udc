package com.example.unicartagena.cea14.domain.events;

import com.example.unicartagena.cea14.domain.valueobjects.ItinerarioId;
import java.time.Instant;

public record CapacidadExcedidaEvent(
    String eventId,
    ItinerarioId itinerarioId,
    int capacidadMaxima,
    int cantidadSolicitada,
    Instant fechaEvento
) {
    public CapacidadExcedidaEvent(ItinerarioId itinerarioId, int capacidadMaxima, 
                                  int cantidadSolicitada) {
        this(
            java.util.UUID.randomUUID().toString(),
            itinerarioId,
            capacidadMaxima,
            cantidadSolicitada,
            Instant.now()
        );
    }
}