package Entity;

public class Pedido
{
    private int nropedido;
    private Producto producto;
    private int cantidad;

    public Pedido() {
    }

    public Pedido(int nropedido, Producto producto, int cantidad) {
        this.nropedido = nropedido;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getNropedido() {
        return nropedido;
    }

    public void setNropedido(int nropedido) {
        this.nropedido = nropedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "nropedido=" + nropedido +
                ", producto=" + producto +
                ", cantidad=" + cantidad +
                '}';
    }
}
