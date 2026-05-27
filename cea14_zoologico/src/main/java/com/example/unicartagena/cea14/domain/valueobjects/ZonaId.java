package com.example.unicartagena.cea14.domain.valueobjects;

import java.util.UUID;

public record ZonaId(String value) {
    public ZonaId {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("El ID de la zona no puede estar vacío");
        }
    }
    public static ZonaId generate() {
        return new ZonaId(UUID.randomUUID().toString());
    }
    public static ZonaId of(String value) {
        return new ZonaId(value);
    }
}
