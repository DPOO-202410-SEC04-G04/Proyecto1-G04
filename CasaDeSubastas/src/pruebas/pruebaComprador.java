package pruebas;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import model.Comprador;
import model.Galeria;
import model.Pieza;

public class pruebaComprador {
	@Test
	public void probarEstadoPiezas() throws IOException
	{
		String archivo = ".\\data\\PersistenciaCompradores.txt";
    	String usuario = "luna@comprador.com";
    	String clave = "1234";
    	String rol = "comprador";
    	String ID = "gs626wg27";
    	String cel = "30018273";
    	String limite = "50000";
    	
    	String linea="\n";
    	linea+=usuario+";"+clave+";"+rol+";"+ID+";"+cel+";"+limite;
    	
    	
    	String nom = usuario.split("@")[0];
    	String ruta = ".\\data\\Comprador"+nom+".txt";
    	File file = new File(ruta);

    	if(!file.exists())
    	{
    	   file.createNewFile();
    	}
    	
    	Galeria.agregarlinea(archivo, linea);
    	Pieza pieza = new Pieza("Pablo Picasso", "La pintura", "03/01/1532", "China", "Bodega", 25000, "Vendida", "Transferencia electronica", "Pintura");;
    	Comprador comprador = new Comprador(usuario, rol, ID, cel, Float.parseFloat(limite), pieza);
    	
    	comprador.añadirPiezaHistorial(comprador);
    	
    	String[] p = Comprador.estadoPiezas(usuario).get(0);
    	
    	assertTrue(p[2].equals("La pintura"));
    	assertTrue(p[5].equals("Bodega"));
    	
	}
	
	@Test
	public void probarHistorialPiezas() throws IOException
	{
		String archivo = ".\\data\\PersistenciaCompradores.txt";
    	String usuario = "armando@comprador.com";
    	String clave = "1234";
    	String rol = "comprador";
    	String ID = "jjue723";
    	String cel = "30631273";
    	String limite = "75000";
    	
    	String linea="\n";
    	linea+=usuario+";"+clave+";"+rol+";"+ID+";"+cel+";"+limite;
    	
    	
    	String nom = usuario.split("@")[0];
    	String ruta = ".\\data\\Comprador"+nom+".txt";
    	File file = new File(ruta);

    	if(!file.exists())
    	{
    	   file.createNewFile();
    	}
    	
    	Galeria.agregarlinea(archivo, linea);
    	Pieza pieza = new Pieza("Pirlo", "Cual es esa", "04/21/2024", "Cali", "Exhibida", 20000, "Disponible", "Efectivo", "Video");;
    	Comprador comprador = new Comprador(usuario, rol, ID, cel, Float.parseFloat(limite), pieza);
    	
    	comprador.añadirPiezaHistorial(comprador);
    	
    	String[] p = Comprador.historialCompleto(usuario).get(0);
    	
    	assertTrue(p[2].equals("Cual es esa"));
    	assertTrue(p[1].equals("Pirlo"));
    	
	}
	
	
}
