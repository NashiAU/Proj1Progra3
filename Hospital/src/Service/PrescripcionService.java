package Service;

import Model.entidades.LineaReceta;
import Model.entidades.Medico;
import Model.entidades.Paciente;
import Model.entidades.Receta;
import Model.enums.EstadoReceta;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PrescripcionService {


    private final List<Receta> recetas = new ArrayList<>();

    public Receta crearReceta(String id, Medico medico, Paciente paciente, LocalDate fechaRetiro) {
        validarFechas(fechaRetiro);

        Receta receta = new Receta(id, medico, paciente, fechaRetiro);
        recetas.add(receta);
        return receta;
    }


    public void agregarMedicamento(String recetaId, LineaReceta linea) {
        Receta receta = obtenerRecetaPorId(recetaId);
        validarEstadoEditable(receta);
        receta.agregarLinea(linea);
    }

    public void modificarLinea(String recetaId, int index, LineaReceta nuevaLinea) {
        Receta receta = obtenerRecetaPorId(recetaId);
        validarEstadoEditable(receta);
        receta.modificarLinea(index, nuevaLinea);
    }

    public void eliminarLinea(String recetaId, int index) {
        Receta receta = obtenerRecetaPorId(recetaId);
        validarEstadoEditable(receta);
        receta.eliminarLinea(index);
    }

    public void retirarReceta(String recetaId) {
        Receta receta = obtenerRecetaPorId(recetaId);
        receta.marcarComoRetirada();
    }

    public List<Receta> listarRecetas() {
        return new ArrayList<>(recetas); // copia defensiva
    }

    public Receta obtenerRecetaPorId(String id) {
        return recetas.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Receta no encontrada"));
    }

    private void validarFechas(LocalDate fechaRetiro) {
        if (fechaRetiro != null && fechaRetiro.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de retiro no puede ser anterior a hoy");
        }
    }

    private void validarEstadoEditable(Receta receta) {
        if (receta.getEstado() != EstadoReceta.CONFECCIONADA) {
            throw new IllegalStateException("No se puede modificar una receta que no está en estado CONFECCIONADA");
        }
    }

}