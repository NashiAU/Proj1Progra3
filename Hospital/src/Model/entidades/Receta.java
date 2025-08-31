package Model.entidades;

import Model.enums.EstadoReceta;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Receta {

    private String id;
    private Medico medico;
    private Paciente paciente;
    private LocalDate fechaConfeccion;
    private LocalDate fechaRetiro;
    private List<LineaReceta> lineas;
    private EstadoReceta estado;

    public Receta() {
        this.lineas = new ArrayList<>();
        this.estado = EstadoReceta.CONFECCIONADA;
        this.fechaConfeccion = LocalDate.now();
    }

    public Receta(String id, Medico medico, Paciente paciente, LocalDate fechaRetiro) {
        this();
        this.id = Objects.requireNonNull(id, "El ID no puede ser nulo");
        this.medico = Objects.requireNonNull(medico, "El médico no puede ser nulo");
        this.paciente = Objects.requireNonNull(paciente, "El paciente no puede ser nulo");
        if (fechaRetiro != null && fechaRetiro.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de retiro no puede ser anterior a hoy");
        }
        this.fechaRetiro = fechaRetiro;
    }



    public void agregarLinea(LineaReceta linea) {
        if (linea == null) throw new IllegalArgumentException("La línea no puede ser nula");

        // Evitar medicamentos duplicados
        boolean existe = lineas.stream()
                .anyMatch(l -> l.getMedicamento().equals(linea.getMedicamento()));

        if (existe) {
            throw new IllegalArgumentException("El medicamento ya está en la receta");
        }

        lineas.add(linea);
    }

    public void eliminarLinea(int index) {
        if (index < 0 || index >= lineas.size()) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }
        lineas.remove(index);
    }

    public void modificarLinea(int index, LineaReceta nuevaLinea) {
        if (nuevaLinea == null) throw new IllegalArgumentException("La línea no puede ser nula");
        if (index < 0 || index >= lineas.size()) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }
        lineas.set(index, nuevaLinea);
    }

    public boolean estaVacia() {
        return lineas.isEmpty();
    }

    public int cantidadTotalMedicamentos() {
        return lineas.size();
    }

    public void marcarComoRetirada() {
        this.estado = EstadoReceta.ENTREGADA;
        this.fechaRetiro = LocalDate.now();
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Medico getMedico() { return medico; }
    public void setMedico(Medico medico) { this.medico = medico; }

    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }

    public LocalDate getFechaConfeccion() { return fechaConfeccion; }

    public LocalDate getFechaRetiro() { return fechaRetiro; }
    public void setFechaRetiro(LocalDate fechaRetiro) { this.fechaRetiro = fechaRetiro; }

    public List<LineaReceta> getLineas() { return new ArrayList<>(lineas); }

    public EstadoReceta getEstado() { return estado; }
    public void setEstado(EstadoReceta estado) { this.estado = estado; }

}
