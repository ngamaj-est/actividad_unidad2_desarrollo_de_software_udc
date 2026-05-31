package com.example.unicartagena.cea14.domain.valueobjects;

public record ExtensionTerreno(Double metrosCuadrados) {
    public ExtensionTerreno {
        if (metrosCuadrados <= 0) {
            throw new IllegalArgumentException("La extensión del terreno debe ser mayor a 0 metros cuadrados");
        }
        if (metrosCuadrados > 100000) {
            throw new IllegalArgumentException("La extensión del terreno no puede ser mayor a 100,000 metros cuadrados");
        }
    }
    public ExtensionTerreno(int i) {
        this((double) i);
    }
    @Override
    public String toString() {
        return metrosCuadrados + " m²";
    }
}
