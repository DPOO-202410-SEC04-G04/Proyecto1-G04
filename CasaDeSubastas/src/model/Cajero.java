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
    	Galeria.addPago(pago);
    }
}
