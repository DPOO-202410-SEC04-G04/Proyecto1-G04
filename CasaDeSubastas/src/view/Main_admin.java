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







    public static int contarUsuarios(String usuario, String contrasena) throws IOException {
        String archivo = ".\\data\\PersistenciaAdmins.txt";
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
            	    mostrarMenuAdmin(datos);
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


    private static void mostrarMenuAdmin(String[] args) throws FileNotFoundException, IOException{
        System.out.println("1. Registrar Pieza");
        System.out.println("2. Aumentar Limite de compras");
        System.out.println("3. Ver historia comprador");
        System.out.println("4. Registrar comprador");
        System.out.println("5. Consultar Historial de un Artista");
        System.out.println("6. Consultar Historial de una pieza");
        System.out.println("7. Salir");
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
                String usuarioComprador = inputEnter("Ingrese el usuario del comprador: ");
                Administrador.cambiarValorMaximoCompras(usuarioComprador);
                System.out.println("Limite de compras aumentado exitosamente");
                break;
            case 3:
            	String user = inputEnter("Ingrese el usuario del comprador: ");
            	ArrayList<String[]> l = new ArrayList();
                l = Comprador.historialCompleto(user);
                System.out.println("Historial Piezas de "+user);
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
            	String archivo = ".\\data\\PersistenciaCompradores.txt";
            	String usuario = inputEnter("Ingrese el usuario del comprador: ");
            	String clave = inputEnter("Ingrese la clave del comprador: ");
            	String rol = "comprador";
            	String ID = inputEnter("Ingrese el ID del comprador: ");
            	String cel = inputEnter("Ingrese el celular del comprador: ");
            	String limite = inputEnter("Ingrese el limite de compras del comprador: ");
            	
            	String linea="\n";
            	linea+=usuario+";"+clave+";"+rol+";"+ID+";"+cel+";"+limite;
            	Galeria.agregarlinea(archivo, linea);
            	
            	String nom = usuario.split("@")[0];
            	String ruta = ".\\data\\Comprador"+nom+".txt";
            	
            	File file = new File(ruta);

            	if(!file.exists())
            	{
            	   file.createNewFile();
            	   System.out.println("Comprador registrado");
            	}
            	break;

            case 5:
                req4artista(args);
                break;
            
            case 6:
            	reqpieza(args);
            	break;
            case 7:
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
    
    public static void reqpieza(String[] args) throws FileNotFoundException, IOException {
        String nombreObra = inputEnter("Digite el nombre de la pieza: ");

        contarPiezas(nombreObra);

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

