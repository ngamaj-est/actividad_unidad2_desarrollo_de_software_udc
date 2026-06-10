package com.example.unicartagena.cea14.infrastructure.entrypoint.desktop.dto;

public record UpdateZonaRequest(
    String id,
    String nombre,
    Double extensionMetros
) {

}
