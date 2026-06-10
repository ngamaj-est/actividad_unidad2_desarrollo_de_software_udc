package com.example.unicartagena.cea14.domain.functions;

import com.example.unicartagena.cea14.domain.factory.EspecieFactory;
import com.example.unicartagena.cea14.domain.valueobjects.ZonaId;

public class CrearEspecieFunc {
    
    public static void CrearEspecie() {
        System.out.println("===  Crear Especie ===");
        
        var zonaId = ZonaId.generate();
        
        var serpiente = EspecieFactory.builder()
            .conNombreEspanol("Serpíente")
            .conNombreCientifico("Python", "regius")
            .conDescripcion("Gran serpiente africana, conocida por su tamaño y fuerza")
            .enZona(zonaId)
            .build();
        
        System.out.println("Especie creada: " + serpiente.getNombreEspanol());
        System.out.println("Nombre científico: " + serpiente.getNombreCientifico());
        System.out.println();
    }


}
