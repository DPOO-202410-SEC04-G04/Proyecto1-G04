package model;

public class Administrador extends Usuario{

    //----------------------------------------------
    // CONSTANTS
    //----------------------------------------------


    //----------------------------------------------
    // ATTRIBUTES
    //----------------------------------------------


    //----------------------------------------------
    // CONSTRUCTOR
    //----------------------------------------------

    public Administrador (String nombre, String tipoUsuario, String id, String cel){
        super(nombre, tipoUsuario, id, cel);
        //TODO: Constructor model.Administrador
    }

    //----------------------------------------------
    // METHODS
    //----------------------------------------------
    
    public static void cambiarValorMaximoCompras(Comprador comprador)
    {
    	float lim = comprador.getValorMaxCompra();
    	comprador.setValorMaxCompra(lim*2);
    }
    


}
