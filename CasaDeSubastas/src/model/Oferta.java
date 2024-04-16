package model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;


public class Oferta {
    //----------------------------------------------
    // CONSTANTS
    //----------------------------------------------


    //----------------------------------------------
    // ATTRIBUTES
    //----------------------------------------------

    private String id;
    
    private String comprador;

    private float valorOfertado;


    //----------------------------------------------
    // CONSTRUCTOR
    //----------------------------------------------

    public Oferta(String comprador, float pValorOfertado){
        this.id = (UUID.randomUUID()).toString();
        this.comprador = comprador;
        this.valorOfertado = pValorOfertado;
    }

    //----------------------------------------------
    // METHODS
    //----------------------------------------------
    public void setComprador(String comprador)
    {
    	this.comprador = comprador;
    }
    public String getComprador()
    {
    	return this.comprador;
    }
    public void setValorOfertado(float valor)
    {
    	this.valorOfertado = valor;
    }
    public float getValorOfertado()
    {
    	return this.valorOfertado;
    }
    public void setID(String id)
    {
    	this.id = id;
    }
    public String getID()
    {
    	return this.id;
    }
}
