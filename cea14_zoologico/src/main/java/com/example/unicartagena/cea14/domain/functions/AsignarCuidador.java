package com.example.unicartagena.cea14.domain.functions;

import java.time.LocalDate;

import com.example.unicartagena.cea14.domain.models.Cuidador;
import com.example.unicartagena.cea14.domain.valueobjects.CuidadorId;
import com.example.unicartagena.cea14.domain.valueobjects.EspecieId;
import com.example.unicartagena.cea14.domain.valueobjects.InformacionContacto;

public class AsignarCuidador {

    //Asignar un cuidador a una especie
    public static void AsignarCuidadorEspecie() {
        System.out.println("=== Asignar Cuidador ===");
        
        var cuidadorId = CuidadorId.generate();
        var contacto = new InformacionContacto("301-987-6543", "luis.reales@example.com");
        var cuidador = new Cuidador(
            cuidadorId,
            "Luis Reales",
            contacto,
            LocalDate.of(2018, 6, 1)
        );
        
        var especieLeon = EspecieId.generate();
        var especieTigre = EspecieId.generate();
        var especieJaguar = EspecieId.generate();
        
        cuidador.asignarEspecie(especieLeon, LocalDate.of(2018, 6, 1));
        cuidador.asignarEspecie(especieTigre, LocalDate.of(2019, 3, 15));
        cuidador.asignarEspecie(especieJaguar, LocalDate.of(2020, 8, 20));
        
        System.out.println("Cuidador: " + cuidador.getNombre());
        System.out.println("Años de servicio: " + cuidador.aniosServicio());
        System.out.println("Especies a cargo: " + cuidador.cantidadEspeciesACargo());
        System.out.println("¿Tiene más de 5 años de experiencia?: " + 
                          cuidador.tieneExperienciaMayorA(5));
        System.out.println();
    }

    
}
