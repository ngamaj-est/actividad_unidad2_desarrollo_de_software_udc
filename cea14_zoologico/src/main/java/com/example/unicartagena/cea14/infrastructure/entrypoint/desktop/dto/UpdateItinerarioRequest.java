package com.example.unicartagena.cea14.infrastructure.entrypoint.desktop.dto;

public record UpdateItinerarioRequest(
    String id,
    String codigo,
    int duracionMinutos,
    double longitudKm,
    int capacidadMaxima,
    int numeroEspeciesVisitadas
) {

}
