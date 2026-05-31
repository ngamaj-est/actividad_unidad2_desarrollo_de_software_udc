package com.example.unicartagena.cea14.domain.functions;

import com.example.unicartagena.cea14.domain.factory.ItinerarioFactory;
import com.example.unicartagena.cea14.domain.specifications.ItinerarioGrupoPequeñoSpecs;
import com.example.unicartagena.cea14.domain.specifications.ItinerarioLargaDuracionSpecs;

public class UseSpecifications {
    // Uso de especificaciones para validar la informacion de los itinerarios
    public static void UsarSpecifications() {
        System.out.println("=== Usar Specifications para Itinerario===");
        
        var itinerarioLargo = ItinerarioFactory.builder()
            .conCodigo("VI-LARGO")
            .conDuracionHoras(3, 0)
            .conLongitud(4.5)
            .conCapacidad(15)
            .visitaEspecies(20)
            .build();
        
        var itinerarioCorto = ItinerarioFactory.builder()
            .conCodigo("VI-CORTO")
            .conDuracionHoras(1, 0)
            .conLongitud(1.5)
            .conCapacidad(30)
            .visitaEspecies(5)
            .build();
        
        var specLarga = new ItinerarioLargaDuracionSpecs(2);
        var specPequeno = new ItinerarioGrupoPequeñoSpecs(20);
        
        System.out.println("Itinerario VI-LARGO:");
        System.out.println("- ¿Es de larga duración? " + specLarga.isSatisfiedBy(itinerarioLargo));
        System.out.println("- ¿Es para grupos pequeños? " + specPequeno.isSatisfiedBy(itinerarioLargo));
        
        System.out.println("\nItinerario VI-CORTO:");
        System.out.println("- ¿Es de larga duración? " + specLarga.isSatisfiedBy(itinerarioCorto));
        System.out.println("- ¿Es para grupos pequeños? " + specPequeno.isSatisfiedBy(itinerarioCorto));
        
        // Combinar specifications
        var specVIP = specLarga.and(specPequeno);
        System.out.println("\nItinerario VI-LARGO cumple especificación VIP: " + 
                          specVIP.isSatisfiedBy(itinerarioLargo));
        
        System.out.println();
    }
}
