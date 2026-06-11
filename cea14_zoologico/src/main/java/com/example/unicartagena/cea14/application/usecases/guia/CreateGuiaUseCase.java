package com.example.unicartagena.cea14.application.usecases.guia;

import com.example.unicartagena.cea14.application.ports.in.GuiaInPort;
import com.example.unicartagena.cea14.application.services.dto.GuiaDTO;

/**
 * Caso de Uso: Crear un nuevo Guía
 * 
 * Responsabilidades:
 * - Recibir los datos del nuevo guía
 * - Validar que los datos sean correctos
 * - Delegar al servicio para guardar en la base de datos
 * - Retornar confirmación de creación
 */
public class CreateGuiaUseCase {
    private final GuiaInPort guiaService;

    public CreateGuiaUseCase(GuiaInPort guiaService) {
        this.guiaService = guiaService;
    }

    /**
     * Ejecuta el caso de uso de crear guía
     * 
     * @param nombre Nombre del guía
     * @param telefono Teléfono de contacto
     * @param email Email de contacto
     * @param fechaInicio Fecha de inicio del contrato
     * @throws IllegalArgumentException si los parámetros no son válidos
     */
    public void crear(String nombre, String telefono, String email, java.time.LocalDate fechaInicio) {
        // Validaciones
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del guía no puede estar vacío");
        }
        if (telefono == null || telefono.isBlank()) {
            throw new IllegalArgumentException("El teléfono no puede estar vacío");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("El email no puede estar vacío");
        }
        if (fechaInicio == null) {
            throw new IllegalArgumentException("La fecha de inicio no puede estar vacía");
        }

        // Crear DTO con los datos
        GuiaDTO guiaDTO = new GuiaDTO(null, nombre, telefono, email, fechaInicio);

        // Delegar al servicio para guardar en BD
        guiaService.guardar(guiaDTO);
    }
}
