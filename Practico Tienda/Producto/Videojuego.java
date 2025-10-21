package Producto;

public class Videojuego extends Producto {
    private String genero;
    private String plataforma;

    public Videojuego(String nombre, int precio, int stock, String genero, String plataforma) {
        super(nombre, precio, stock);
        this.genero = genero;
        this.plataforma = plataforma;
    }

    public String getGenero() {
        return genero;
    }

    public String getPlataforma() {
        return plataforma;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Nombre: " + getNombre() + ", Precio: " + getPrecio() + ", Stock: " + getStock() + ", Genero: " + getGenero() + ", Plataforma: " + getPlataforma()  );
    }
}
