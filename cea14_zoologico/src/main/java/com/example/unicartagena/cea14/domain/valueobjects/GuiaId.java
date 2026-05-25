package com.example.unicartagena.cea14.domain.valueobjects;

public record GuiaId(String value) {
    public GuiaId {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("El ID del guía no puede estar vacío");
        }
    }

    public static GuiaId generate() {
        return new GuiaId(java.util.UUID.randomUUID().toString());
    }

    public static GuiaId of(String value) {
        return new GuiaId(value);
    }
}
