package Model.entidades;

import Model.enums.TipoUsuario;

public abstract class Usuario {
    protected String id;
    protected String clave;
    protected String nombre;

    public Usuario(String id, String clave, String nombre) {
        this.id = id;
        this.clave = clave;
        this.nombre = nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getClave() {
        return clave;
    }

    public abstract TipoUsuario getTipo();

}
