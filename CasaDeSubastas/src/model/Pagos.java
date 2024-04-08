package model;

public class Pagos {
    //----------------------------------------------
    // CONSTANTS
    //----------------------------------------------


    //----------------------------------------------
    // ATTRIBUTES
    //----------------------------------------------

    private String id;

    private float valorPago;

    private String comprador;

    //----------------------------------------------
    // CONSTRUCTOR
    //----------------------------------------------

    public Pagos(String ID, float VALORPAGO, String COMPRADOR){
        //TODO: Constructor pagos
    	this.id = ID;
    	this.valorPago = VALORPAGO;
    	this.comprador = COMPRADOR;
    }

    //----------------------------------------------
    // METHODS
    //----------------------------------------------
    
    
    public String getID()
    {
    	return this.id;
    }
    
    public float getValorPago()
    {
    	return this.valorPago;
    }
    
    public String getComprador()
    {
    	return this.comprador;
    }
    
    public void setID(String ID)
    {
    	this.id = ID;
    }
    
    public void setValorPago(float VALORPAGO)
    {
    	this.valorPago = VALORPAGO;
    }
    
    public void setComprador(String COMPRADOR)
    {
    	this.comprador = COMPRADOR;
    }
    
}
