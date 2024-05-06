package view;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import model.Administrador;
import model.Comprador;
import model.Galeria;
import model.Pagos;
import model.Pieza;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Main_admin {

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

        // Simular la autenticación

        System.out.println("Bienvenido al sistema de la Galeria");
        System.out.println("------------------------");
        String usuario = inputEnter("Ingrese su usuario: ");
        String contrasena = inputEnter("Ingrese su contrasena: ");
        
        contarUsuarios(usuario, contrasena);

        scanner.close();
    }







public static int contarUsuarios(String usuario, String contrasena) throws FileNotFoundException, IOException 
{ 
    String archivo = ".\\data\\PersistenciaAdmins.txt";
    int contador = 0; 
	FileReader reader = new FileReader( archivo );
	BufferedReader lector = new BufferedReader( reader ); 

	String linea = lector.readLine( ); 


	
 	while( linea != null ) { 
		contador++; 
        if (linea.contains(usuario) && linea.contains(contrasena)){

            System.out.println("Se registro con exito");
            System.out.println("\nQue desea hacer?");
            mostrarMenuAdmin(null);
            
        }
        else{

            System.out.println("Acceso denegado");
            
        }
    
	 	linea = lector.readLine( ); 
	} 
	 	lector.close( ); 
		reader.close( ); 
		return contador; 

    }


    private static void mostrarMenuAdmin(String[] args) throws FileNotFoundException, IOException{
        System.out.println("1. Registrar Pieza");
        System.out.println("2. Aumentar Limite de compras");
        System.out.println("3. Ver historia comprador");
        System.out.println("4. Salir");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Elija una opción: ");
        int opcion = scanner.nextInt();
        
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
                    scanner.next(); 
                }
            }
            break;
            case 2:
                System.out.print("Holaa: ");
                break;
            case 3:
                System.out.print("Holaaa: ");;
                break;
            case 4:
                System.out.println("Saliendo del sistema...");
                System.exit(0);
                break;
            default:
                System.out.println("Opción no válida");
        }
    }


	public static void req1(String[] args) throws FileNotFoundException, IOException {

        Galeria galeria = new Galeria("Uniandes");

        String nombreObra = inputEnter("Digite el nombre de la Obra: ");
        String autorObra = inputEnter("Digite el autor de la Obra: ");
        String fecha = inputEnter("Digite la fecha de la Obra (dd/mm/YYYY): ");
        String lugar = inputEnter("Digite el lugar de la Obra: ");
        String estado = inputEnter("Digite el estado de la Obra (Bodega/Exhibida): ");
        String precio = inputEnter("Digite el precio de la Obra: ");
        String disponibilidad = inputEnter("Digite la disponibilidad de la Obra (Vendida/Devuelta/Subastada/Disponible): ");
        String tipoCompra = inputEnter("Digite el tipo de Compra de la Obra (Efectivo/Transferencia electronica/Tarjeta de credito: ");
        String tipoPieza = inputEnter("Digite el tipo de pieza de la Obra: ");


        galeria.addPieza(autorObra, nombreObra, fecha, lugar, estado, Float.parseFloat(precio), disponibilidad, tipoCompra, tipoPieza);
    }

	public static void req1Escultura(String[] args) throws FileNotFoundException, IOException {

        Galeria galeria = new Galeria("Uniandes");

        String nombreObra = inputEnter("Digite el nombre de la Obra: ");
        String autorObra = inputEnter("Digite el autor de la Obra: ");
        String fecha = inputEnter("Digite la fecha de la Obra (dd/mm/YYYY): ");
        String lugar = inputEnter("Digite el lugar de la Obra: ");
        String estado = inputEnter("Digite el estado de la Obra: ");
        String precio = inputEnter("Digite el precio de la Obra: ");
        String disponibilidad = inputEnter("Digite la disponibilidad de la Obra (Vendida/Devuelta/Subastada/Disponible): ");
        String tipoCompra = inputEnter("Digite el tipo de Compra de la Obra: ");
        String tipoPieza = "Escultura";
		String dimensiones = inputEnter("Digite las dimensiones (Formato: AltoxAnchoxProfundidad) de la Obra: ");
		String materiales = inputEnter("Digite los materiales de la Obra: ");
		String peso = inputEnter("Digite el peso de la Obra en kilogramos: ");
		String necesidadElectricidad = inputEnter("¿Necesita de electricidad? (true/false): ");
		String tipoArte = inputEnter("Digite el tipo de Arte de la Obra: ");
		String detallesAdicionales = inputEnter("Digite detalles adicionales: ");

        galeria.addEscultura(autorObra, nombreObra, fecha, lugar, estado, Float.parseFloat(precio), disponibilidad, tipoCompra, tipoPieza, dimensiones, materiales, peso,
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
        String disponibilidad = inputEnter("Digite la disponibilidad de la Obra (Vendida/Devuelta/Subastada/Disponible): ");
        String tipoCompra = inputEnter("Digite el tipo de Compra de la Obra: ");
        String tipoPieza = "Pintura";
		String dimensiones = inputEnter("Digite las dimensiones (Formato: AltoxAnchoxProfundidad) de la Obra: ");
		String detallesAdicionales = inputEnter("Digite detalles adicionales: ");

        galeria.addPintura(autorObra, nombreObra, fecha, lugar, estado, Float.parseFloat(precio), disponibilidad, tipoCompra, tipoPieza, dimensiones, detallesAdicionales);
    }


	public static void req1Video(String[] args) throws FileNotFoundException, IOException {

        Galeria galeria = new Galeria("Uniandes");

        String nombreObra = inputEnter("Digite el nombre de la Obra: ");
        String autorObra = inputEnter("Digite el autor de la Obra: ");
        String fecha = inputEnter("Digite la fecha de la Obra (dd/mm/YYYY): ");
        String lugar = inputEnter("Digite el lugar de la Obra: ");
        String estado = inputEnter("Digite el estado de la Obra: ");
        String precio = inputEnter("Digite el precio de la Obra: ");
        String disponibilidad = inputEnter("Digite la disponibilidad de la Obra (Vendida/Devuelta/Subastada/Disponible): ");
        String tipoCompra = inputEnter("Digite el tipo de Compra de la Obra: ");
        String tipoPieza = "Video";
		String duracion = inputEnter("Digite la duracion en segundos: ");
		String espacioDeMemoria = inputEnter("Digite el espacio de memoria de la Obra (en MB): ");
		String detallesAdicionales = inputEnter("Digite detalles adicionales: ");

        galeria.addVideo(autorObra, nombreObra, fecha, lugar, estado, Float.parseFloat(precio), disponibilidad, tipoCompra, tipoPieza, Float.parseFloat(duracion), Float.parseFloat(espacioDeMemoria), detallesAdicionales);
    }


    




}