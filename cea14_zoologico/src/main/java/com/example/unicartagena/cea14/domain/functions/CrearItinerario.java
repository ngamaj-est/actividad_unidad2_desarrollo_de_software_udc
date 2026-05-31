package com.example.unicartagena.cea14.domain.functions;

import com.example.unicartagena.cea14.domain.factory.ItinerarioFactory;
import com.example.unicartagena.cea14.domain.valueobjects.ZonaId;

public class CrearItinerario {
    public static void registrarItinerario() {
        System.out.println("=== Crear Itinerario ===");
        
        var itinerario = ItinerarioFactory.builder()
            .conCodigo("SAF-001")
            .conDuracionHoras(2, 30)
            .conLongitud(3.5)
            .conCapacidad(25)
            .visitaEspecies(12)
            .build();
        
        // Agregar zonas al recorrido
        var zona_1 = ZonaId.generate();
        var zona_2 = ZonaId.generate();
        var zona_3 = ZonaId.generate();
        
        itinerario.agregarZona(zona_1);
        itinerario.agregarZona(zona_2);
        itinerario.agregarZona(zona_3);
        
        System.out.println("Itinerario: " + itinerario.getCodigo());
        System.out.println("Duración: " + itinerario.getDuracion());
        System.out.println("Longitud: " + itinerario.getLongitudKm() + " km");
        System.out.println("Capacidad: " + itinerario.getCapacidadMaxima());
        System.out.println("Zonas recorridas: " + itinerario.cantidadZonasRecorridas());
        
        // metodo para validar la cantidad de visitantes
        try {
            itinerario.validarCapacidad(20);
            System.out.println("✓ Capacidad validada para 20 visitantes");
        } catch (Exception e) {
            System.out.println("✗ " + e.getMessage());
        }
        
        System.out.println();
    }

}
