package model;

import java.util.Date;
import java.util.UUID;

public class Pieza {
    //----------------------------------------------
    // CONSTANTS
    //----------------------------------------------


    //----------------------------------------------
    // ATRIBUTES
    //----------------------------------------------

    private String id;

    private String autor;

    private String titulo;

    private String anio;

    private String lugarDeCreacion;

    private String estado;

    private float precio;

    private boolean disponibilidad;

    private String tipoCompra;

    private String tipoPieza;

    //----------------------------------------------
    // CONSTRUCTOR
    //----------------------------------------------

    public Pieza(String pAutor, String pTitulo, String pAnio, String pLugarDeCreacion, String pEstado, float pPrecio, boolean pDispoinibilidad, String pTipoCompra, String tipoPieza){
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

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getTipoCompra() {
        return tipoCompra;
    }

    public void setTipoCompra(String tipoCompra) {
        this.tipoCompra = tipoCompra;
    }

    public String editarObras(){
        String texto = "";
        texto+="\n"+id+";"+autor+";"+titulo+";"+anio+";"+lugarDeCreacion+";"+estado+";"+String.valueOf(precio)+";"+disponibilidad+";"+tipoCompra+";"+tipoPieza;
        return texto;
    }
}