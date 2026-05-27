package com.example.unicartagena.cea14.domain.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import com.example.unicartagena.cea14.domain.exceptions.ZoologicoException;
import com.example.unicartagena.cea14.domain.valueobjects.GuiaId;
import com.example.unicartagena.cea14.domain.valueobjects.InformacionContacto;
import com.example.unicartagena.cea14.domain.valueobjects.ItinerarioId;

public class Guia {
    private final GuiaId id;
    private String nombre;
    private InformacionContacto contacto;
    private LocalDate fechaInicio;
    private final Map<ItinerarioId, Set<LocalTime>> asignacionesItinerarios;

    public <Contacto> Guia(GuiaId id, String nombre, InformacionContacto contacto, LocalDate fechaInicio) {
        if (id == null) {
            throw new ZoologicoException("El ID del guía no puede ser nulo");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new ZoologicoException("El nombre del guía no puede estar vacío");
        }
        if (contacto == null) {
            throw new ZoologicoException("El contacto no puede ser nulo");
        }
        if (fechaInicio == null) {
            throw new ZoologicoException("La fecha de inicio no puede ser nula");
        }
        if (fechaInicio.isAfter(LocalDate.now())) {
            throw new ZoologicoException("La fecha de inicio no puede ser futura");
        }

        this.id = id;
        this.nombre = nombre;
        this.contacto = contacto;
        this.fechaInicio = fechaInicio;
        this.asignacionesItinerarios = new HashMap<>();
    }

    // Métodos de negocio
    public void asignarItinerario(ItinerarioId itinerarioId, LocalTime hora) {
        if (itinerarioId == null) {
            throw new ZoologicoException("El itinerario no puede ser nulo");
        }
        if (hora == null) {
            throw new ZoologicoException("La hora no puede ser nula");
        }

        asignacionesItinerarios.computeIfAbsent(itinerarioId, k -> new HashSet<>()).add(hora);
    }

    public void removerAsignacion(ItinerarioId itinerarioId, LocalTime hora) {
        if (!asignacionesItinerarios.containsKey(itinerarioId)) {
            throw new ZoologicoException("El guía no está asignado a ese itinerario");
        }
        
        Set<LocalTime> horarios = asignacionesItinerarios.get(itinerarioId);
        if (!horarios.contains(hora)) {
            throw new ZoologicoException("El guía no tiene asignada esa hora en el itinerario");
        }
        
        horarios.remove(hora);
        if (horarios.isEmpty()) {
            asignacionesItinerarios.remove(itinerarioId);
        }
    }

    public boolean estaAsignadoA(ItinerarioId itinerarioId) {
        return asignacionesItinerarios.containsKey(itinerarioId);
    }

    public int cantidadItinerarios() {
        return asignacionesItinerarios.size();
    }

    public void actualizarContacto(InformacionContacto nuevoContacto) {
        if (nuevoContacto == null) {
            throw new ZoologicoException("El contacto no puede ser nulo");
        }
        this.contacto = nuevoContacto;
    }

    public long aniosExperiencia() {
        return java.time.temporal.ChronoUnit.YEARS.between(fechaInicio, LocalDate.now());
    }

    // Getters
    public GuiaId getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public InformacionContacto getContacto() {
        return contacto;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public Map<ItinerarioId, Set<LocalTime>> getAsignacionesItinerarios() {
        return new HashMap<>(asignacionesItinerarios);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guia guia = (Guia) o;
        return Objects.equals(id, guia.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Guia{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", aniosExperiencia=" + aniosExperiencia() +
                '}';
    }
}
