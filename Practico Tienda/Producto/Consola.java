package Producto;

public class Consola extends Producto {
    private String fabricante;
    private String modelo;

    public Consola(String nombre, int precio, int stock, String fabricante, String modelo) {
        super(nombre, precio, stock);
        this.fabricante = fabricante;
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Nombre: " + getNombre() + ", Precio: " + getPrecio() + ", Stock: " + getStock() + ", Fabricante: " + getFabricante() + ", Modelo: " + getModelo()  );
    }
}
