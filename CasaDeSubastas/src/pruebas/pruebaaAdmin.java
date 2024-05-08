package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.Administrador;
import model.Galeria;
import model.Pieza;

class pruebaaAdmin {

	@Test
	public void probarRegistrarPieza()
	{
		Galeria galeria = new Galeria("Uniandes");

        String nombreObra = "Monalisa";
        String autorObra = "Leonardo";
        String fecha = "03/03/2020";
        String lugar = "Italia";
        String estado = "Bodega";
        String precio = "25000";
        String disponibilidad = "Disponible";
        String tipoCompra = "Efectivo";
        String tipoPieza = "Pintura";
		String dimensiones = "2x2x2";
		String detallesAdicionales = "Bonita";

        galeria.addPintura(autorObra, nombreObra, fecha, lugar, estado, Float.parseFloat(precio), disponibilidad, tipoCompra, tipoPieza, dimensiones, detallesAdicionales);
        ArrayList<Pieza> inventario = galeria.getInventario();
        int largo = inventario.size();
        Pieza pieza = inventario.get(largo-1);
        assertNotNull(pieza);
        
        assertTrue(pieza.getLugarDeCreacion().equals("Italia"));
	}
	
	@Test
	public void probarAumentarLimite()
	{
		String usuario = "cantin@comprador.com";
		
		int valIni = valorMax(usuario);
		
		Administrador.cambiarValorMaximoCompras(usuario);
		
		int valFin = valorMax(usuario);
		
		assertTrue(2*valIni == valFin);
	}
	
	public int valorMax(String usuario)
	{
		String ruta = ".\\data\\PersistenciaCompradores.txt";
    	File archivo = new File(ruta);
    	int val = 0;
    	try {
            List<String> lineas = Files.readAllLines(archivo.toPath());

            for (String linea : lineas) {
                if (linea.startsWith(usuario)) {
                	String[] partes = linea.split(";");
                	val = Integer.parseInt(partes[partes.length - 1]); 
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    	return val;
	}

}
