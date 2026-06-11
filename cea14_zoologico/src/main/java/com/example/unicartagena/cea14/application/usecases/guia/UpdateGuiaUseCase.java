package com.example.unicartagena.cea14.application.usecases.guia;

import com.example.unicartagena.cea14.application.ports.in.GuiaInPort;
import com.example.unicartagena.cea14.application.services.dto.GuiaDTO;
import java.time.LocalDate;
import java.util.Optional;

/**
 * Caso de Uso: Actualizar un Guía existente
 * 
 * Responsabilidades:
 * - Validar que el guía exista
 * - Validar los nuevos datos
 * - Delegar al servicio para actualizar en la base de datos
 * - Retornar el guía actualizado
 */
public class UpdateGuiaUseCase {
    private final GuiaInPort guiaService;

    public UpdateGuiaUseCase(GuiaInPort guiaService) {
        this.guiaService = guiaService;
    }

    /**
     * Ejecuta el caso de uso de actualizar guía
     * 
     * @param id Identificador del guía a actualizar
     * @param nombre Nuevo nombre del guía
     * @param telefono Nuevo teléfono de contacto
     * @param email Nuevo email de contacto
     * @param fechaInicio Nueva fecha de inicio del contrato
     * @throws IllegalArgumentException si los parámetros no son válidos
     * @throws RuntimeException si el guía no existe
     */
    public void actualizar(String id, String nombre, String telefono, String email, LocalDate fechaInicio) {
        // Validaciones
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("El ID del guía no puede estar vacío");
        }
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

        // Verificar que el guía exista
        Optional<GuiaDTO> guiaExistente = guiaService.buscarPorPrefijo(id);
        if (guiaExistente.isEmpty()) {
            throw new RuntimeException("El guía con ID " + id + " no existe");
        }

        // Crear DTO actualizado
        GuiaDTO guiaActualizado = new GuiaDTO(id, nombre, telefono, email, fechaInicio);

        // Delegar al servicio para guardar los cambios
        guiaService.guardar(guiaActualizado);
    }
}
