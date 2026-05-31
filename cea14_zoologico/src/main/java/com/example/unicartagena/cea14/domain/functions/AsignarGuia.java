package com.example.unicartagena.cea14.domain.functions;

import java.time.LocalDate;
import java.time.LocalTime;

import com.example.unicartagena.cea14.domain.models.Guia;
import com.example.unicartagena.cea14.domain.valueobjects.GuiaId;
import com.example.unicartagena.cea14.domain.valueobjects.InformacionContacto;
import com.example.unicartagena.cea14.domain.valueobjects.ItinerarioId;

public class AsignarGuia {
    public static void AsignarGuiaItinerario() {
        System.out.println("=== Asignar Guía ===");
        
        var guiaId = GuiaId.generate();
        var contacto = new InformacionContacto("312-567-7891", "nathan.gama@example.com");
        var guia = new Guia(
            guiaId,
            "Nathan Gama",
            contacto,
            LocalDate.of(2020, 3, 15)
        );
        
        var itinerario_1 = ItinerarioId.generate();
        var itinerario_2 = ItinerarioId.generate();
        
        guia.asignarItinerario(itinerario_1, LocalTime.of(9, 0));
        guia.asignarItinerario(itinerario_1, LocalTime.of(14, 0));
        guia.asignarItinerario(itinerario_2, LocalTime.of(11, 0));
        
        System.out.println("Guía: " + guia.getNombre());
        System.out.println("Años de experiencia: " + guia.aniosExperiencia());
        System.out.println("Itinerarios asignados: " + guia.cantidadItinerarios());
        System.out.println();
    }

    
}
