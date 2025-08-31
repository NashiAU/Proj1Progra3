package Model.entidades;

import Model.enums.TipoUsuario;

import java.time.LocalDate;

public class Paciente extends Usuario{
    private String id;
    private String nombre;
    private LocalDate fechaNacimiento;
    private String telefono;

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Paciente(String id, String clave, String nombre, LocalDate fechaNacimiento, String telefono) {
        super(id, clave, nombre);
        this.id = id;
        this.clave = clave;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public TipoUsuario getTipo() {
        return null;
    }
}
