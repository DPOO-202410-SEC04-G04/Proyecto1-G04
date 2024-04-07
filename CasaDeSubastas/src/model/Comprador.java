package model;

import java.util.ArrayList;

public class Comprador extends Usuario{

    //----------------------------------------------
    // CONSTANTS
    //----------------------------------------------


    //----------------------------------------------
    // ATTRIBUTES
    //----------------------------------------------

    private float valorMaxCompra;

    private ArrayList<Pieza> historialPiezas;

    //----------------------------------------------
    // CONSTRUCTOR
    //----------------------------------------------

    public Comprador(float pValorMaxCompra, ArrayList<Pieza> pHistorialPiezas){
        super();
        this.valorMaxCompra = pValorMaxCompra;
        this.historialPiezas = pHistorialPiezas;
    }

    public Comprador(){
        super();
        this.valorMaxCompra = 0;
        this.historialPiezas = new ArrayList<Pieza>();
    }

    //----------------------------------------------
    // METHODS
    //----------------------------------------------

    public void realizarCompraPrecioFijo(String idCompraDirecta, float valorOfertado){
        /*
        un usuario registrado como comprador en la plataforma podrá
        ofrecerse a realizar la compra.
        En ese momento la pieza quedará bloqueada
        (nadie más podrá comprarla) hasta que el
        administrador del sistema verifique que el usuario sea real
        y la seriedad de la oferta.
        En caso positivo, la pieza quedará vendida. En caso negativo, volverá a su estado anterior. Las piezas que estén en la bodega de la galería también pueden ser vendidas – no sólo las que estén exhibidas.
         */



        //Crear oferta
        Oferta ofertaCompraPrecioFijo = new Oferta(valorOfertado);

        //Asignar oferta a compra directa





    }

    public void realizarOfertaSubasta(){

    }
}
