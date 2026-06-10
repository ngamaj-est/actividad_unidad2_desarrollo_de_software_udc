package com.example.unicartagena.cea14.infrastructure.entrypoint.desktop.dto;

public record UpdateEspecieRequest(
    String id,
    String nombreEspanol,
    String nombreCientifico,
    String descripcion,
    String zonaId
) {

}
