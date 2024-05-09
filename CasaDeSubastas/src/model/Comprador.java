package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Comprador extends Usuario{

    //----------------------------------------------
    // CONSTANTS
    //----------------------------------------------


    //----------------------------------------------
    // ATTRIBUTES
    //----------------------------------------------

    private float valorMaxCompra;

    private Pieza piezaComprada;

    //----------------------------------------------
    // CONSTRUCTOR
    //----------------------------------------------

    public Comprador(String usuario, String tipoUsuario, String id, String cel, float pValorMaxCompra, Pieza pieza){
        super(usuario, tipoUsuario, id, cel);
        this.valorMaxCompra = pValorMaxCompra;
        this.piezaComprada = pieza;
    }

    

    //----------------------------------------------
    // METHODS
    //----------------------------------------------
    
    public float getValorMaxCompra()
    {
    	return this.valorMaxCompra;
    }
    
    public static ArrayList<String[]> estadoPiezas(String usuario) throws FileNotFoundException, IOException
    {
    	String archivo = ".\\data\\Comprador"+usuario.split("@")[0]+".txt";
    	FileReader reader = new FileReader( archivo );
    	BufferedReader lector = new BufferedReader( reader ); 
    	ArrayList<String[]> lista = new ArrayList();

    	String linea = lector.readLine( );
    	while(linea!=null)
    	{
    		String partes[] = linea.split(";");
    		if(partes[10].equals("true"))
    			lista.add(partes);
    		linea = lector.readLine( );
    	}
    	
    	lector.close( ); 
		reader.close( ); 
		return lista;
    	
    }
    
    public static ArrayList<String[]> historialCompleto(String usuario) throws FileNotFoundException, IOException
    {
    	String archivo = ".\\data\\Comprador"+usuario.split("@")[0]+".txt";
    	FileReader reader = new FileReader( archivo );
    	BufferedReader lector = new BufferedReader( reader ); 
    	ArrayList<String[]> lista = new ArrayList();

    	String linea = lector.readLine( );
    	while(linea!=null)
    	{
    		String partes[] = linea.split(";");
    		lista.add(partes);
    		linea = lector.readLine( );
    	}
    	
    	lector.close( ); 
		reader.close( ); 
		return lista;
    	
    }
    
    public ArrayList<Pieza> leerHistorial(String Usuario) throws FileNotFoundException, IOException
    {
    	String u = Usuario.split("@")[0];
    	String archivo = ".\\data\\Comprador"+u+".txt";
    	//String archivo = "C:\\Users\\USUARIO\\git\\Proyecto1-G04\\CasaDeSubastas\\data\\HistorialComprador.txt";
    	FileReader reader = new FileReader( archivo );
    	BufferedReader lector = new BufferedReader( reader ); 

    	String linea = lector.readLine( );
    	
    	ArrayList<Pieza> lista = new ArrayList();
    	
    	while(linea!=null)
    	{
    		String partes[] = linea.split(";");
    		Pieza pieza = new Pieza(partes[1], partes[2], partes[3], partes[4], partes[5], Float.parseFloat(partes[6]), partes[7], partes[8], partes[9]);
    		pieza.setId(partes[0]);
    		lista.add(pieza);
    		linea = lector.readLine( );
    	}
    	lector.close( ); 
		reader.close( ); 
    	return lista;
    }
    
    public float getTotalCompras() throws FileNotFoundException, IOException
    {
    	String usuario = this.getNombre();
    	ArrayList<Pieza> lista = leerHistorial(usuario);
    	float suma = 0;
    	
    	for(Pieza pieza: lista)
    	{
    		float precioPieza = pieza.getPrecio();
    		suma+=precioPieza;
    	}
    	return suma;
    }
    
    public Pieza getPiezaComprada()
    {
    	return this.piezaComprada;
    }
    
    public void setValorMaxCompra(float valor)
    {
    	this.valorMaxCompra = valor;
    }
    
    public void setPiezaComprada(Pieza pieza)
    {
    	this.piezaComprada = pieza;
    }
    
    public void añadirPiezaHistorial(Comprador comprador)
    {
    	Galeria.addObraHistorial(comprador);
    }
    
    public String lineaComprador(Comprador comprador)
    {
    	Pieza pieza = comprador.piezaComprada;
    	String texto = "";
    	String id = pieza.getId();
    	String autor = pieza.getAutor();
    	String titulo = pieza.getTitulo();
    	String anio = pieza.getAnio();
    	String lugar = pieza.getLugarDeCreacion();
    	String estado = pieza.getEstado();
    	String precio = String.valueOf(pieza.getPrecio());
    	String disponibilidad = pieza.isDisponibilidad();
    	String tipoCompra = pieza.getTipoCompra();
    	String tipoPieza = pieza.getTipoPieza();
    	boolean esPropiedad = false;
    	if(disponibilidad.equals("Vendida"))
    	{
    		esPropiedad = true;
    	}
    	texto+=id+";"+autor+";"+titulo+";"+anio+";"+lugar+";"+estado+";"+precio+";"+disponibilidad+";"+tipoCompra+";"+tipoPieza+";"+String.valueOf(esPropiedad)+"\n";
    	return texto;
    }



    public static void realizarOfertaSubasta(String pieza) throws FileNotFoundException, IOException{
    	String a = ".\\data\\ObrasdeArte.txt";
    	FileReader leer = new FileReader( a );
    	BufferedReader lector1 = new BufferedReader( leer ); 

    	String linea1 = lector1.readLine( );
    	List<String> lista1 = new ArrayList();
    	while( linea1 != null ) { 
            if (linea1.contains(pieza)){

                String[] elementos=linea1.split(";");
                lista1 = new ArrayList<>(Arrays.asList(elementos));
            }
        
    	 	linea1 = lector1.readLine( ); 
    	} 
    	 	lector1.close( ); 
    		leer.close( ); 
    	float precio = Float.parseFloat(lista1.get(6));
    	float valorInicial = precio/2;
    	float valorMinimo = (float) (precio*0.75);
    	String archivo = ".\\data\\HistorialOfertas.txt";
    	
    	FileReader reader = new FileReader( archivo );
    	BufferedReader lector = new BufferedReader( reader ); 

    	String linea = lector.readLine( ); 
    	float ofertaActual = 0;
    	
    	while(linea!=null)
    	{
    		String[] lista = linea.split(";");
    		float monto = Float.parseFloat(lista[2]);
    		if(monto >= valorInicial && monto > ofertaActual)
    		{
    			ofertaActual = monto;
    		}
    		linea=lector.readLine();
    	}
    	lector.close();
    	reader.close();
    	if(ofertaActual < valorMinimo)
    	{
    		System.out.println("No se puede vender la obra ya que la oferta no alcanza el valor minimo para vender la obra");
    	}
    	else
    	{
    		String arch = ".\\data\\ObrasdeArte.txt";
    		List<String> lineas = new ArrayList<>();
    		try (BufferedReader lec = new BufferedReader(new FileReader(arch))) {
    	        String lin;

    	        while ((lin = lec.readLine()) != null) {
    	            if (lin.contains(pieza)) {
    	                String[] elementos = lin.split(";");
    	                List<String> lista = new ArrayList<>(Arrays.asList(elementos));
    	                Pieza piez = new Pieza(lista.get(1), lista.get(2), lista.get(3), lista.get(4), lista.get(5), Float.parseFloat(lista.get(6)), lista.get(7), lista.get(8), lista.get(9));;
    	                if (lista.get(7).equals("Subastada")) {
    	                    lista.set(7, "Vendida");
    	                    lin = String.join(";", lista);


    	                    Random random = new Random();
    	                    int num = random.nextInt(10000);
    	                    String id = String.valueOf(num);
    	                    float valorPago = 25000;

    	                    Comprador comprador = new Comprador("cantin@comprador.com", "Comprador", "C134", "3211913008", 999999999, piez);
    	                    Pagos pago = new Pagos(id, valorPago, comprador, piez, "Transferencia electronica");

    	                    Pagos.realizarPago(pago);
    	                    System.out.println("Subasta completada exitosamente");

    	                }
    	                else
    	                {
    	                	System.out.println("La pieza no está disponible para subastarla");
    	                	break;
    	                }
    	            }
    	            lineas.add(lin);
    	        }
    	    }


    	    try (BufferedWriter escritor = new BufferedWriter(new FileWriter(arch))) {
    	        for (String l : lineas) {
    	            escritor.write(l);
    	            escritor.newLine();
    	        }

    	}
    	}
    	
    }
    
    
}
