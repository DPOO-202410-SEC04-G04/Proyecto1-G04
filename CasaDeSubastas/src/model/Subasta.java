package model;

import java.util.Date;
import java.util.UUID;

public class Subasta {

    //----------------------------------------------
    // CONSTANTS
    //----------------------------------------------



    //----------------------------------------------
    // ATRIBUTES
    //----------------------------------------------

    private String id;

    private Date fecha;

    private float valorInicial;

    private float valorMinimo;


    //----------------------------------------------
    // CONSTRUCTOR
    //----------------------------------------------

    public Subasta(float pValorInicial,float pValorMinimo){
        this.valorInicial = pValorInicial;
        this.valorMinimo = pValorMinimo;
        this.fecha = new Date();
        this.id =  UUID.randomUUID().toString();
    }

    //----------------------------------------------
    // METHODS
    //----------------------------------------------


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(float valorInicial) {
        this.valorInicial = valorInicial;
    }

    public float getValorMinimo() {
        return valorMinimo;
    }

    public void setValorMinimo(float valorMinimo) {
        this.valorMinimo = valorMinimo;
    }
}
