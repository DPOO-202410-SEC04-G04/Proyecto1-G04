package model;

import java.util.Date;

public class TarjetaDeCredito extends Pagos{
    //----------------------------------------------
    // CONSTANTS
    //----------------------------------------------
	public static final String METODO = "Tarjeta de credito";

    //----------------------------------------------
    // ATTRIBUTES
    //----------------------------------------------

    private long numero;

    private int codigoSeguridad;

    private Date fechaVencimiento;

    //----------------------------------------------
    // CONSTRUCTOR
    //----------------------------------------------

    public TarjetaDeCredito(String id, float valorPago, String comprador, long numero, int codigoSeguridad, Date fechaVencimiento){
        super(id, valorPago, comprador);
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
    
    public Date getFechaVencimiento()
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
    
    public void setFechaVencimiento(Date fechaVencimiento)
    {
    	this.fechaVencimiento = fechaVencimiento;
    }
    
    public String getFormaPago()
    {
    	return METODO;
    }
}
