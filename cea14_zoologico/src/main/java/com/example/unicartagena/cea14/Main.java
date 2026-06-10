package com.example.unicartagena.cea14;


import com.example.unicartagena.cea14.domain.functions.*;
public class Main {
    public static void main(String[] args) {
        //CASO 1: Crear una especie
        CrearEspecieFunc.CrearEspecie();
        //CASO 2: Crean una zona con especies
        CrearZonaConEspecieFunc.CrearZonaConEspecies();
        //CASO 3: Crear un habitat
        CrearHabitat.RegistrarUnHabitat();
        //CASO 4: Crear un itinerario
        CrearItinerario.registrarItinerario();
        //CASO 5: Asignar a un Guia
        AsignarGuia.AsignarGuiaItinerario();
        //CASO 6: Asignar a un Cuidador
        AsignarCuidador.AsignarCuidadorEspecie();
        //Caso 7: Programar examenes medicos para las especies
        ProgramarExamenesEspecies.ProgramarExamenes();
        //Caso 8: Utilizar las specifications para validar la informacion
        UseSpecifications.UsarSpecifications();
    }
}   