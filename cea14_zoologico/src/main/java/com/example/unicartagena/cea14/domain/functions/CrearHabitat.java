package com.example.unicartagena.cea14.domain.functions;

import com.example.unicartagena.cea14.domain.enums.TiposDeClima;
import com.example.unicartagena.cea14.domain.enums.TiposDeVegetacion;
import com.example.unicartagena.cea14.domain.models.Habitat;
import com.example.unicartagena.cea14.domain.valueobjects.HabitatId;

public class CrearHabitat {
 public static void RegistrarUnHabitat() {
        System.out.println("=== Crear Hábitat ===");
        
        var habitatId = HabitatId.generate();
        var habitat = new Habitat(
            habitatId,
            "Sabana Africana",
            TiposDeClima.CALIDO,
            TiposDeVegetacion.SABANA
        );
                
        System.out.println("Hábitat: " + habitat.getNombre());
        System.out.println("Clima: " + habitat.getClima());
        System.out.println("Vegetación: " + habitat.getVegetacion());
        System.out.println();
    }

   
}
