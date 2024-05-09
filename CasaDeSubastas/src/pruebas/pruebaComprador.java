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
    	Galeria.agregarlinea(archivo, linea);
    	
    	String nom = usuario.split("@")[0];
    	String ruta = ".\\data\\Comprador"+nom+".txt";
    	
    	File file = new File(ruta);

    	if(!file.exists())
    	{
    	   file.createNewFile();
    	}
    	Pieza pieza = new Pieza("Pablo Picasso", "La pintura", "03/01/1532", "China", "Bodega", 25000, "Vendida", "Transferencia electronica", "Pintura");;
    	Comprador comprador = new Comprador(usuario, rol, ID, cel, Float.parseFloat(limite), pieza);
    	
    	comprador.añadirPiezaHistorial(comprador);
    	
    	String[] p = Comprador.estadoPiezas(usuario).get(0);
    	
    	boolean comprobar = false;
    	
    	if(p[2].equals("La pintura") && p[5].equals("Bodega"))
    	{
    		comprobar = true;
    	}
    	
    	assertTrue(comprobar);
    	
	}
	
}
