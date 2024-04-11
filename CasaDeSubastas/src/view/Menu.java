package view;

import java.util.Scanner;

public class Menu {
    private Scanner scanner;

    public Menu() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion = 0;
        do {
            System.out.println("Menú Principal:");
            System.out.println("1. Opción 1");
            System.out.println("2. Opción 2");
            System.out.println("3. Opción 3");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            manejarOpcion(opcion);
        } while (opcion != 4);
    }

    private void manejarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                System.out.println("Ejecutando opción 1...");
                // Aquí puedes agregar la lógica para la opción 1
                break;
            case 2:
                System.out.println("Ejecutando opción 2...");
                // Aquí puedes agregar la lógica para la opción 2
                break;
            case 3:
                System.out.println("Ejecutando opción 3...");
                // Aquí puedes agregar la lógica para la opción 3
                break;
            case 4:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción no válida, intente de nuevo.");
        }
    }
}

