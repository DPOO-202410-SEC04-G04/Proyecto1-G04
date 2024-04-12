package model;

public class Cajero extends Usuario{
    //----------------------------------------------
    // CONSTANTS
    //----------------------------------------------


    //----------------------------------------------
    // ATTRIBUTES
    //----------------------------------------------


    //----------------------------------------------
    // CONSTRUCTOR
    //----------------------------------------------


    public Cajero (String nombre, String tipoUsuario, String id, String cel){
        super(nombre, tipoUsuario, id, cel);
        //TODO: Constructor cajero
    }


    //----------------------------------------------
    // METHODS
    //----------------------------------------------
    
    public static void registrarPago(Pagos pago)
    {
    	String id = pago.getID();
    	float valor = pago.getValorPago();
    	Comprador comprador = pago.getComprador();
    	Pieza pieza = pago.getPiezaComprada();
    	String forma = pago.getFormaPago();
    	Galeria.addPago(id, valor, comprador, pieza, forma);
    }
}
