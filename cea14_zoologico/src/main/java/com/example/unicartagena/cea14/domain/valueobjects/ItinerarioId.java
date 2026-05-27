package com.example.unicartagena.cea14.domain.valueobjects;

public record ItinerarioId(String value) {
    public ItinerarioId {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("El ID del itinerario no puede estar vacío");
        }
    }
    public static ItinerarioId generate() {
        return new ItinerarioId(java.util.UUID.randomUUID().toString());
    }
    public static ItinerarioId of(String value) {
        return new ItinerarioId(value);
    }
}
