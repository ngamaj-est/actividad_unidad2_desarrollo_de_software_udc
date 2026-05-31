package com.example.unicartagena.cea14.domain.functions;

import com.example.unicartagena.cea14.domain.factory.EspecieFactory;
import com.example.unicartagena.cea14.domain.valueobjects.ZonaId;

public class CrearEspecieFunc {
    
    public static void CrearEspecie() {
        System.out.println("===  Crear Especie ===");
        
        var zonaId = ZonaId.generate();
        
        var leon = EspecieFactory.builder()
            .conNombreEspanol("León")
            .conNombreCientifico("Panthera", "leo")
            .conDescripcion("Gran felino africano, conocido como el rey de la selva")
            .enZona(zonaId)
            .build();
        
        System.out.println("Especie creada: " + leon);
        System.out.println("Nombre científico: " + leon.getNombreCientifico());
        System.out.println();
    }


}
