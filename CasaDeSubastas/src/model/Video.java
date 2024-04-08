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

    public Video (String pAutor, String pTitulo, Date pAnio, String pLugarDeCreacion, Estado pEstado, float pPrecio, boolean pDispoinibilidad, TipoCompra pTipoCompra, float duracion,
    float espacioDeMemoria, String detallesAdicionales){
        
        super(pAutor,  pTitulo,  pAnio,  pLugarDeCreacion,  pEstado,  pPrecio,  pDispoinibilidad,  pTipoCompra);
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




