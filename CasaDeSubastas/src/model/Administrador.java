package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class Administrador extends Usuario{

    //----------------------------------------------
    // CONSTANTS
    //----------------------------------------------


    //----------------------------------------------
    // ATTRIBUTES
    //----------------------------------------------


    //----------------------------------------------
    // CONSTRUCTOR
    //----------------------------------------------

    public Administrador (String nombre, String tipoUsuario, String id, String cel){
        super(nombre, tipoUsuario, id, cel);
        //TODO: Constructor model.Administrador
    }

    //----------------------------------------------
    // METHODS
    //----------------------------------------------
    
    public static void cambiarValorMaximoCompras(String usuario)
    {
    	String ruta = ".\\data\\PersistenciaCompradores.txt";
    	File archivo = new File(ruta);
    	
    	try {
            List<String> lineas = Files.readAllLines(archivo.toPath());
            FileWriter writer = new FileWriter(archivo, false); 

            for (String linea : lineas) {
                if (linea.startsWith(usuario)) {
                	String[] partes = linea.split(";");
                	int valorActual = Integer.parseInt(partes[partes.length - 1]);
                    int nuevoValor = valorActual * 2;
                    partes[partes.length - 1] = String.valueOf(nuevoValor);
                    String nuevaLinea = String.join(";", partes) + System.lineSeparator();
                    writer.write(nuevaLinea);
                } else {
                    // Si no, escribir la línea original
                    writer.write(linea + System.lineSeparator());
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    


}
