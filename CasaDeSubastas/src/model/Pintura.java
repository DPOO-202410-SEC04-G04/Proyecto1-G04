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

    private ArrayList<Float> dimensiones;

    private float espacioDeMemoria;

    private String detallesAdicionales;

    //----------------------------------------------
    // CONSTRUCTOR
    //----------------------------------------------

    public Pintura (String pAutor, String pTitulo, Date pAnio, String pLugarDeCreacion, Estado pEstado, float pPrecio, boolean pDispoinibilidad, TipoCompra pTipoCompra, ArrayList<Float> dimensiones,
    float espacioDeMemoria, String detallesAdicionales){
        
        super(pAutor,  pTitulo,  pAnio,  pLugarDeCreacion,  pEstado,  pPrecio,  pDispoinibilidad,  pTipoCompra);
        this.dimensiones = dimensiones;
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




