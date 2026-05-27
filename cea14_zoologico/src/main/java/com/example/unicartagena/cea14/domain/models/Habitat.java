package com.example.unicartagena.cea14.domain.models;

import java.util.Objects;
import com.example.unicartagena.cea14.domain.exceptions.ZoologicoException;
import com.example.unicartagena.cea14.domain.valueobjects.HabitatId;
import com.example.unicartagena.cea14.domain.enums.TiposDeClima;
import com.example.unicartagena.cea14.domain.enums.TiposDeVegetacion;
public class Habitat {
    private final HabitatId id;
    private String nombre;
    private TiposDeClima clima;
    private TiposDeVegetacion vegetacion;

    public Habitat(HabitatId id, String nombre, TiposDeClima clima, 
                   TiposDeVegetacion vegetacion) {
        if (id == null) {
            throw new ZoologicoException("El ID del hábitat no puede ser nulo");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new ZoologicoException("El nombre del hábitat no puede estar vacío");
        }
        if (clima == null) {
            throw new ZoologicoException("El clima no puede ser nulo");
        }
        if (vegetacion == null) {
            throw new ZoologicoException("El tipo de vegetación no puede ser nulo");
        }

        this.id = id;
        this.nombre = nombre;
        this.clima = clima;
        this.vegetacion = vegetacion;
    }

    
    public void actualizarClima(TiposDeClima nuevoClima) {
        if (nuevoClima == null) {
            throw new ZoologicoException("El clima no puede ser nulo");
        }
        this.clima = nuevoClima;
    }

    public void actualizarVegetacion(TiposDeVegetacion nuevaVegetacion) {
        if (nuevaVegetacion == null) {
            throw new ZoologicoException("La vegetación no puede ser nula");
        }
        this.vegetacion = nuevaVegetacion;
    }

    // Getters
    public HabitatId getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public TiposDeClima getClima() {
        return clima;
    }

    public TiposDeVegetacion getVegetacion() {
        return vegetacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Habitat habitat = (Habitat) o;
        return Objects.equals(id, habitat.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Habitat{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", clima=" + clima +
                ", vegetacion=" + vegetacion +
                '}';
    }
}
