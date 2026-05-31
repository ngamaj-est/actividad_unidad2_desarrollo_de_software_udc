package com.example.unicartagena.cea14.domain.valueobjects;

import com.example.unicartagena.cea14.domain.exceptions.CapacidadException;

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
    public void permiteGrupo(int cantidadVisitantes) {
        if (cantidadVisitantes > capacidad) {
            throw new CapacidadException(
                "La cantidad de visitantes (" + cantidadVisitantes + 
                ") excede la capacidad máxima (" + capacidad + ")"
            );
        }
    }
}
