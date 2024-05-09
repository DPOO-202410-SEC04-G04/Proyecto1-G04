package pruebas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import view.Main_Empleado;

class pruebaEmpleado {
	
	//Es necesario que dentro del archivo ObrasdeArte solamente existan 21 obras
	
	@Test
	public void probarHistoriaArtista() throws FileNotFoundException, IOException {
		String nombre = "Leonardo Da Vinci";
		int num = Main_Empleado.contarArtistas(nombre);
		String n = String.valueOf(num);
		assertTrue(n.equals("21"));
	}

}
