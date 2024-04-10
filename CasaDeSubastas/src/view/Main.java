package view;



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import model.Galeria;


public class Main {
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
		
		Galeria galeria = new Galeria("Uniandes");

		String nombreObra = inputEnter("Digite el nombre de la Obra: ");
		String autorObra = inputEnter("Digite el autor de la Obra: ");
		String fecha = inputEnter("Digite la fecha de la Obra (dd/mm/YYYY): ");
		String lugar = inputEnter("Digite el lugar de la Obra: ");
		String estado = inputEnter("Digite el estado de la Obra: ");
		String precio = inputEnter("Digite el precio de la Obra: ");
		String disponibilidad = inputEnter("Digite la disponibilidad de la Obra (true/false): ");
		String tipoCompra = inputEnter("Digite el tipo de Compra de la Obra: ");
		String tipoPieza = inputEnter("Digite el tipo de pieza de la Obra: ");
		
		galeria.addPieza(autorObra, nombreObra, fecha, lugar, estado, Float.parseFloat(precio), Boolean.parseBoolean(disponibilidad), tipoCompra, tipoPieza);
	}
	

}


