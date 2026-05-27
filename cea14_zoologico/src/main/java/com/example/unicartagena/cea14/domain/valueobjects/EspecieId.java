package com.example.unicartagena.cea14.domain.valueobjects;

public record EspecieId(String value) {
    public EspecieId {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("El ID de la especie no puede estar vacío");
        }
    }


    public static EspecieId generate() {
        return new EspecieId(java.util.UUID.randomUUID().toString());
    }


    public static EspecieId of(String value) {
        return new EspecieId(value);
    }


}
