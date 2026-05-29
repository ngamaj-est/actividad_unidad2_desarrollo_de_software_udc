package com.example.unicartagena.cea14.domain.specifications;

import com.example.unicartagena.cea14.domain.models.Cuidador;

public class CuidadorExperimentadoSpecs implements Specification<Cuidador> {
    
    private final int añosMinimos;
    
    public CuidadorExperimentadoSpecs(int añosMinimos) {
        this.añosMinimos = añosMinimos;
    }
    
    @Override
    public boolean isSatisfiedBy(Cuidador cuidador) {
        return cuidador != null && 
               cuidador.tieneExperienciaMayorA(añosMinimos);
    }
}
