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

        while (opcion != 9) {
            System.out.println("\nMenú Principal:");
            System.out.println("1. Registrar Pieza ");
            System.out.println("2. Confirmacion Venta o Devolucion de Pieza ");
            System.out.println("3. Comprar Pieza ");
			System.out.println("4. Realizar Subasta ");
			System.out.println("5. Consultar Estado de mis Piezas ");
			System.out.println("6. Consultar Historia de mis Piezas ");
			System.out.println("7. Aumentar Limite de Compras ");
			System.out.println("8. Realizar Pago ");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");

            // Manejar la entrada del usuario
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();

                // Manejar las opciones del menú
                switch (opcion) {
                    case 1:
					System.out.println("Accediendo al Submenú de la Opción 1...");
                        int opcionSubmenu = 0;
                        while (opcionSubmenu != 5) {
                            System.out.println("\nSeleccione tipo de Pieza a registrar:");
                            System.out.println("1. Escultura");
                            System.out.println("2. Pintura");
                            System.out.println("3. Video");
							System.out.println("4. Otro");
							System.out.println("5. Volver al Menú Principal");
                            System.out.print("Seleccione una opción del submenú: ");
                            
                            if (scanner.hasNextInt()) {
                                opcionSubmenu = scanner.nextInt();
                                
                                switch (opcionSubmenu) {
                                    case 1:
                                        System.out.println("Ejecutando Subopción 1...");
										req1Escultura(args);
										System.out.println("Se ha registrado la obra con exito!");
                                        break;


                                    case 2:
                                        System.out.println("Ejecutando Subopción 2...");
                        				req1Pintura(args);
										System.out.println("Se ha registrado la obra con exito!");
                                        break;

									case 3:
                                        System.out.println("Ejecutando Subopción 3...");
                        				req1Video(args);
										System.out.println("Se ha registrado la obra con exito!");
                                        break;
                                    
									case 4:
                                        System.out.println("Ejecutando Subopción 4...");
                        				req1(args);
										System.out.println("Se ha registrado la obra con exito!");
                                        break;
									
										case 5:
                                        System.out.println("Volviendo al Menú Principal...");
                                        break;

									
                                    default:
                                        System.out.println("Opción no válida, intente nuevamente.");
                                        break;
                                }
                            } else {
                                System.out.println("Por favor, introduzca un número válido.");
                                scanner.next(); // Evitar bucle infinito por entrada incorrecta
                            }
                        }
                        break;
                        //break;
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

	public static void req1Escultura(String[] args) throws FileNotFoundException, IOException {

        Galeria galeria = new Galeria("Uniandes");

        String nombreObra = inputEnter("Digite el nombre de la Obra: ");
        String autorObra = inputEnter("Digite el autor de la Obra: ");
        String fecha = inputEnter("Digite la fecha de la Obra (dd/mm/YYYY): ");
        String lugar = inputEnter("Digite el lugar de la Obra: ");
        String estado = inputEnter("Digite el estado de la Obra: ");
        String precio = inputEnter("Digite el precio de la Obra: ");
        String disponibilidad = inputEnter("Digite la disponibilidad de la Obra (true/false): ");
        String tipoCompra = inputEnter("Digite el tipo de Compra de la Obra: ");
        String tipoPieza = "Escultura";
		String dimensiones = inputEnter("Digite las dimensiones (Formato: AltoxAnchoxProfundidad) de la Obra: ");
		String materiales = inputEnter("Digite los materiales de la Obra: ");
		String peso = inputEnter("Digite el peso de la Obra en kilogramos: ");
		String necesidadElectricidad = inputEnter("¿Necesita de electricidad? (true/false): ");
		String tipoArte = inputEnter("Digite el tipo de Arte de la Obra: ");
		String detallesAdicionales = inputEnter("Digite detalles adicionales: ");

        galeria.addEscultura(autorObra, nombreObra, fecha, lugar, estado, Float.parseFloat(precio), Boolean.parseBoolean(disponibilidad), tipoCompra, tipoPieza, dimensiones, materiales, peso,
		Boolean.parseBoolean(necesidadElectricidad), tipoArte, detallesAdicionales);
    }

	public static void req1Pintura(String[] args) throws FileNotFoundException, IOException {

        Galeria galeria = new Galeria("Uniandes");

        String nombreObra = inputEnter("Digite el nombre de la Obra: ");
        String autorObra = inputEnter("Digite el autor de la Obra: ");
        String fecha = inputEnter("Digite la fecha de la Obra (dd/mm/YYYY): ");
        String lugar = inputEnter("Digite el lugar de la Obra: ");
        String estado = inputEnter("Digite el estado de la Obra: ");
        String precio = inputEnter("Digite el precio de la Obra: ");
        String disponibilidad = inputEnter("Digite la disponibilidad de la Obra (true/false): ");
        String tipoCompra = inputEnter("Digite el tipo de Compra de la Obra: ");
        String tipoPieza = "Pintura";
		String dimensiones = inputEnter("Digite las dimensiones (Formato: AltoxAnchoxProfundidad) de la Obra: ");
		String detallesAdicionales = inputEnter("Digite detalles adicionales: ");

        galeria.addPintura(autorObra, nombreObra, fecha, lugar, estado, Float.parseFloat(precio), Boolean.parseBoolean(disponibilidad), tipoCompra, tipoPieza, dimensiones, detallesAdicionales);
    }


	public static void req1Video(String[] args) throws FileNotFoundException, IOException {

        Galeria galeria = new Galeria("Uniandes");

        String nombreObra = inputEnter("Digite el nombre de la Obra: ");
        String autorObra = inputEnter("Digite el autor de la Obra: ");
        String fecha = inputEnter("Digite la fecha de la Obra (dd/mm/YYYY): ");
        String lugar = inputEnter("Digite el lugar de la Obra: ");
        String estado = inputEnter("Digite el estado de la Obra: ");
        String precio = inputEnter("Digite el precio de la Obra: ");
        String disponibilidad = inputEnter("Digite la disponibilidad de la Obra (true/false): ");
        String tipoCompra = inputEnter("Digite el tipo de Compra de la Obra: ");
        String tipoPieza = "Video";
		String duracion = inputEnter("Digite la duracion en segundos: ");
		String espacioDeMemoria = inputEnter("Digite el espacio de memoria de la Obra (en MB): ");
		String detallesAdicionales = inputEnter("Digite detalles adicionales: ");

        galeria.addVideo(autorObra, nombreObra, fecha, lugar, estado, Float.parseFloat(precio), Boolean.parseBoolean(disponibilidad), tipoCompra, tipoPieza, Float.parseFloat(duracion), Float.parseFloat(espacioDeMemoria), detallesAdicionales);
    }






}