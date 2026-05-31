package com.example.unicartagena.cea14.domain.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.example.unicartagena.cea14.domain.exceptions.ItinerarioExceptions;
import com.example.unicartagena.cea14.domain.valueobjects.CapacidadVisitantes;
import com.example.unicartagena.cea14.domain.valueobjects.ItinerarioId;
import com.example.unicartagena.cea14.domain.valueobjects.ZonaId;
import com.example.unicartagena.cea14.domain.valueobjects.DuracionItinerario;

public class Itinerario {
    private final ItinerarioId id;
    private String codigo;
    private DuracionItinerario duracionItinerario;
    private double longitudKm;
    private CapacidadVisitantes capacidadMaxima;
    private int numeroEspeciesVisitadas;
    private final List<ZonaId> zonasRecorridas;

    public Itinerario(ItinerarioId id, String codigo, DuracionItinerario duracion, 
                      double longitudKm, CapacidadVisitantes capacidadMaxima, 
                      int numeroEspeciesVisitadas) {
        if (id == null) {
            throw new ItinerarioExceptions("El ID del itinerario no puede ser nulo");
        }
        if (codigo == null || codigo.isBlank()) {
            throw new ItinerarioExceptions("El código no puede estar vacío");
        }
        if (duracion == null) {
            throw new ItinerarioExceptions("La duración no puede ser nula");
        }
        if (longitudKm <= 0) {
            throw new ItinerarioExceptions("La longitud debe ser mayor a 0 km");
        }
        if (capacidadMaxima == null) {
            throw new ItinerarioExceptions("La capacidad máxima no puede ser nula");
        }
        if (numeroEspeciesVisitadas < 0) {
            throw new ItinerarioExceptions("El número de especies no puede ser negativo");
        }

        this.id = id;
        this.codigo = codigo;
        this.duracionItinerario = duracion;
        this.longitudKm = longitudKm;
        this.capacidadMaxima = capacidadMaxima;
        this.numeroEspeciesVisitadas = numeroEspeciesVisitadas;
        this.zonasRecorridas = new ArrayList<>();
    }

    // Métodos de negocio
    public void agregarZona(ZonaId zonaId) {
        if (zonaId == null) {
            throw new ItinerarioExceptions("La zona no puede ser nula");
        }
        if (zonasRecorridas.contains(zonaId)) {
            throw new ItinerarioExceptions("La zona ya está incluida en el itinerario");
        }
        this.zonasRecorridas.add(zonaId);
    }

    public void removerZona(ZonaId zonaId) {
        if (!zonasRecorridas.contains(zonaId)) {
            throw new ItinerarioExceptions("La zona no está en el itinerario");
        }
        this.zonasRecorridas.remove(zonaId);
    }

    public boolean atraviesa(ZonaId zonaId) {
        return zonasRecorridas.contains(zonaId);
    }

    public int cantidadZonasRecorridas() {
        return zonasRecorridas.size();
    }

    public void validarCapacidad(int cantidadVisitantes) {
        capacidadMaxima.permiteGrupo(cantidadVisitantes);
    }

    public void actualizarDuracion(DuracionItinerario nuevaDuracion) {
        if (nuevaDuracion == null) {
            throw new ItinerarioExceptions("La duración no puede ser nula");
        }
        this.duracionItinerario = nuevaDuracion;
    }

    public void actualizarNumeroEspecies(int cantidad) {
        if (cantidad < 0) {
            throw new ItinerarioExceptions("El número de especies no puede ser negativo");
        }
        this.numeroEspeciesVisitadas = cantidad;
    }

    // Getters
    public ItinerarioId getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public DuracionItinerario getDuracion() {
        return duracionItinerario;
    }

    public double getLongitudKm() {
        return longitudKm;
    }

    public CapacidadVisitantes getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public int getNumeroEspeciesVisitadas() {
        return numeroEspeciesVisitadas;
    }

    public List<ZonaId> getZonasRecorridas() {
        return new ArrayList<>(zonasRecorridas);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Itinerario that = (Itinerario) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Itinerario{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", duracion=" + duracionItinerario +
                ", longitudKm=" + longitudKm +
                '}';
    }

}
