package Model.entidades;

public class Medicamento {

    private String codigo;
    private String nombre;
    private String presentacion;
    private double precio;

    // Constructor completo
    public Medicamento(String codigo, String nombre, String presentacion, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.presentacion = presentacion;
        this.precio = precio;
    }

    // Getters y setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


}
