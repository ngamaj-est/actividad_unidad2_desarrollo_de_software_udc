package com.example.unicartagena.cea14.domain.valueobjects;

public record NombreCientificoEspecies(String genero, String especie) {
    public NombreCientificoEspecies {
        if (genero == null || genero.isBlank()) {
            throw new IllegalArgumentException("El género no puede estar vacío");
        }
        if (especie == null || especie.isBlank()) {
            throw new IllegalArgumentException("La especie no puede estar vacía");
        }
        if (!Character.isUpperCase(genero.charAt(0))) {
            throw new IllegalArgumentException("El género debe comenzar con mayúscula");
        }
        if (!Character.isLowerCase(especie.charAt(0))) {
            throw new IllegalArgumentException("La especie debe comenzar con minúscula");
        }
    }
    public String nombreCompleto() {
        return getNombreCompleto();
    }

    public String getNombreCompleto() {
        return genero + " " + especie;
    }

    @Override
    public String toString() {
        return getNombreCompleto();
    }
}
