package model;

import java.util.ArrayList;
import java.util.Date;

public class Galeria {

    //----------------------------------------------
    // CONSTANTS
    //----------------------------------------------


    //----------------------------------------------
    // ATTRIBUTES
    //----------------------------------------------

    private String nombreGaleria;

    private ArrayList<Subasta> subastasActivas;

    private ArrayList<CompraDirecta> comprasDirectas;

    private ArrayList<Pieza> inventario;

    private ArrayList<Usuario> usuarios;

    //----------------------------------------------
    // CONSTRUCTOR
    //----------------------------------------------

    public Galeria(String pNombreGaleria){
        this.nombreGaleria = pNombreGaleria;
        this.comprasDirectas = new ArrayList<>();
        this.subastasActivas = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.inventario = new ArrayList<>();
    }

    //----------------------------------------------
    // METHODS
    //----------------------------------------------

    /**
     *
     * @param idPieza
     * @param valorInicial
     * @param valorMinimo
     * @param user
     */
    public void crearSubasta(String idPieza, float valorInicial, float valorMinimo, Usuario user){
        if(user.getTipoUsuario().equals("Administrador")){
            for(Pieza pieza:inventario){
                if(pieza.getId().equals(idPieza)){
                    Subasta subasta = new Subasta(valorInicial,valorMinimo);
                    subastasActivas.add(subasta);
                    break;
                }
            }
        }

    }


    public void crearCompraDirecta(String idPieza, float valorObra, Usuario user){
        if(user.getTipoUsuario().equals("Administrador")){
            for(Pieza pieza:inventario){
                if(pieza.getId().equals(idPieza)){
                    CompraDirecta compraDirecta = new CompraDirecta(valorObra, pieza);
                    comprasDirectas.add(compraDirecta);
                    break;
                }
            }
        }

    }

    public void addPieza(String pAutor, String pTitulo, Date pAnio, String pLugarDeCreacion, Estado pEstado, float pPrecio, boolean pDispoinibilidad, TipoCompra pTipoCompra){
        Pieza pieza = new Pieza(pAutor,pTitulo,pAnio,pLugarDeCreacion,pEstado,pPrecio,pDispoinibilidad,pTipoCompra);
        inventario.add(pieza);
    }

    public void addUsuario(String tipoUsuario){
        Usuario usuarioNuevo = null;

        switch (tipoUsuario) {
            case "Operador":
                usuarioNuevo = new Operador();
                break;
            case "Cajero":
                usuarioNuevo = new Cajero();
                break;
            case "Empleado":
                usuarioNuevo = new Empleado();
                break;
            case "Administrador":
                usuarioNuevo = new Administrador();
                break;
            default:
                throw new IllegalArgumentException("Unknown user type: " + usuarioNuevo);
        }

        if (usuarioNuevo != null) {
            usuarios.add(usuarioNuevo);
        }
    }

    public void realizarOfertaCompraDirecta(String pIdComprasDirectas, Usuario pUsuario){

        for(CompraDirecta compraDirecta:comprasDirectas){
            if(compraDirecta.getId().equals(pIdComprasDirectas)){
                if(pUsuario.getTipoUsuario().equals("Comprador") && checkCompradorNotPropietario(compraDirecta.getPieza().getId(),pUsuario)){

                    Oferta oferta = new Oferta(compraDirecta.getValor());
                    compraDirecta.realizarOferta(oferta);


                }
            }
        }


    }

    private boolean checkCompradorNotPropietario(String idPieza, Usuario usuario){
        //TODO: Revisar que para la obra que corresponde con el ID dado el propietario no sea el usuario que la esta deseando comprar
        return true;
    }

    //----------------------------------------------
    // GETTER AND SETTERS
    //----------------------------------------------


    public String getNombreGaleria() {
        return nombreGaleria;
    }

    public void setNombreGaleria(String nombreGaleria) {
        this.nombreGaleria = nombreGaleria;
    }

    public ArrayList<Subasta> getSubastasActivas() {
        return subastasActivas;
    }

    public void setSubastasActivas(ArrayList<Subasta> subastasActivas) {
        this.subastasActivas = subastasActivas;
    }

    public ArrayList<CompraDirecta> getComprasDirectas() {
        return comprasDirectas;
    }

    public void setComprasDirectas(ArrayList<CompraDirecta> comprasDirectas) {
        this.comprasDirectas = comprasDirectas;
    }

    public ArrayList<Pieza> getInventario() {
        return inventario;
    }

    public void setInventario(ArrayList<Pieza> inventario) {
        this.inventario = inventario;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
