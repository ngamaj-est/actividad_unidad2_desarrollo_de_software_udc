package com.example.unicartagena.cea14.infrastructure.entrypoint.desktop.dto;

public record UpdateCuidadorRequest(
    String id,
    String nombre,
    String telefono,
    String email,
    String fechaIngreso // ISO date: yyyy-MM-dd
) {

}
