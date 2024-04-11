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

    private String dimensiones;

    private String materiales;

    private String peso;

    private boolean necesitaElectricidad;

    private String detallesAdicionales;

    private String tipoArte;



    //----------------------------------------------
    // CONSTRUCTOR
    //----------------------------------------------

    public Escultura (String pAutor, String pTitulo, String pAnio, String pLugarDeCreacion, String pEstado, float pPrecio, boolean pDispoinibilidad, String pTipoCompra, String tipoPieza, String dimensiones,
    String materiales, String peso, boolean necesitaElectricidad, String tipoArte, String detallesAdicionales){
        
        super(pAutor,  pTitulo,  pAnio,  pLugarDeCreacion,  pEstado,  pPrecio,  pDispoinibilidad,  pTipoCompra, tipoPieza);
        this.dimensiones = dimensiones;
        
        this.materiales = materiales;
        this.peso = peso;
        this.necesitaElectricidad = necesitaElectricidad;
        this.tipoArte = tipoArte;
        this.detallesAdicionales = detallesAdicionales;

        //TODO: Constructor model.Escultura
    }

    //----------------------------------------------
    // METHODS
    //----------------------------------------------

    public String getTipoPieza(){
        return TIPO;
    }
    
    public String editarObrasEscultura(){
        String texto = "";
        texto+="\n"+id+";"+autor+";"+titulo+";"+anio+";"+lugarDeCreacion+";"+estado+";"+String.valueOf(precio)+";"+disponibilidad+";"+tipoCompra+";"+tipoPieza+";"+dimensiones+";"+materiales+";"+peso+";"+necesitaElectricidad+";"+tipoArte+";"+detallesAdicionales;
        return texto;
    }

}
