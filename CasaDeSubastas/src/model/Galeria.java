package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import model.Comprador;

public class Galeria {

    //----------------------------------------------
    // CONSTANTS
    //----------------------------------------------


    //----------------------------------------------
    // ATTRIBUTES
    //----------------------------------------------

    private String nombreGaleria;

    private ArrayList<Subasta> subastasActivas;

    private ArrayList<Pieza> inventario;

    private ArrayList<Usuario> usuarios;

    //----------------------------------------------
    // CONSTRUCTOR
    //----------------------------------------------

    public Galeria(String pNombreGaleria){
        this.nombreGaleria = pNombreGaleria;
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


     public static void agregarlinea(String ruta, String texto){
        try {
            FileWriter fileWriter = new FileWriter(ruta, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(texto);
            bufferedWriter.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
     }
     

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


   

    public void addPieza(String pAutor, String pTitulo, String pAnio, String pLugarDeCreacion, String pEstado, float pPrecio, String pDispoinibilidad, String pTipoCompra, String tipoPieza){
        Pieza pieza = new Pieza(pAutor,pTitulo,pAnio,pLugarDeCreacion,pEstado,pPrecio,pDispoinibilidad,pTipoCompra, tipoPieza);
        inventario.add(pieza);
        String linea = pieza.editarObras();

        agregarlinea("C:\\Users\\USUARIO\\git\\Proyecto1-G04\\CasaDeSubastas\\data\\ObrasdeArte.txt", linea);
    }


    public void addEscultura(String pAutor, String pTitulo, String pAnio, String pLugarDeCreacion, String pEstado, float pPrecio, String pDispoinibilidad, String pTipoCompra, String tipoPieza, String dimensiones,
    String materiales, String peso, boolean necesitaElectricidad, String tipoArte, String detallesAdicionales){
        Escultura pieza = new Escultura(pAutor,pTitulo,pAnio,pLugarDeCreacion,pEstado,pPrecio,pDispoinibilidad,pTipoCompra, tipoPieza, dimensiones, materiales, peso, necesitaElectricidad, tipoArte, detallesAdicionales);
        inventario.add(pieza);
        String linea = pieza.editarObrasEscultura();
        agregarlinea("C:\\Users\\USUARIO\\git\\Proyecto1-G04\\CasaDeSubastas\\data\\ObrasdeArte.txt", linea);
    }

    public void addPintura(String pAutor, String pTitulo, String pAnio, String pLugarDeCreacion, String pEstado, float pPrecio, String pDispoinibilidad, String pTipoCompra, String tipoPieza, String dimensiones, String detallesAdicionales){
        Pintura pieza = new Pintura(pAutor,pTitulo,pAnio,pLugarDeCreacion,pEstado,pPrecio,pDispoinibilidad,pTipoCompra, tipoPieza, dimensiones, detallesAdicionales);
        inventario.add(pieza);
        String linea = pieza.editarObrasPintura();
        agregarlinea("C:\\Users\\USUARIO\\git\\Proyecto1-G04\\CasaDeSubastas\\data\\ObrasdeArte.txt", linea);
        }

    public void addVideo(String pAutor, String pTitulo, String pAnio, String pLugarDeCreacion, String pEstado, float pPrecio, String pDispoinibilidad, String pTipoCompra, String tipoPieza, Float duracion, Float espacioDeMemoria, String detallesAdicionales){
        Video pieza = new Video(pAutor,pTitulo,pAnio,pLugarDeCreacion,pEstado,pPrecio,pDispoinibilidad,pTipoCompra, tipoPieza, duracion, espacioDeMemoria, detallesAdicionales);
        inventario.add(pieza);
        String linea = pieza.editarObrasVideo();
        agregarlinea("C:\\Users\\USUARIO\\git\\Proyecto1-G04\\CasaDeSubastas\\data\\ObrasdeArte.txt", linea);
    }
    
    public static void addPago(Pagos pago)
    {
    	String linea = pago.lineaPagos();
    	agregarlinea("C:\\Users\\USUARIO\\git\\Proyecto1-G04\\CasaDeSubastas\\data\\ListaPagos.txt", linea);
    }
    
    public static void addObraHistorial(Comprador comprador)
    {
    	String linea = comprador.lineaComprador(comprador);
    	agregarlinea("C:\\Users\\USUARIO\\git\\Proyecto1-G04\\CasaDeSubastas\\data\\HistorialComprador.txt", linea);
    }
    

    public void addUsuario(String nombre, String tipoUsuario, String id, String cel){
        Usuario usuarioNuevo = null;

        switch (tipoUsuario) {
            case "Operador":
                usuarioNuevo = new Operador(nombre, tipoUsuario, id, cel);
                break;
            case "Cajero":
                usuarioNuevo = new Cajero(nombre, tipoUsuario, id, cel);
                break;
            case "Empleado":
                usuarioNuevo = new Empleado(nombre, tipoUsuario, id, cel);
                break;
            case "Administrador":
                usuarioNuevo = new Administrador(nombre, tipoUsuario, id, cel);
                break;
            case "Propietario":
            	usuarioNuevo = new Propietario(nombre, tipoUsuario, id, cel);
            	break;
            default:
                throw new IllegalArgumentException("Unknown user type: " + usuarioNuevo);
        }

        if (usuarioNuevo != null) {
            usuarios.add(usuarioNuevo);
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
