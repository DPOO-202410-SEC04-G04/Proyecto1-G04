package model;

public class Usuario {
    //----------------------------------------------
    // CONSTANTS
    //----------------------------------------------


    //----------------------------------------------
    // ATTRIBUTES
    //----------------------------------------------

    private String nombre;

    private String tipoUsuario;

    private String id;

    //----------------------------------------------
    // CONSTRUCTOR
    //----------------------------------------------

    public Usuario(){
        //TODO: Constructor model.Usuario
    }

    //----------------------------------------------
    // METHODS
    //----------------------------------------------


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
