package model;

import java.sql.Date;
import java.util.ArrayList;

public class Escultura extends Pieza {
    //----------------------------------------------
    // CONSTANTS
    //----------------------------------------------
    public static final String TIPO = "Escultura";

    //----------------------------------------------
    // ATTRIBUTES
    //----------------------------------------------

    private ArrayList<Float> dimensiones;

    private String tipoArte;


    //----------------------------------------------
    // CONSTRUCTOR
    //----------------------------------------------

    public Escultura (String pAutor, String pTitulo, Date pAnio, String pLugarDeCreacion, Estado pEstado, float pPrecio, boolean pDispoinibilidad, TipoCompra pTipoCompra, ArrayList<Float> dimensiones,
    String tipoArte){
        
        super(pAutor,  pTitulo,  pAnio,  pLugarDeCreacion,  pEstado,  pPrecio,  pDispoinibilidad,  pTipoCompra);
        this.dimensiones = dimensiones;
        this.tipoArte = tipoArte;

        //TODO: Constructor model.Escultura
    }

    //----------------------------------------------
    // METHODS
    //----------------------------------------------

    public String getTipoPieza(){
        return TIPO;
    }
}
