package com.example.unicartagena.cea14.test.valueobjects;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.example.unicartagena.cea14.domain.valueobjects.ExtensionTerreno;

public class ExtensionTerrenoTest {
        @Test
    void debeCrearExtensionValida() {
        var extension = new ExtensionTerreno(1500.5);
        
        assertEquals(1500.5, extension.metrosCuadrados(), 0.0001);
    }

    @Test
    void debeFallarConExtensionCero() {
        assertThrows(IllegalArgumentException.class, () -> new ExtensionTerreno(0));
    }

    @Test
    void debeFallarConExtensionNegativa() {
        assertThrows(IllegalArgumentException.class, () -> new ExtensionTerreno(-100));
    }

    @Test
    void debeFallarConExtensionExcesiva() {
        assertThrows(IllegalArgumentException.class, () -> new ExtensionTerreno(2000000));
    }

    
}
