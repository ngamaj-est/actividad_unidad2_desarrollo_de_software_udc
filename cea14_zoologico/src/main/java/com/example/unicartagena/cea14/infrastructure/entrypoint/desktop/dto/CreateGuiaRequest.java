package com.example.unicartagena.cea14.infrastructure.entrypoint.desktop.dto;

public record CreateGuiaRequest(
    String nombre,
    String telefono,
    String email,
    String fechaInicio // ISO date: yyyy-MM-dd
) {

}
