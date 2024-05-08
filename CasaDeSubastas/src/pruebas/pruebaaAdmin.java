package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

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

}
