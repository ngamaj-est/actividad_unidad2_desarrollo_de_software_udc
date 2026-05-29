package com.example.unicartagena.cea14.domain.specifications;
import com.example.unicartagena.cea14.domain.models.Zona;


public class ZonaMultiEspecieSpecs implements Specification<Zona> {

    private int cantidadMinimaEspecies;

    public ZonaMultiEspecieSpecs(int cantidadMinimaEspecies) {
        this.cantidadMinimaEspecies = cantidadMinimaEspecies;
    }

    @Override
    public boolean isSatisfiedBy(Zona zona) {
        if (zona == null) {
            return false;
        }
        return zona.cantidadEspecies() >= cantidadMinimaEspecies;
    }

}
