package com.example.unicartagena.cea14.infrastructure.entrypoint.desktop.dto;


public record CreateEspecieRequest(
    String nombre,
    String nombreCientifico,
    String descripcion,
    String habitat) {
        
    }
