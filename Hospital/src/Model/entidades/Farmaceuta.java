package Model.entidades;

import Model.enums.TipoUsuario;

public class Farmaceuta extends Usuario {
    public Farmaceuta(String id, String clave, String nombre) {
        super(id, clave, nombre);
    }

    @Override
    public TipoUsuario getTipo() {
        return TipoUsuario.FARMACEUTA;
    }

}
