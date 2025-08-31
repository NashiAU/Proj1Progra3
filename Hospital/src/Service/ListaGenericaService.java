package Service;

import java.util.*;
import java.util.List;
import Model.entidades.Usuario;

public class ListaGenericaService<T extends Usuario> {
    private List<T> usuarios = new ArrayList<>();

    public T buscarPorId(String id) {
        for (T usuario : usuarios) {
            if (usuario.getId().equals(id)) {
                return usuario;
            }
        }
        return null;
    }

    public List<T> buscarPorNombre(String nombre) {
        List<T> resultados = new ArrayList<>();
        for (T usuario : usuarios) {
            if (usuario.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                resultados.add(usuario);
            }
        }
        return resultados;
    }

    // (clave inicial = id)
    public void incluir(T usuario) {
        usuario.setClave(usuario.getId());
        usuarios.add(usuario);
    }

    public List<T> listarTodos() {
        return new ArrayList<>(usuarios);
    }

    public boolean modificar(String id, T datosActualizados) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId().equals(id)) {
                usuarios.set(i, datosActualizados);
                return true;
            }
        }
        return false;
    }

    public boolean borrar(String id) {
        Iterator<T> it = usuarios.iterator();
        while (it.hasNext()) {
            T usuario = it.next();
            if (usuario.getId().equals(id)) {
                it.remove();
                return true;
            }
        }
        return false;
    }
}