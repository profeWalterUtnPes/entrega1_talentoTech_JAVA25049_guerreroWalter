package Entity;

public class Comida extends  Producto {
    private String tipoComida; // Ej: "Plato Principal", "Postre", "Snack"
    private double peso;
    private String marca;

    public Comida(String nombre, double precioUnitario,int  cantidad , String tipoComida, double peso, String marca) {
        super(nombre, precioUnitario, cantidad);
        this.tipoComida = tipoComida;
        this.peso = peso;
        this.marca = marca;
    }

    public Comida() {
        super();
    }

    public String getTipoComida() {
        return tipoComida;
    }

    public void setTipoComida(String tipoComida) {
        this.tipoComida = tipoComida;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Comida{" +
                "tipoComida='" + tipoComida + '\'' +
                ", peso=" + peso +
                ", marca='" + marca + '\'' +
                ", id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precioUnitario=" + precioUnitario +
                ", cantidad=" + cantidad +
                '}';
    }
}
