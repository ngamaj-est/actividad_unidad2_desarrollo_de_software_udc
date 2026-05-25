package com.example.unicartagena.cea14.domain.enums;

public enum TiposDeExamenMedicos {
    ESTADO_FISICO("Chequeo Físico Completo"),
    ANALISIS_SANGRE("Análisis de Sangre"),
    ANALISIS_HECES("Análisis de Heces"),
    REVISION_DENTAL("Evaluación Dental"),
    ANALISIS_GENETICO("Análisis Genético");

    protected final String descripcion;

    TiposDeExamenMedicos(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}
