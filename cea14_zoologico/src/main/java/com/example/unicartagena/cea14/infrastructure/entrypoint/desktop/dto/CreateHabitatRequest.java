package com.example.unicartagena.cea14.infrastructure.entrypoint.desktop.dto;

import com.example.unicartagena.cea14.domain.enums.TiposDeClima;
import com.example.unicartagena.cea14.domain.enums.TiposDeVegetacion;

public record CreateHabitatRequest(
    String nombre,
    TiposDeClima clima,
    TiposDeVegetacion vegetacion
) {

}
