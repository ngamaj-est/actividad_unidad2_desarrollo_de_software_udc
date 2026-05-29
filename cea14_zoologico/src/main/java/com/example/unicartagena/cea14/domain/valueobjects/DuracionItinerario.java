package com.example.unicartagena.cea14.domain.valueobjects;

public record DuracionItinerario(int minutos) {
    public DuracionItinerario {
        if (minutos <= 0) {
            throw new IllegalArgumentException("La duración del itinerario debe ser mayor a cero");
        }
        if (minutos > 300) {
            throw new IllegalArgumentException("La duración del itinerario no puede ser mayor a 5 horas (300 minutos)");
        }
    }

    public int horas() {
        return minutos / 60;
    }
    public int minutosRestantes() {
        return minutos % 60;
    }

    @Override
    public String toString() {
        if(minutos < 60) {
            return minutos + " minutos";
        }
        return horas() + "h  " + minutosRestantes() + "m";
    }

    public boolean esMayorQueHoras(int duracionMinima) {
        throw new UnsupportedOperationException("Unimplemented method 'esMayorQueHoras'");
    }
}
