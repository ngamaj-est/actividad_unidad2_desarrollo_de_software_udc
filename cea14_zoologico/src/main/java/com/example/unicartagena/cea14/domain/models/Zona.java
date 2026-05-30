package com.example.unicartagena.cea14.domain.models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.example.unicartagena.cea14.domain.exceptions.ZonaException;
import com.example.unicartagena.cea14.domain.valueobjects.EspecieId;
import com.example.unicartagena.cea14.domain.valueobjects.ExtensionTerreno;
import com.example.unicartagena.cea14.domain.valueobjects.ZonaId;
public class Zona {
    private final ZonaId id;
    private String nombre;
    private ExtensionTerreno extensionTerrreno;
    private final Set<EspecieId> especies;

    public Zona(ZonaId id, String nombre, ExtensionTerreno extensionTerrreno) {
        if (id == null) {
            throw new ZonaException("El ID de la zona no puede ser nulo");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new ZonaException("El nombre de la zona no puede estar vacío");
        }
        if (extensionTerrreno == null) {
            throw new ZonaException("La extensión no puede ser nula");
        }

        this.id = id;
        this.nombre = nombre;
        this.extensionTerrreno = extensionTerrreno;
        this.especies = new HashSet<>();
    }

    // Métodos de negocio
    public void agregarEspecie(EspecieId especieId) {
        if (especieId == null) {
            throw new ZonaException("El ID de la especie no puede ser nulo");
        }
        this.especies.add(especieId);
    }

    public void removerEspecie(EspecieId especieId) {
        if (!this.especies.contains(especieId)) {
            throw new ZonaException("La especie no se encuentra en esta zona");
        }
        this.especies.remove(especieId);
    }

    public boolean contieneEspecie(EspecieId especieId) {
        return this.especies.contains(especieId);
    }

    public int cantidadEspecies() {
        return this.especies.size();
    }

    public void actualizarExtension(ExtensionTerreno nuevaExtension) {
        if (nuevaExtension == null) {
            throw new ZonaException("La extensión no puede ser nula");
        }
        this.extensionTerrreno = nuevaExtension;
    }

    // Getters
    public ZonaId getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public ExtensionTerreno getExtension() {
        return extensionTerrreno;
    }

    public Set<EspecieId> getEspecies() {
        return new HashSet<>(especies);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zona zona = (Zona) o;
        return Objects.equals(id, zona.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Zona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", extension=" + extensionTerrreno +
                ", cantidadEspecies=" + cantidadEspecies() +
                '}';
    }
}