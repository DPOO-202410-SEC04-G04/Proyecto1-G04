package model;

import java.sql.Date;

public class Video extends Pieza{
    //----------------------------------------------
    // CONSTANTS
    //----------------------------------------------
    public static final String TIPO = "Video";


    //----------------------------------------------
    // ATTRIBUTES
    //----------------------------------------------

    private float duracion;

    private float espacioDeMemoria;

    private String detallesAdicionales;

    //----------------------------------------------
    // CONSTRUCTOR
    //----------------------------------------------

    public Video (String pAutor, String pTitulo, String pAnio, String pLugarDeCreacion, String pEstado, float pPrecio, boolean pDispoinibilidad, String pTipoCompra, String tipoPieza, float duracion,
    float espacioDeMemoria, String detallesAdicionales){
        
        super(pAutor,  pTitulo,  pAnio,  pLugarDeCreacion,  pEstado,  pPrecio,  pDispoinibilidad,  pTipoCompra, tipoPieza);
        this.duracion = duracion;
        this.espacioDeMemoria = espacioDeMemoria;
        this.detallesAdicionales = detallesAdicionales;
        //TODO: Consturctor model.Video
    }
    

    //----------------------------------------------
    // METHODS
    //----------------------------------------------
    public String getTipoPieza(){
        return TIPO;
    }
}




