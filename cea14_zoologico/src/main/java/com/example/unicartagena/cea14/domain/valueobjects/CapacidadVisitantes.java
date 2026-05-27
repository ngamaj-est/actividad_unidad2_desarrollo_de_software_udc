package com.example.unicartagena.cea14.domain.valueobjects;

public record CapacidadVisitantes(int capacidad) {
    public CapacidadVisitantes {
        if (capacidad < 0) {
            throw new IllegalArgumentException("La capacidad de visitantes no puede ser negativa");
        }
        if (capacidad > 30) {
            throw new IllegalArgumentException("La capacidad de visitantes no puede ser mayor a 30");
        }
    }
    @Override
    public String toString() {
        return capacidad + " visitantes";
    }
    public boolean permiteGrupo(int cantidadVisitantes) {
        throw new UnsupportedOperationException("Unimplemented method 'permiteGrupo'");
    }
}
