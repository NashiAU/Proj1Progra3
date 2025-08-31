package Controller;

import Model.entidades.*;
import Service.PrescripcionService;

import java.time.LocalDate;
import java.util.List;


public class PrescripcionController {

    private final PrescripcionService service;

    public PrescripcionController(PrescripcionService service) {
        this.service = service;
    }

    // Crear receta
    public Receta iniciarReceta(String id, Medico medico, Paciente paciente, LocalDate fechaRetiro) {
        return service.crearReceta(id, medico, paciente, fechaRetiro);
    }

    // Agregar medicamento
    public void agregarMedicamento(String recetaId, Medicamento medicamento, int cantidad, String indicaciones, int duracionDias) {
        LineaReceta linea = new LineaReceta(medicamento, cantidad, indicaciones, duracionDias);
        service.agregarMedicamento(recetaId, linea);
    }

    // Modificar medicamento
    public void modificarMedicamento(String recetaId, int index, Medicamento medicamento, int cantidad, String indicaciones, int duracionDias) {
        LineaReceta nuevaLinea = new LineaReceta(medicamento, cantidad, indicaciones, duracionDias);
        service.modificarLinea(recetaId, index, nuevaLinea);
    }

    // Eliminar medicamento
    public void eliminarMedicamento(String recetaId, int index) {
        service.eliminarLinea(recetaId, index);
    }

    // Finalizar receta
    public void retirarReceta(String recetaId) {
        service.retirarReceta(recetaId);
    }

    // Obtener receta
    public Receta obtenerReceta(String recetaId) {
        return service.obtenerRecetaPorId(recetaId);
    }

    // Listar todas
    public List<Receta> listarRecetas() {
        return service.listarRecetas();
    }
}

