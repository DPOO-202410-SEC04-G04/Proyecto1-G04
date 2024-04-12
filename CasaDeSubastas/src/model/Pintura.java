package model;

import java.sql.Date;
import java.util.ArrayList;

public class Pintura extends Pieza{
    //----------------------------------------------
    // CONSTANTS
    //----------------------------------------------
    public static final String TIPO = "Pintura";


    //----------------------------------------------
    // ATTRIBUTES
    //----------------------------------------------

    private String dimensiones;

    private float espacioDeMemoria;

    private String detallesAdicionales;

    //----------------------------------------------
    // CONSTRUCTOR
    //----------------------------------------------

    public Pintura (String pAutor, String pTitulo, String pAnio, String pLugarDeCreacion, String pEstado, float pPrecio, String pDispoinibilidad, String pTipoCompra, String tipoPieza, String dimensiones, String detallesAdicionales){
        
        super(pAutor,  pTitulo,  pAnio,  pLugarDeCreacion,  pEstado,  pPrecio,  pDispoinibilidad,  pTipoCompra, tipoPieza);
        this.dimensiones = dimensiones;
        this.detallesAdicionales = detallesAdicionales;
        //TODO: Consturctor model.Video
    }
    

    //----------------------------------------------
    // METHODS
    //----------------------------------------------
    public String getTipoPieza(){
        return TIPO;
    }

    public String editarObrasPintura(){
        String texto = "";
        texto+="\n"+id+";"+autor+";"+titulo+";"+anio+";"+lugarDeCreacion+";"+estado+";"+String.valueOf(precio)+";"+disponibilidad+";"+tipoCompra+";"+tipoPieza+";"+dimensiones+";"+detallesAdicionales;
        return texto;
    }
}




