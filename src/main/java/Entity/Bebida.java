package Entity;

public class Bebida extends Producto {
    private String tipoBebida; //gaseosa , agua, vino ect
    private int militros;
    private String marca;

    public Bebida(String tipoBebida, int militros, String marca) {
        this.tipoBebida = tipoBebida;
        this.militros = militros;
        this.marca = marca;
    }

    public Bebida(String nombre, double precioUnitario, int cantidad, String tipoBebida, int militros, String marca) {
        super(nombre, precioUnitario, cantidad);
        this.tipoBebida = tipoBebida;
        this.militros = militros;
        this.marca = marca;
    }

    public Bebida(String nombre, double precioUnitario, int cantidad) {
        super(nombre, precioUnitario, cantidad);
    }
    public Bebida() {
        super();
    }

    public String getTipoBebida() {
        return this.tipoBebida;
    }

    public void setTipoBebida(String tipoBebida) {
        this.tipoBebida = tipoBebida;
    }

    public int getMilitros() {
        return militros;
    }

    public void setMilitros(int militros) {
        this.militros = militros;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Bebida{" +
                "tipoBebida='" + tipoBebida + '\'' +
                ", militros=" + militros +
                ", marca='" + marca + '\'' +
                ", id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precioUnitario=" + precioUnitario +
                ", cantidad=" + cantidad +
                '}';
    }
}
