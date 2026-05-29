package com.example.unicartagena.cea14.domain.models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.example.unicartagena.cea14.domain.exceptions.EspecieException;
import com.example.unicartagena.cea14.domain.valueobjects.EspecieId;
import com.example.unicartagena.cea14.domain.valueobjects.HabitatId;
import com.example.unicartagena.cea14.domain.valueobjects.NombreCientificoEspecies;
import com.example.unicartagena.cea14.domain.valueobjects.ZonaId;

public class Especie {
    private final EspecieId id;
    private String nombreEspanol;
    private NombreCientificoEspecies nombreCientifico;
    private String descripcion;
    private ZonaId zonaAsignada;
    private final Set<HabitatId> habitats;

    public Especie(EspecieId id, String nombreEspanol, NombreCientificoEspecies nombreCientifico, 
                   String descripcion, ZonaId zonaAsignada) {
        if (id == null) {
            throw new EspecieException("El ID de la especie no puede ser nulo");
        }
        if (nombreEspanol == null || nombreEspanol.isBlank()) {
            throw new EspecieException("El nombre en español no puede estar vacío");
        }
        if (nombreCientifico == null) {
            throw new EspecieException("El nombre científico no puede ser nulo");
        }
        if (descripcion == null || descripcion.isBlank()) {
            throw new EspecieException("La descripción no puede estar vacía");
        }
        if (zonaAsignada == null) {
            throw new EspecieException("La especie debe estar asignada a una zona");
        }

        this.id = id;
        this.nombreEspanol = nombreEspanol;
        this.nombreCientifico = nombreCientifico;
        this.descripcion = descripcion;
        this.zonaAsignada = zonaAsignada;
        this.habitats = new HashSet<>();
    }

    public void actualizarDescripcion(String nuevaDescripcion) {
        if (nuevaDescripcion == null || nuevaDescripcion.isBlank()) {
            throw new EspecieException("La descripción no puede estar vacía");
        }
        this.descripcion = nuevaDescripcion;
    }

    public void reasignarZona(ZonaId nuevaZona) {
        if (nuevaZona == null) {
            throw new EspecieException("La zona no puede ser nula");
        }
        this.zonaAsignada = nuevaZona;
    }

    public void agregarHabitat(HabitatId habitatId) {
        if (habitatId == null) {
            throw new EspecieException("El hábitat no puede ser nulo");
        }
        this.habitats.add(habitatId);
    }

    public void removerHabitat(HabitatId habitatId) {
        if (!this.habitats.contains(habitatId)) {
            throw new EspecieException("La especie no habita en ese hábitat");
        }
        this.habitats.remove(habitatId);
    }

    public boolean habitaEn(HabitatId habitatId) {
        return this.habitats.contains(habitatId);
    }

    // Getters
    public EspecieId getId() {
        return id;
    }

    public String getNombreEspanol() {
        return nombreEspanol;
    }

    public NombreCientificoEspecies getNombreCientifico() {
        return nombreCientifico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public ZonaId getZonaAsignada() {
        return zonaAsignada;
    }

    public Set<HabitatId> getHabitats() {
        return new HashSet<>(habitats);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Especie especie = (Especie) o;
        return Objects.equals(id, especie.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Especie{" +
                "id=" + id +
                ", nombreEspanol='" + nombreEspanol + '\'' +
                ", nombreCientifico=" + nombreCientifico +
                '}';
    }
}
