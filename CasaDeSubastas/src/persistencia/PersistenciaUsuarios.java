package persistencia;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;

public class PersistenciaUsuarios {
	private String nombre;
	public PersistenciaUsuarios(String nombre) {
		this.nombre = nombre;
	}
	
	public void agregar() throws FileNotFoundException, IOException{
		ObjectOutputStream copiaAux = new ObjectOutputStream(new FileOutputStream("copiaAuxiliar.txt"));
		ObjectInputStream archivo = new ObjectInputStream( new FileInputStream(this.nombre));
		try {
			while(true) {
				String usuario = (String) archivo.readObject();
				copiaAux.writeObject(usuario);
			}
		}	catch (Exception e) {
			Scanner sc = new Scanner(System.in);
			String nuevoUsuario = sc.next();
			copiaAux.writeObject(nuevoUsuario);
			
			copiaAux.close();
			archivo.close();
			
			File fArchivo = new File(this.nombre);
			File fCopiaArchivo = new File("CopiaAuxiliar.txt");
			
			fArchivo.delete();
			fCopiaArchivo.renameTo(fArchivo);
			System.out.println("Usuario agregado exitosamente");
		}
	}
}
