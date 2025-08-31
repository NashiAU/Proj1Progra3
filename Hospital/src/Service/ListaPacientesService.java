package Service;

import Model.entidades.Paciente;

import java.util.List;
import java.util.stream.Collectors;

public class ListaPacientesService extends ListaGenericaService<Paciente> {

    public Paciente buscarPorIdExacto(String id) {
        return listarTodos().stream()
                .filter(p -> p.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
    }

    public List<Paciente> buscarPorNombreParcial(String nombre) {
        String texto = nombre.toLowerCase();
        return listarTodos().stream()
                .filter(p -> p.getNombre().toLowerCase().contains(texto))
                .collect(Collectors.toList());
    }

}
