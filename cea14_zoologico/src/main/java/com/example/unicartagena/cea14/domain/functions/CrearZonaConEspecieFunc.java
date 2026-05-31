package com.example.unicartagena.cea14.domain.functions;

import com.example.unicartagena.cea14.domain.factory.EspecieFactory;
import com.example.unicartagena.cea14.domain.models.Zona;
import com.example.unicartagena.cea14.domain.valueobjects.ExtensionTerreno;
import com.example.unicartagena.cea14.domain.valueobjects.ZonaId;

public class CrearZonaConEspecieFunc {
 public static void CrearZonaConEspecies() {
        System.out.println("=== Zona con Especies ===");
        
        var zonaId = ZonaId.generate();
        var extension = new ExtensionTerreno(5000); // 5000 m²
        var zona = new Zona(zonaId, "Sabana Africana", extension);
        
        // Crear varias especies
        var leon = EspecieFactory.crear("León", "Panthera", "leo", 
            "Rey de la selva", zonaId);
        var cebra = EspecieFactory.crear("Cebra", "Equus", "quagga",
            "Équido rayado", zonaId);
        var jirafa = EspecieFactory.crear("Jirafa", "Giraffa", "camelopardalis",
            "Mamífero de cuello largo", zonaId);
        
        zona.agregarEspecie(leon.getId());
        zona.agregarEspecie(cebra.getId());
        zona.agregarEspecie(jirafa.getId());
        
        System.out.println("Zona: " + zona.getNombre());
        System.out.println("Extensión: " + zona.getExtension());
        System.out.println("Cantidad de especies: " + zona.cantidadEspecies());
        System.out.println();
    }

   
}
