package model;

import java.util.Date;
import java.util.UUID;

public class Pieza{
    //----------------------------------------------
    // CONSTANTS
    //----------------------------------------------


    //----------------------------------------------
    // ATRIBUTES
    //----------------------------------------------

    protected String id;

    protected String autor;

    protected String titulo;

    protected String anio;

    protected String lugarDeCreacion;

    protected String estado;

    protected float precio;

    protected String disponibilidad;

    protected String tipoCompra;

    protected String tipoPieza;

    //----------------------------------------------
    // CONSTRUCTOR
    //----------------------------------------------

    public Pieza(String pAutor, String pTitulo, String pAnio, String pLugarDeCreacion, String pEstado, float pPrecio, String pDispoinibilidad, String pTipoCompra, String tipoPieza){
        this.id = UUID.randomUUID().toString();
        this.autor = pAutor;
        this.titulo = pTitulo;
        this.anio = pAnio;
        this.lugarDeCreacion = pLugarDeCreacion;
        this.estado = pEstado;
        this.precio = pPrecio;
        this.disponibilidad = pDispoinibilidad;
        this.tipoCompra = pTipoCompra;
        this.tipoPieza = tipoPieza;
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getLugarDeCreacion() {
        return lugarDeCreacion;
    }

    public void setLugarDeCreacion(String lugarDeCreacion) {
        this.lugarDeCreacion = lugarDeCreacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String isDisponibilidad() {
        return this.disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getTipoCompra() {
        return tipoCompra;
    }

    public void setTipoCompra(String tipoCompra) {
        this.tipoCompra = tipoCompra;
    }
    
    public String getTipoPieza() 
    {
    	return this.tipoPieza;
    }
    
    public void setTipoPieza(String tipoPieza)
    {
    	this.tipoPieza = tipoPieza;
    }

    public String editarObras(){
        String texto = "";
        texto+="\n"+id+";"+autor+";"+titulo+";"+anio+";"+lugarDeCreacion+";"+estado+";"+String.valueOf(precio)+";"+disponibilidad+";"+tipoCompra+";"+tipoPieza;
        return texto;
    }


}
