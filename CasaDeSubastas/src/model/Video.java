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

    public Video (String pAutor, String pTitulo, String pAnio, String pLugarDeCreacion, String pEstado, float pPrecio, String pDispoinibilidad, String pTipoCompra, String tipoPieza, Float duracion,
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

    public String editarObrasVideo(){
        String texto = "";
        texto+="\n"+id+";"+autor+";"+titulo+";"+anio+";"+lugarDeCreacion+";"+estado+";"+String.valueOf(precio)+";"+disponibilidad+";"+tipoCompra+";"+tipoPieza+";"+duracion+";"+espacioDeMemoria+";"+detallesAdicionales;
        return texto;
    }
}




