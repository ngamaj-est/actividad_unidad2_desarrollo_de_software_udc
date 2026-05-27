package com.example.unicartagena.cea14.domain.models;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.example.unicartagena.cea14.domain.enums.TiposDeExamenMedicos;
import com.example.unicartagena.cea14.domain.exceptions.ZoologicoException;
import com.example.unicartagena.cea14.domain.valueobjects.EspecieId;

public class ExamenMedico {
    private final String id;
    private final EspecieId especieId;
    private final TiposDeExamenMedicos tipoExamen;
    private LocalDateTime fechaProgramada;
    private LocalDateTime fechaRealizado;
    private String resultado;
    private String observaciones;
    private boolean completado;

    public ExamenMedico(EspecieId especieId, TiposDeExamenMedicos tipoExamen, 
                        LocalDateTime fechaProgramada) {
        if (especieId == null) {
            throw new ZoologicoException("La especie no puede ser nula");
        }
        if (tipoExamen == null) {
            throw new ZoologicoException("El tipo de examen no puede ser nulo");
        }
        if (fechaProgramada == null) {
            throw new ZoologicoException("La fecha programada no puede ser nula");
        }
        if (fechaProgramada.isBefore(LocalDateTime.now())) {
            throw new ZoologicoException("La fecha programada no puede ser en el pasado");
        }

        this.id = UUID.randomUUID().toString();
        this.especieId = especieId;
        this.tipoExamen = tipoExamen;
        this.fechaProgramada = fechaProgramada;
        this.completado = false;
    }

    // Métodos de negocio
    public void reprogramar(LocalDateTime nuevaFecha) {
        if (nuevaFecha == null) {
            throw new ZoologicoException("La nueva fecha no puede ser nula");
        }
        if (completado) {
            throw new ZoologicoException("No se puede reprogramar un examen ya completado");
        }
        if (nuevaFecha.isBefore(LocalDateTime.now())) {
            throw new ZoologicoException("La nueva fecha no puede ser en el pasado");
        }
        this.fechaProgramada = nuevaFecha;
    }

    public void completarExamen(String resultado, String observaciones) {
        if (resultado == null || resultado.isBlank()) {
            throw new ZoologicoException("El resultado no puede estar vacío");
        }
        if (completado) {
            throw new ZoologicoException("El examen ya está completado");
        }

        this.fechaRealizado = LocalDateTime.now();
        this.resultado = resultado;
        this.observaciones = observaciones;
        this.completado = true;
    }

    public void agregarObservaciones(String nuevasObservaciones) {
        if (nuevasObservaciones == null || nuevasObservaciones.isBlank()) {
            throw new ZoologicoException("Las observaciones no pueden estar vacías");
        }
        if (this.observaciones == null) {
            this.observaciones = nuevasObservaciones;
        } else {
            this.observaciones += "\n" + nuevasObservaciones;
        }
    }

    public boolean estaPendiente() {
        return !completado && fechaProgramada.isAfter(LocalDateTime.now());
    }

    public boolean estaVencido() {
        return !completado && fechaProgramada.isBefore(LocalDateTime.now());
    }

    // Getters
    public String getId() {
        return id;
    }

    public EspecieId getEspecieId() {
        return especieId;
    }

    public TiposDeExamenMedicos getTipoExamen() {
        return tipoExamen;
    }

    public LocalDateTime getFechaProgramada() {
        return fechaProgramada;
    }

    public LocalDateTime getFechaRealizado() {
        return fechaRealizado;
    }

    public String getResultado() {
        return resultado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public boolean isCompletado() {
        return completado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExamenMedico that = (ExamenMedico) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ExamenMedico{" +
                "id='" + id + '\'' +
                ", tipoExamen=" + tipoExamen +
                ", fechaProgramada=" + fechaProgramada +
                ", completado=" + completado +
                '}';
    }
}
