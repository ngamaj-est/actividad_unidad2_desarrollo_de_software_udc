package com.example.unicartagena.cea14.domain.valueobjects;

public record InformacionContacto(String telefono, String email) {
    public InformacionContacto {
        if (telefono == null || telefono.isBlank()) {
            throw new IllegalArgumentException("El teléfono no puede estar vacío");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("El email no puede estar vacío");
        }
        if (!telefono.matches("^[0-9\\-\\+\\s()]+$")) {
            throw new IllegalArgumentException("El teléfono no es válido");
        }
        if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("El email no es válido");
        }
    }
}
