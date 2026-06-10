package com.example.unicartagena.cea14.domain.functions;

import java.time.LocalDateTime;
import java.util.List;

import com.example.unicartagena.cea14.application.services.ProgramacionExamenesService;
import com.example.unicartagena.cea14.domain.models.ExamenMedico;
import com.example.unicartagena.cea14.domain.valueobjects.EspecieId;

public class ProgramarExamenesEspecies {
    public static void ProgramarExamenes() {
        System.out.println("=== Programar Exámenes ===");
        
        var service = new ProgramacionExamenesService();
        var especieId = EspecieId.generate();
        var fechaInicio = LocalDateTime.now().plusDays(7);
        
        List<ExamenMedico> programa = service.crearProgramaAnual(especieId, fechaInicio);
        
        System.out.println("Programa anual de exámenes:");
        System.out.println("Total de exámenes: " + programa.size());
        
        programa.stream()
            .limit(5)
            .forEach(examen -> {
                System.out.println("- " + examen.getTipoExamen() + 
                                 " programado para " + examen.getFechaProgramada());
            });
        
        System.out.println();
    }

    
}
