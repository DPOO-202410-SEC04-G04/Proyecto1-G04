package model;

import java.util.ArrayList;
import model.Comprador;

public class Pagos {
    //----------------------------------------------
    // CONSTANTS
    //----------------------------------------------


    //----------------------------------------------
    // ATTRIBUTES
    //----------------------------------------------

    private String id;

    private float valorPago;

    private Comprador comprador;
    
    private Pieza piezaComprada;
    
    private String formaPago;

    //----------------------------------------------
    // CONSTRUCTOR
    //----------------------------------------------

    public Pagos(String ID, float VALORPAGO, Comprador COMPRADOR, Pieza piezaComprada, String formaPago){
        //TODO: Constructor pagos
    	this.id = ID;
    	this.valorPago = VALORPAGO;
    	this.comprador = COMPRADOR;
    	this.piezaComprada = piezaComprada;
    	this.formaPago = formaPago;
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
    
    public Comprador getComprador()
    {
    	return this.comprador;
    }
    
    public Pieza getPiezaComprada()
    {
    	return this.piezaComprada;
    }
    
    public void setID(String ID)
    {
    	this.id = ID;
    }
    
    public void setValorPago(float VALORPAGO)
    {
    	this.valorPago = VALORPAGO;
    }
    
    public void setComprador(Comprador COMPRADOR)
    {
    	this.comprador = COMPRADOR;
    }
    
    public void setPiezaComprada(Pieza PIEZA)
    {
    	this.piezaComprada = PIEZA;
    }
    
    public String getFormaPago()
    {
    	return this.formaPago;
    }
    
    public void realizarPago(Pagos pago)
    {
    	float limite = pago.comprador.getValorMaxCompra();
    	ArrayList<Pieza> lista = pago.comprador.getHistorialPiezas();
    	float valorPieza = pago.piezaComprada.getPrecio();
    	float suma = 0;
    	for(Pieza pieza : lista)
    	{
    		suma += pieza.getPrecio();
    	}
    	if((suma+valorPieza)>limite)
    	{
    		System.out.println("El valor de la compra excede el limite permitido");
    	}
    	else
    	{
    		pago.comprador.setValorMaxCompra(suma+valorPieza);
    		
    	}
    }
    
}
