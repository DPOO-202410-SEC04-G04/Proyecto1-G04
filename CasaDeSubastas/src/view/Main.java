package view;



import java.io.FileNotFoundException;
import java.io.IOException;

import persistencia.PersistenciaUsuarios;

public class Main {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		PersistenciaUsuarios pu = new PersistenciaUsuarios("PersistenciaUsuarios.txt");
		pu.agregar();
	}
}
