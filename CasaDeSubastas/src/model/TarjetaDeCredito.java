package model;

import java.util.Date;

public class TarjetaDeCredito extends Pagos{
    //----------------------------------------------
    // CONSTANTS
    //----------------------------------------------
	public static final String METODO = "Tarjeta de Credito";

    //----------------------------------------------
    // ATTRIBUTES
    //----------------------------------------------

    private long numero;

    private int codigoSeguridad;

    private String fechaVencimiento;

    //----------------------------------------------
    // CONSTRUCTOR
    //----------------------------------------------

    public TarjetaDeCredito(String id, float valorPago, Comprador comprador, Pieza piezaComprada, String formaPago, long numero, int codigoSeguridad, String fechaVencimiento){
        super(id, valorPago, comprador, piezaComprada, formaPago);
        this.numero = numero;
        this.codigoSeguridad = codigoSeguridad;
        this.fechaVencimiento = fechaVencimiento;
        //TODO: Constructor tarjeta de credito
    }

    //----------------------------------------------
    // METHODS
    //----------------------------------------------
    
    public long getNumero()
    {
    	return this.numero;
    }
    
    public int getCodigoSeguridad()
    {
    	return this.codigoSeguridad;
    }
    
    public String getFechaVencimiento()
    {
    	return this.fechaVencimiento;
    }
    
    public void setNumero(long numero)
    {
    	this.numero = numero;
    }
    
    public void setCodigoSeguridad(int codigoSeguridad)
    {
    	this.codigoSeguridad = codigoSeguridad;
    }
    
    public void setFechaVencimiento(String fechaVencimiento)
    {
    	this.fechaVencimiento = fechaVencimiento;
    }
    
    public String getFormaPago()
    {
    	return METODO;
    }
}
