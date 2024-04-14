package view;



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
            System.out.println("2. Confirmar Disponibilidad de Obra ");
            System.out.println("3. Comprar Pieza ");
			System.out.println("4. Realizar Subasta ");
			System.out.println("5. Consultar Estado de mis Piezas ");
			System.out.println("6. Consultar Historial de mis Piezas ");
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

                    case 2:
                        System.out.println("Ejecutando opción 2...");
                        req2(args);
                        break;
                    case 3:
                        System.out.println("Ejecutando opción 3...");
                        // Aquí puedes agregar la lógica específica para la opción 3
                        break;
                    case 5:
                    	Pieza piezap1 = new Pieza("Pablo Picasso", "La pintura", "03/01/1532", "China", "Bodega", 25000, "vendida", "Transferencia electronica", "Pintura");
                    	Comprador compradorp1 = new Comprador("Manuel", "Comprador", "C134", "3211913008", 50000, piezap1);
                    	ArrayList<String[]> list = new ArrayList();
                    	list = compradorp1.estadoPiezas();
                    	for(String[] linea: list)
                    	{
                    		System.out.println("Pieza: "+linea[2]);
                    		System.out.println("Estado: "+linea[5]);
                    	}
                    	break;
                    case 6:
                    	Pieza piezap2 = new Pieza("Pablo Picasso", "La pintura", "03/01/1532", "China", "Bodega", 25000, "vendida", "Transferencia electronica", "Pintura");
                    	Comprador compradorp2 = new Comprador("Manuel", "Comprador", "C134", "3211913008", 50000, piezap2);
                    	ArrayList<String[]> l = new ArrayList();
                    	l = compradorp2.historialCompleto();
                    	System.out.println("Historial Piezas de "+compradorp2.getNombre());
                    	for(String[] linea: l)
                    	{
                    		System.out.println("------------------------------------------------------------------");
                    		System.out.println("ID: "+linea[0]);
                    		System.out.println("Autor: "+linea[1]);
                    		System.out.println("Pieza: "+linea[2]);
                    		System.out.println("Fecha: "+linea[3]);
                    		System.out.println("Lugar de creacion: "+linea[4]);
                    		System.out.println("Estado: "+linea[5]);
                    		System.out.println("Precio: "+linea[6]);
                    		System.out.println("Disponibilidad: "+linea[7]);
                    		System.out.println("Metodo de pago: "+linea[8]);
                    		System.out.println("Tipo de pieza: "+linea[9]);
                    		System.out.println("Propietario de la pieza: "+linea[10]);
                    	}
                    	break;
                    case 7:
                    	Pieza piezap = new Pieza("Pablo Picasso", "La pintura", "03/01/1532", "China", "Bodega", 25000, "vendida", "Transferencia electronica", "Pintura");
                    	Comprador compradorp = new Comprador("Manuel", "Comprador", "C134", "3211913008", 50000, piezap);
                    	Administrador.cambiarValorMaximoCompras(compradorp);
                    	String nombre = compradorp.getNombre();
                    	float limite = compradorp.getValorMaxCompra();
                    	System.out.println("El limite de "+ nombre+" aumentó a " + limite);
                    	break;
                    case 8:
                    	Random random = new Random();
                    	int num = random.nextInt(10000);
                    	String id = String.valueOf(num);
                    	float valorPago = 25000;
                    	Pieza pieza = new Pieza("Raul", "Cristiano", "01/07/1272", "Colombia", "Exhibida", 25000, "Vendida", "Transferencia electronica", "Pintura");
                    	Comprador comprador = new Comprador("Angel", "Comprador", "C111", "3091723678", 100000, pieza);
                    	Pagos pago = new Pagos(id, valorPago, comprador, pieza, "Transferencia electronica");
                    	pago.realizarPago(pago);
                    	System.out.println("Pago realizado exitosamente");
                    	break;
                    case 9:
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
        String estado = inputEnter("Digite el estado de la Obra (Bodega/Exhibida): ");
        String precio = inputEnter("Digite el precio de la Obra: ");
        String disponibilidad = inputEnter("Digite la disponibilidad de la Obra (Vendida/Devuelta/Subastada): ");
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
        String disponibilidad = inputEnter("Digite la disponibilidad de la Obra (Vendida/Devuelta/Subastada): ");
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
        String disponibilidad = inputEnter("Digite la disponibilidad de la Obra (Vendida/Devuelta/Subastada): ");
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
        String disponibilidad = inputEnter("Digite la disponibilidad de la Obra (Vendida/Devuelta/Subastada): ");
        String tipoCompra = inputEnter("Digite el tipo de Compra de la Obra: ");
        String tipoPieza = "Video";
		String duracion = inputEnter("Digite la duracion en segundos: ");
		String espacioDeMemoria = inputEnter("Digite el espacio de memoria de la Obra (en MB): ");
		String detallesAdicionales = inputEnter("Digite detalles adicionales: ");

        galeria.addVideo(autorObra, nombreObra, fecha, lugar, estado, Float.parseFloat(precio), disponibilidad, tipoCompra, tipoPieza, Float.parseFloat(duracion), Float.parseFloat(espacioDeMemoria), detallesAdicionales);
    }











    public static void req2(String[] args) throws FileNotFoundException, IOException {

        Galeria galeria = new Galeria("Uniandes");
        String nombreObra = inputEnter("\nDigite el nombre de la Obra: ");
        contarLineas(nombreObra);
    }







public static int contarLineas(String nombreObra) throws FileNotFoundException, IOException 
{ 
	String archivo = "C:\\Users\\USUARIO\\git\\Proyecto1-G04\\CasaDeSubastas\\data\\ObrasdeArte.txt";
    int contador = 0; 
	FileReader reader = new FileReader( archivo );
	BufferedReader lector = new BufferedReader( reader ); 

	String linea = lector.readLine( ); 


	
 	while( linea != null ) { 
		contador++; 
        if (linea.contains(nombreObra)){

            String[] elementos=linea.split(";");
            List<String> lista = new ArrayList<>(Arrays.asList(elementos));

            System.out.println("Disponibilidad: "+lista.get(7));
            
        }
    
	 	linea = lector.readLine( ); 
	} 
	 	lector.close( ); 
		reader.close( ); 
		return contador; 

        
}





}