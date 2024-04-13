package model;

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
    
    public ArrayList<Pieza> leerHistorial()
    {
    	
    }
    
    public float getTotalCompras()
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
    
    public void añadirPiezaHistorial(Pieza pieza)
    {
    	
    }
    
    public String lineaComprador(Pieza pieza)
    {
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
