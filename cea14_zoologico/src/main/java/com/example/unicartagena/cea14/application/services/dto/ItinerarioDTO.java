package com.example.unicartagena.cea14.application.services.dto;
import java.util.List;

public record ItinerarioDTO(
    String id,
    String codigo,
    int duracionMinutos,
    double longitudKm,
    int capacidadMaxima,
    int numeroEspeciesVisitadas,
    List<String> zonasRecorridas
) {}
