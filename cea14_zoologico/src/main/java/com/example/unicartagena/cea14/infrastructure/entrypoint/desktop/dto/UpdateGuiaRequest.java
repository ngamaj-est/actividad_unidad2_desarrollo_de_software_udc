package com.example.unicartagena.cea14.infrastructure.entrypoint.desktop.dto;

public record UpdateGuiaRequest(
    String id,
    String nombre,
    String telefono,
    String email,
    String fechaInicio // ISO date: yyyy-MM-dd
) {

}
