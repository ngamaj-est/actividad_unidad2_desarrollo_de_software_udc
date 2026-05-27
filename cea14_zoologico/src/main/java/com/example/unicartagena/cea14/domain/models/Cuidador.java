package com.example.unicartagena.cea14.domain.models;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.example.unicartagena.cea14.domain.exceptions.ZoologicoException;
import com.example.unicartagena.cea14.domain.valueobjects.CuidadorId;
import com.example.unicartagena.cea14.domain.valueobjects.EspecieId;
import com.example.unicartagena.cea14.domain.valueobjects.InformacionContacto;

public class Cuidador {
    private final CuidadorId id;
    private String nombre;
    private InformacionContacto contacto;
    private LocalDate fechaIngreso;
    private final Map<EspecieId, LocalDate> especiesACargo;

    public Cuidador(CuidadorId id, String nombre, InformacionContacto contacto, LocalDate fechaIngreso) {
        if (id == null) {
            throw new ZoologicoException("El ID del cuidador no puede ser nulo");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new ZoologicoException("El nombre del cuidador no puede estar vacío");
        }
        if (contacto == null) {
            throw new ZoologicoException("El contacto no puede ser nulo");
        }
        if (fechaIngreso == null) {
            throw new ZoologicoException("La fecha de ingreso no puede ser nula");
        }
        if (fechaIngreso.isAfter(LocalDate.now())) {
            throw new ZoologicoException("La fecha de ingreso no puede ser futura");
        }

        this.id = id;
        this.nombre = nombre;
        this.contacto = contacto;
        this.fechaIngreso = fechaIngreso;
        this.especiesACargo = new HashMap<>();
    }

    // Métodos de negocio
    public void asignarEspecie(EspecieId especieId, LocalDate fechaAsignacion) {
        if (especieId == null) {
            throw new ZoologicoException("La especie no puede ser nula");
        }
        if (fechaAsignacion == null) {
            throw new ZoologicoException("La fecha de asignación no puede ser nula");
        }
        if (fechaAsignacion.isBefore(fechaIngreso)) {
            throw new ZoologicoException(
                "La fecha de asignación no puede ser anterior a la fecha de ingreso del cuidador"
            );
        }
        if (especiesACargo.containsKey(especieId)) {
            throw new ZoologicoException("El cuidador ya está asignado a esta especie");
        }

        this.especiesACargo.put(especieId, fechaAsignacion);
    }

    public void removerEspecie(EspecieId especieId) {
        if (!especiesACargo.containsKey(especieId)) {
            throw new ZoologicoException("El cuidador no está asignado a esta especie");
        }
        this.especiesACargo.remove(especieId);
    }

    public boolean cuidaEspecie(EspecieId especieId) {
        return especiesACargo.containsKey(especieId);
    }

    public int cantidadEspeciesACargo() {
        return especiesACargo.size();
    }

    public LocalDate obtenerFechaAsignacion(EspecieId especieId) {
        if (!especiesACargo.containsKey(especieId)) {
            throw new ZoologicoException("El cuidador no está asignado a esta especie");
        }
        return especiesACargo.get(especieId);
    }

    public void actualizarContacto(InformacionContacto nuevoContacto) {
        if (nuevoContacto == null) {
            throw new ZoologicoException("El contacto no puede ser nulo");
        }
        this.contacto = nuevoContacto;
    }

    public long aniosServicio() {
        return java.time.temporal.ChronoUnit.YEARS.between(fechaIngreso, LocalDate.now());
    }

    public boolean tieneExperienciaMayorA(int anios) {
        return aniosServicio() > anios;
    }

    // Getters
    public CuidadorId getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public InformacionContacto getContacto() {
        return contacto;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public Map<EspecieId, LocalDate> getEspeciesACargo() {
        return new HashMap<>(especiesACargo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cuidador cuidador = (Cuidador) o;
        return Objects.equals(id, cuidador.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Cuidador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", aniosServicio=" + aniosServicio() +
                ", especiesACargo=" + cantidadEspeciesACargo() +
                '}';
    }
}
