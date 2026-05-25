package com.example.unicartagena.cea14.domain.enums;

public enum TiposDeVegetacion {
    SELVA_HUMEDA_TROPICAL("Selva Húmeda Tropical"),
    BOSQUE_SECOS("Bosque Seco"),
    SABANA("Sabana"),
    PARAMO("Páramo"),
    MANGLARES("Manglares"),
    DESIERTO("Desierto");

    protected final String descripcion;
    
    TiposDeVegetacion(String descripcion) {
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
