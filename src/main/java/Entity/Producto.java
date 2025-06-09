package Entity;

public class Producto {
    protected int id;
    protected String nombre;
    protected double precioUnitario;
    protected int cantidad;
    protected static int cont = 1;


    public Producto() {
        this.id =cont++;
    }

    public Producto(String nombre, double precioUnitario, int cantidad) {
        this.id = cont++;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public void setCantidad(int cantidad) {this.cantidad = cantidad; }

    public int getCantidad() {
        return cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
