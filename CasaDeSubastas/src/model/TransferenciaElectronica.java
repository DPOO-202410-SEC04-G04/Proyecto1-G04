package model;

public class TransferenciaElectronica extends Pagos {
    //----------------------------------------------
    // CONSTANTS
    //----------------------------------------------
	public static final String METODO = "Transferencia electronica";

    //----------------------------------------------
    // ATTRIBUTES
    //----------------------------------------------

    private long numeroCuenta;

    //----------------------------------------------
    // CONSTRUCTOR
    //----------------------------------------------

    public TransferenciaElectronica(String id, float valorPago, Comprador comprador, Pieza piezaComprada, String formaPago, long numeroCuenta){
        super(id, valorPago, comprador, piezaComprada, formaPago);
        this.numeroCuenta = numeroCuenta;
        //TODO: Constructor Transferencia Electronica
    }

    //----------------------------------------------
    // METHODS
    //----------------------------------------------
    
    public long getNumeroCuenta()
    {
    	return this.numeroCuenta;
    }
    
    public void setNumeroCuenta(long num)
    {
    	this.numeroCuenta = num;
    }
    
    public String getFormaPago()
    {
    	return METODO;
    }
}
