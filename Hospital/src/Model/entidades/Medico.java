package Model.entidades;

import Model.enums.TipoUsuario;

public class Medico extends Usuario {

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    private String especialidad;

    public Medico(String id, String clave, String nombre, String especialidad) {
        super(id, clave, nombre);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    @Override
    public TipoUsuario getTipo() {
        return TipoUsuario.MEDICO;
    }



}
