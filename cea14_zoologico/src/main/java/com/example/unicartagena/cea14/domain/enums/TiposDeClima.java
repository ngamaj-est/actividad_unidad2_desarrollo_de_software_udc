package com.example.unicartagena.cea14.domain.enums;

public enum TiposDeClima {
    CALIDO("Cálido"),
    TEMPLADO("Templado"),
    FRIO("Frío"),
    PARAMO("Parámo"),
    NEVADO("Nevado");

    protected final String descripcion;

    TiposDeClima(String descripcion) {
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
