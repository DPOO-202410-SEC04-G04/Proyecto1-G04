package view;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
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


public class Main_Empleado {

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







    public static int contarUsuarios(String usuario, String contrasena) throws IOException {
        String archivo = ".\\data\\PersistenciaEmpleados.txt";
        int contador = 0;
        FileReader reader = new FileReader(archivo);
        BufferedReader lector = new BufferedReader(reader);
        List<List<String>> listaUsuarios = new ArrayList<>();
    
        String linea = lector.readLine();
        boolean contiene = false;
    
        while (linea != null) {
            String[] datos = linea.split(";");

                List<String> parUsuarioContrasena = new ArrayList<>();
                parUsuarioContrasena.add(datos[0]); // Usuario
                parUsuarioContrasena.add(datos[1]); // Contraseña
                listaUsuarios.add(parUsuarioContrasena);
                
                // Verificar si los datos leídos coinciden con los parámetros de usuario y contraseña
                if (datos[0].equals(usuario) && datos[1].equals(contrasena)) {
                    contiene = true;
                    System.out.println("Se registro con exito");
                System.out.println("\nQue desea hacer?");
                while(true)
                {
            	    mostrarMenuEmpleado(datos);
                }
                }
            
            contador++;
            linea = lector.readLine(); // Leer la próxima línea
        }
    
        lector.close();
        reader.close();
    
    
        if (!contiene) {
            System.out.println("Acceso Denegado");
        }
    
        return contador;
    }
    

    private static void mostrarMenuEmpleado(String[] args) throws FileNotFoundException, IOException{
        System.out.println("1. Consultar Historial de una Pieza");
        System.out.println("2. Consultar Historial de un Artista");
        System.out.println("3. Salir");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Elija una opción: ");
        int opcion = scanner.nextInt();
        
        switch (opcion) {
            case 1:
                reqpieza(args);
            break;
            case 2:
                req4artista(args);
                break;
            case 3:
                System.out.println("Saliendo del sistema...");
                System.exit(0);
                break;
            default:
                System.out.println("Opción no válida");
        }
    }


	public static void reqpieza(String[] args) throws FileNotFoundException, IOException {
        String nombreObra = inputEnter("Digite el nombre del artista: ");

        contarPiezas(nombreObra);

    }
    

	public static void req4artista(String[] args) throws FileNotFoundException, IOException {
        String nombreArtista = inputEnter("Digite el nombre del artista: ");

        contarArtistas(nombreArtista);

    }


    public static int contarArtistas(String nombreArtista) throws FileNotFoundException, IOException 
{ 
    String archivo = ".\\data\\ObrasdeArte.txt";
    int contador = 0; 
	FileReader reader = new FileReader( archivo );
	BufferedReader lector = new BufferedReader( reader ); 

	String linea = lector.readLine( ); 


    while (linea != null) {
        contador++;
        if (linea.contains(nombreArtista)) {
            String[] elementos = linea.split(";");
            List<String> lista = new ArrayList<>(Arrays.asList(elementos));
    
            // Asume un ancho predeterminado para cada columna basado en tus datos
            int[] columnWidths = new int[]{20, 12, 20, 10};
            String[][] tabla = new String[1][4];
            tabla[0][0] = lista.get(2);
            tabla[0][1] = lista.get(3);
            tabla[0][2] = lista.get(4);
            tabla[0][3] = lista.get(6);
    
            // Línea de separación y encabezados
            printLine(columnWidths);
            System.out.printf("| %-" + columnWidths[0] + "s | %-" + columnWidths[1] + "s | %-" + columnWidths[2] + "s | %" + columnWidths[3] + "s |%n", "Nombre", "Fecha", "Lugar", "Precio");
            printLine(columnWidths);
            
            // Datos de la tabla
            for (int i = 0; i < tabla.length; i++) {
                System.out.printf("| %-" + columnWidths[0] + "s | %-" + columnWidths[1] + "s | %-" + columnWidths[2] + "s | %" + columnWidths[3] + "s |%n", tabla[i][0], tabla[i][1], tabla[i][2], tabla[i][3]);
            }
            printLine(columnWidths);
        }
    
    
	 	linea = lector.readLine( ); 
	} 
	 	lector.close( ); 
		reader.close( ); 
		return contador; 

    }
    private static void printLine(int[] widths) {
        System.out.print("+");
        for (int width : widths) {
            for (int i = 0; i < width + 2; i++) { // +2 para los espacios extra alrededor del texto
                System.out.print("-");
            }
            System.out.print("+");
        }
        System.out.println();
    }



    public static void contarPiezas(String nombreObra) throws FileNotFoundException, IOException {
        String directoryPath = ".\\data\\";

        File folder = new File(directoryPath);
        File[] listOfFiles = folder.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.startsWith("Comprador") && name.endsWith(".txt");
            }
        });

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    System.out.println("Revisando archivo: " + file.getName());
                    searchArtworkInFile(file, nombreObra);
                }
            }
        } else {
            System.out.println("No se encontraron archivos o el directorio no existe.");
        }
    }

    private static void searchArtworkInFile(File file, String nombreObra) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int lineNumber = 1;
            boolean found = false;
            while ((line = br.readLine()) != null) {
                if (line.contains(nombreObra)) {
                    String[] items = line.split(";");
                    System.out.println(nombreObra + " encontrada en " + file.getName()  + ": " + Arrays.toString(items));
                    found = true;
                }
                lineNumber++;
            }
            if (!found) {
                System.out.println(nombreObra + " no encontrada en " + file.getName());
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + file.getName());
            e.printStackTrace();
        }
    }


}