package com.example.unicartagena.cea14.domain.valueobjects;

public record CuidadorId(String value) {
    public CuidadorId {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("El ID del cuidador no puede estar vacío");
        }
    }


    public static CuidadorId generate() {
        return new CuidadorId(java.util.UUID.randomUUID().toString());
    }


    public static CuidadorId of(String value) {
        return new CuidadorId(value);
    }


}
