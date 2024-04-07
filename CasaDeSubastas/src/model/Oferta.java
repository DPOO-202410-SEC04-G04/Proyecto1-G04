package model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;


public class Oferta {
    //----------------------------------------------
    // CONSTANTS
    //----------------------------------------------


    //----------------------------------------------
    // ATTRIBUTES
    //----------------------------------------------

    private String id;

    private float valorOfertado;

    private Date fecha;

    //----------------------------------------------
    // CONSTRUCTOR
    //----------------------------------------------

    public Oferta(float pValorOfertado){
        this.id = (UUID.randomUUID()).toString();
        this.fecha = new Date();
        this.valorOfertado = pValorOfertado;
    }

    //----------------------------------------------
    // METHODS
    //----------------------------------------------
}
