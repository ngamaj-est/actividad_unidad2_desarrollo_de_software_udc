package com.example.unicartagena.cea14.infrastructure.cli;  

import java.util.Scanner;

public class ConsoleCLI {
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("=== Zoologico CLI ===");
            System.out.println("1) CRUD Zona");
            System.out.println("2) CRUD Especie");
            System.out.println("3) CRUD Cuidador");
            System.out.println("4) CRUD Guia");
            System.out.println("5) CRUD Itinerario");
            System.out.println("6) CRUD Habitat");
            System.out.println("7) CRUD ExamenMedico");
            System.out.println("0) Salir");
            System.out.print("Selecciona una opción: ");
            String option = scanner.nextLine().trim();
            switch (option) {
                case "1":
                    crudZona();
                    break;
                case "2":
                    crudEspecie();
                    break;
                case "3":
                    crudCuidador();
                    break;
                case "4":
                    crudGuia();
                    break;
                case "5":
                    crudItinerario();
                    break;
                case "6":
                    crudHabitat();
                    break;
                case "7":
                    crudExamenMedico();
                    break;
                case "0":
                    System.out.println("Adiós");
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
    private void crudZona() {
        System.out.println("CRUD Zona no implementado");
    }

    private void crudEspecie() {
        System.out.println("CRUD Especie no implementado");
    }

    private void crudCuidador() {
        System.out.println("CRUD Cuidador no implementado");
    }

    private void crudGuia() {
        System.out.println("CRUD Guia no implementado");
    }

    private void crudItinerario() {
        System.out.println("CRUD Itinerario no implementado");
    }

    private void crudHabitat() {
        System.out.println("CRUD Habitat no implementado");
    }

    private void crudExamenMedico() {
        System.out.println("CRUD ExamenMedico no implementado");
    }
}