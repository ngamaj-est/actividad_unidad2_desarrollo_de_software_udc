package com.example.unicartagena.cea14.application.services.dto;
import java.time.LocalDate;

public record CuidadorDTO(
    String id,
    String nombre,
    String telefono,
    String email,
    LocalDate fechaIngreso
) {}
