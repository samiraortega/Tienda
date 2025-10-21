package Producto;

public abstract class Producto {
    private String nombre;
    private int precio;
    private int stock;

    public Producto(String nombre, int precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


    public abstract void mostrarInfo();

    public void reducirStock(int cantidad) {
        if (cantidad <= getStock()){
            setStock(- cantidad);
        }
        else
            System.out.println("No hay Stock suficiente");

    }
}
//mostrar detalle factura no abstract