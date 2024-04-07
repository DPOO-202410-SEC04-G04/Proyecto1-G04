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

    private Date anio;

    private String lugarDeCreacion;

    private Estado estado;

    private float precio;

    private boolean disponibilidad;

    private TipoCompra tipoCompra;

    //----------------------------------------------
    // CONSTRUCTOR
    //----------------------------------------------

    public Pieza(String pAutor, String pTitulo, Date pAnio, String pLugarDeCreacion, Estado pEstado, float pPrecio, boolean pDispoinibilidad, TipoCompra pTipoCompra){
        this.id = UUID.randomUUID().toString();
        this.autor = pAutor;
        this.titulo = pTitulo;
        this.anio = pAnio;
        this.lugarDeCreacion = pLugarDeCreacion;
        this.estado = pEstado;
        this.precio = pPrecio;
        this.disponibilidad = pDispoinibilidad;
        this.tipoCompra = pTipoCompra;
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

    public Date getAnio() {
        return anio;
    }

    public void setAnio(Date anio) {
        this.anio = anio;
    }

    public String getLugarDeCreacion() {
        return lugarDeCreacion;
    }

    public void setLugarDeCreacion(String lugarDeCreacion) {
        this.lugarDeCreacion = lugarDeCreacion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
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

    public TipoCompra getTipoCompra() {
        return tipoCompra;
    }

    public void setTipoCompra(TipoCompra tipoCompra) {
        this.tipoCompra = tipoCompra;
    }
}
