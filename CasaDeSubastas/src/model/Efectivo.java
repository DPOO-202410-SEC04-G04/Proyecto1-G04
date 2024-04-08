package model;

public class Efectivo extends Pagos {
    //----------------------------------------------
    // CONSTANTS
    //----------------------------------------------
	public static final String METODO = "Efectivo";

    //----------------------------------------------
    // ATTRIBUTES
    //----------------------------------------------

    private float dineroTotal;

    //----------------------------------------------
    // CONSTRUCTOR
    //----------------------------------------------

    public Efectivo(String id, float valorPago, String comprador, float dineroTotal){
        super(id, valorPago, comprador);
        this.dineroTotal = dineroTotal;
        
        //TODO: Constructor efectivo
    }

    //----------------------------------------------
    // METHODS
    //----------------------------------------------
    
    public float getDineroTotal()
    {
    	return this.dineroTotal;
    }
    
    public void setDineroTotal(float dinero)
    {
    	this.dineroTotal = dinero;
    }
    
    public String getFormaPago()
    {
    	return METODO;
    }
    
    public float calcularDevuelta()
    {
    	float ingreso = this.dineroTotal;
    	float precio = this.getValorPago();
    	return ingreso-precio;
    }
}
