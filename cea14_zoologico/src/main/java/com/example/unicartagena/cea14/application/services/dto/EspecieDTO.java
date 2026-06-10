package com.example.unicartagena.cea14.application.services.dto;
import java.util.List;

public record EspecieDTO(
    String id,
    String nombreEspanol,
    String nombreCientificoGenero,
    String nombreCientificoEspecie,
    String descripcion,
    String zonaId,
    List<String> habitats
) {}
