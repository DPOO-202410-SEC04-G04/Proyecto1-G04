package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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

    public Comprador(String nombre, String tipoUsuario, String id, String cel, float pValorMaxCompra, Pieza pieza){
        super(nombre, tipoUsuario, id, cel);
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
    
    public ArrayList<String[]> estadoPiezas() throws FileNotFoundException, IOException
    {
    	String archivo = "C:\\Users\\USUARIO\\git\\Proyecto1-G04\\CasaDeSubastas\\data\\HistorialComprador.txt";
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
    
    public ArrayList<String[]> historialCompleto() throws FileNotFoundException, IOException
    {
    	String archivo = "C:\\Users\\USUARIO\\git\\Proyecto1-G04\\CasaDeSubastas\\data\\HistorialComprador.txt";
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
    
    public ArrayList<Pieza> leerHistorial() throws FileNotFoundException, IOException
    {
    	String archivo = "C:\\Users\\USUARIO\\git\\Proyecto1-G04\\CasaDeSubastas\\data\\HistorialComprador.txt";
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
    	ArrayList<Pieza> lista = leerHistorial();
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
    	texto+="\n"+id+";"+autor+";"+titulo+";"+anio+";"+lugar+";"+estado+";"+precio+";"+disponibilidad+";"+tipoCompra+";"+tipoPieza+";"+String.valueOf(esPropiedad);
    	return texto;
    }

    public void realizarCompraPrecioFijo(String idCompraDirecta, float valorOfertado){
        /*
        un usuario registrado como comprador en la plataforma podrá
        ofrecerse a realizar la compra.
        En ese momento la pieza quedará bloqueada
        (nadie más podrá comprarla) hasta que el
        administrador del sistema verifique que el usuario sea real
        y la seriedad de la oferta.
        En caso positivo, la pieza quedará vendida. En caso negativo, volverá a su estado anterior. Las piezas que estén en la bodega de la galería también pueden ser vendidas – no sólo las que estén exhibidas.
         */



        //Crear oferta
        Oferta ofertaCompraPrecioFijo = new Oferta(valorOfertado);

        //Asignar oferta a compra directa





    }

    public void realizarOfertaSubasta(){

    }
    
    
}
