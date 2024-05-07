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
	
	private static String usuario;

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
        usuario = inputEnter("Ingrese su usuario: ");
        String contrasena = inputEnter("Ingrese su contrasena: ");
        
        contarUsuarios(usuario, contrasena);

        scanner.close();
    }







public static int contarUsuarios(String usuario, String contrasena) throws FileNotFoundException, IOException 
{ 
    String archivo = ".\\data\\PersistenciaCompradores.txt";
    int contador = 0; 
	FileReader reader = new FileReader( archivo );
	BufferedReader lector = new BufferedReader( reader ); 

	String linea = lector.readLine( ); 

	boolean contiene = false;
	
 	while( linea != null ) { 
		contador++; 
        if (linea.contains(usuario) && linea.contains(contrasena)){
        	contiene = true;

            System.out.println("Se registro con exito");
            System.out.println("\nQue desea hacer?");
            while(true)
            {
            	mostrarMenuComprador(null);
            }
            
            
            
        }
    
	 	linea = lector.readLine( ); 
	} 
	 	lector.close( ); 
		reader.close( ); 
		if(contiene==false)
		{
			System.out.println("Acceso denegado");
            System.exit(0);
		}
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
            System.out.println("Ejecutando opción 1...");
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
	            ArrayList<String[]> list = new ArrayList();
	            list = Comprador.estadoPiezas(usuario);
	            for(String[] linea: list)
	            {
	                System.out.println("Pieza: "+linea[2]);
	                System.out.println("Estado: "+linea[3]);
	            }
	            break;
            case 3:
            ArrayList<String[]> l = new ArrayList();
            l = Comprador.historialCompleto(usuario);
            System.out.println("Historial Piezas de "+usuario);
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
            String nombreObra = inputEnter("Digite el nombre de la Obra: ");
            String autorObra = inputEnter("Digite el autor de la Obra: ");
            String fecha = inputEnter("Digite la fecha de la Obra (dd/mm/YYYY): ");
            String lugar = inputEnter("Digite el lugar de la Obra: ");
            String estado = inputEnter("Digite el estado de la Obra (Bodega/Exhibido): ");
            System.out.println("Ingrese el valor del pago");
            float valorPago = scanner.nextInt();
            String disponibilidad = inputEnter("Digite la disponibilidad de la Obra (Vendida/Devuelta/Subastada/Disponible): ");
            String tipoCompra = inputEnter("Digite el tipo de Compra de la Obra: ");
            String tipoObra = inputEnter("Ingrese el tipo de la pieza: ");
            
            Pieza pieza = new Pieza(autorObra, nombreObra, fecha, lugar, estado, valorPago, disponibilidad, tipoCompra, tipoObra);
            Comprador comprador = new Comprador(usuario, "Comprador", "C134", "3211913008", 999999999, pieza);
            Pagos pago = new Pagos(id, valorPago, comprador, pieza, tipoCompra);
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
                    List<String> info = buscarUsuario();
                    Comprador comprador = new Comprador(usuario, "Comprador", info.get(3), info.get(4), Float.parseFloat(info.get(5)), pieza);
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
public static List<String> buscarUsuario() throws IOException, FileNotFoundException
{
	String archivo = ".\\data\\PersistenciaCompradores.txt";
	FileReader leer = new FileReader( archivo );
	BufferedReader lector1 = new BufferedReader( leer ); 

	String linea1 = lector1.readLine( );
	List<String> lista1 = new ArrayList<>();
	while( linea1 != null ) {
		String[] L = linea1.split(";");
		if(L[0].equals(usuario))
		{
			lista1 = new ArrayList<>(Arrays.asList(L));
		}
		
		linea1 = lector1.readLine( ); 
	}
	lector1.close( ); 
	leer.close( ); 
	return lista1;
}


}