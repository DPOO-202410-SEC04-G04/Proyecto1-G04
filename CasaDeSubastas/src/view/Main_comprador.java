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


public class Main_comprador {

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
    String archivo = "C:\\Users\\david\\Downloads\\DPOO-PROY2\\Proyecto1-G04\\CasaDeSubastas\\data\\PersistenciaCompradores.txt";
    int contador = 0; 
	FileReader reader = new FileReader( archivo );
	BufferedReader lector = new BufferedReader( reader ); 

	String linea = lector.readLine( ); 


	
 	while( linea != null ) { 
		contador++; 
        if (linea.contains(usuario) && linea.contains(contrasena)){

            System.out.println("Se registro con exito");
            System.out.println("\nQue desea hacer?");
            while(true)
            {
            	mostrarMenuComprador(null);
            }
            
            
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


    private static void mostrarMenuComprador(String[] args) throws FileNotFoundException, IOException{
        System.out.println("1. Comprar Pieza");
        System.out.println("2. Consultar Estado de mis Piezas");
        System.out.println("3. Consultar Historial de mis Piezas");
        System.out.println("4. Realizar Pago");
        System.out.println("5. Salir");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Elija una opción: ");
        int opcion = scanner.nextInt();
        
        switch (opcion) {
            case 1:
            System.out.println("Ejecutando opción 3...");
            req3(args);
            int opcionSubmenu2 = 0;
            while (opcionSubmenu2 != 3) {
                System.out.println("\nSeleccione metodo de compra de Pieza:");
                System.out.println("1. Pagar Valor total");
                System.out.println("2. Por Subasta");
                System.out.println("3. Volver al Menú Principal");
                System.out.print("Seleccione una opción del submenú: ");
                
                if (scanner.hasNextInt()) {
                    opcionSubmenu2 = scanner.nextInt();
                    
                    switch (opcionSubmenu2) {
                        case 1:
                            System.out.println("Ejecutando Subopción 1...");
                            
                            req31(args);
                            break;


                        case 2:
                            System.out.println("Ejecutando Subopción 2...");
                            String nombre = inputEnter("\nIngrese el nombre de la obra: ");
                            Comprador.realizarOfertaSubasta(nombre);
                            
                            break;
                        
                        case 3:
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
            case 3:
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

            case 4:
            Random random = new Random();
            int num = random.nextInt(10000);
            String id = String.valueOf(num);
            float valorPago = 25000;
            Pieza pieza = new Pieza("Raul", "Cristiano", "01/07/1272", "Colombia", "Exhibida", 25000, "Vendida", "Transferencia electronica", "Pintura");
            Comprador comprador = new Comprador("Manuel", "Comprador", "C134", "3211913008", 999999999, pieza);
            Pagos pago = new Pagos(id, valorPago, comprador, pieza, "Transferencia electronica");
            Pagos.realizarPago(pago);
            break;

            case 5:
                System.out.println("Saliendo del sistema...");
                System.exit(0);
                break;
            default:
                System.out.println("Opción no válida");
        }
    }


    public static void req3(String[] args) throws FileNotFoundException, IOException {
        contarSubastas();
    }


    public static void req31(String[] args) throws FileNotFoundException, IOException {
    	String nombreObra = inputEnter("\nDigite el nombre de la Obra: ");
        contarLineasNombre(nombreObra);
    }

    public static int contarSubastas() throws FileNotFoundException, IOException 
{ 
	String archivo = ".\\data\\ObrasdeArte.txt";
	//String archivo = "C:\\Users\\USUARIO\\git\\Proyecto1-G04\\CasaDeSubastas\\data\\ObrasdeArte.txt";
    int contador = 0; 
	FileReader reader = new FileReader( archivo );
	BufferedReader lector = new BufferedReader( reader ); 

	String linea = lector.readLine( ); 


	
 	while( linea != null ) { 
		contador++; 
        if (linea.contains("Subastada") || linea.contains("Disponible")){

            String[] elementos=linea.split(";");
            List<String> lista = new ArrayList<>(Arrays.asList(elementos));

            System.out.println(lista);
            
        }
    
	 	linea = lector.readLine( ); 
	} 
	 	lector.close( ); 
		reader.close( ); 
		return contador; 

}

public static int contarLineasNombre(String nombreObra) throws IOException {

    String archivo = ".\\data\\ObrasdeArte.txt";
    //String archivo = "C:\\Users\\USUARIO\\git\\Proyecto1-G04\\CasaDeSubastas\\data\\ObrasdeArte.txt";
    List<String> lineas = new ArrayList<>();
    int contador = 0;

    try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
        String linea;

        while ((linea = lector.readLine()) != null) {
            if (linea.contains(nombreObra)) {
                String[] elementos = linea.split(";");
                List<String> lista = new ArrayList<>(Arrays.asList(elementos));
                Pieza pieza = new Pieza(lista.get(1), lista.get(2), lista.get(3), lista.get(4), lista.get(5), Float.parseFloat(lista.get(6)), lista.get(7), lista.get(8), lista.get(9));;
                if (!lista.get(7).equals("Vendida") && !lista.get(7).equals("Devuelta")) {
                    lista.set(7, "Vendida");
                    linea = String.join(";", lista);


                    Random random = new Random();
                    int num = random.nextInt(10000);
                    String id = String.valueOf(num);
                    float valorPago = 25000;

                    Comprador comprador = new Comprador("Manuel", "Comprador", "C134", "3211913008", 999999999, pieza);
                    Pagos pago = new Pagos(id, valorPago, comprador, pieza, "Transferencia electronica");

                    Pagos.realizarPago(pago);

                }
            }
            lineas.add(linea);
            contador++;
        }
    }


    try (BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo))) {
        for (String linea : lineas) {
            escritor.write(linea);
            escritor.newLine();
        }
    }

    return contador;
}

    }