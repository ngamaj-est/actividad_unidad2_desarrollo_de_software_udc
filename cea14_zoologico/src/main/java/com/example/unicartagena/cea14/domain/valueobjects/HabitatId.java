package com.example.unicartagena.cea14.domain.valueobjects;

public record HabitatId(String value) {
    public HabitatId {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("El ID del hábitat no puede estar vacío");
        }
    }


    public static HabitatId generate() {
        return new HabitatId(java.util.UUID.randomUUID().toString());
    }


    public static HabitatId of(String value) {
        return new HabitatId(value);
    }
}
