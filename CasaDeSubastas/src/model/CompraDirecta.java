package model;

import java.util.Date;
import java.util.UUID;

public class CompraDirecta {

    //----------------------------------------------
    // CONSTANTS
    //----------------------------------------------


    //----------------------------------------------
    // ATTRIBUTES
    //----------------------------------------------

    private String id;

    private Date fecha;

    private float valor;

    private EstadoOferta ofertaRealizada;

    private Pieza pieza;

    private Oferta oferta;

    //----------------------------------------------
    // CONSTRUCTOR
    //----------------------------------------------

    public CompraDirecta(float pValor,Pieza pPieza){
        this.valor = pValor;
        this.fecha = new Date();
        this.id =  UUID.randomUUID().toString();
        this.ofertaRealizada = EstadoOferta.EN_VENTA;
        this.pieza = pPieza;
    }


    //----------------------------------------------
    // METHODS
    //----------------------------------------------


    public void realizarOferta(Oferta pOferta){
        setOfertaRealizada(EstadoOferta.OFERTA_EN_VERIFICACION);
        this.oferta = pOferta;
    }

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

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public EstadoOferta getOfertaRealizada() {
        return ofertaRealizada;
    }

    public void setOfertaRealizada(EstadoOferta ofertaRealizada) {
        this.ofertaRealizada = ofertaRealizada;
    }

    public Pieza getPieza() {
        return pieza;
    }

    public void setPieza(Pieza pieza) {
        this.pieza = pieza;
    }
}
