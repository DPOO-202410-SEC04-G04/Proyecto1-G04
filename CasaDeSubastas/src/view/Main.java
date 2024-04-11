package view;



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import model.Galeria;
import java.util.Scanner;



public class Main {
    public static String inputEnter(String mensaje)
    {
        try
        {
            System.out.print(mensaje);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            return reader.readLine();
        }
        catch (IOException e)
        {
            System.out.println("Error leyendo de la consola");
            e.printStackTrace();
        }
        return null;
    }

    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 4) {
            System.out.println("\nMenú Principal:");
            System.out.println("1. Registrar Pieza ");
            System.out.println("2. Confirmacion Venta o Devolucion de Pieza ");
            System.out.println("3. Opción 3");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            // Manejar la entrada del usuario
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();

                // Manejar las opciones del menú
                switch (opcion) {
                    case 1:
                        System.out.println("Ejecutando opción 1...");
                        req1(args);
                        break;
                    case 2:
                        System.out.println("Ejecutando opción 2...");
                        // Aquí puedes agregar la lógica específica para la opción 2
                        break;
                    case 3:
                        System.out.println("Ejecutando opción 3...");
                        // Aquí puedes agregar la lógica específica para la opción 3
                        break;
                    case 4:
                        System.out.println("Saliendo del menú...");
                        break;
                    default:
                        System.out.println("Opción no válida, intente nuevamente.");
                        break;
                }
            } else {
                System.out.println("Por favor, introduzca un número válido.");
                scanner.next(); // Importante para evitar un bucle infinito
            }
        }

        scanner.close();
    }

	public static void req1(String[] args) throws FileNotFoundException, IOException {

        Galeria galeria = new Galeria("Uniandes");

        String nombreObra = inputEnter("Digite el nombre de la Obra: ");
        String autorObra = inputEnter("Digite el autor de la Obra: ");
        String fecha = inputEnter("Digite la fecha de la Obra (dd/mm/YYYY): ");
        String lugar = inputEnter("Digite el lugar de la Obra: ");
        String estado = inputEnter("Digite el estado de la Obra: ");
        String precio = inputEnter("Digite el precio de la Obra: ");
        String disponibilidad = inputEnter("Digite la disponibilidad de la Obra (true/false): ");
        String tipoCompra = inputEnter("Digite el tipo de Compra de la Obra: ");
        String tipoPieza = inputEnter("Digite el tipo de pieza de la Obra: ");

        galeria.addPieza(autorObra, nombreObra, fecha, lugar, estado, Float.parseFloat(precio), Boolean.parseBoolean(disponibilidad), tipoCompra, tipoPieza);
    }
}