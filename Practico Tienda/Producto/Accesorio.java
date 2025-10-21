package Producto;

public class Accesorio extends Producto{
    private  String tipo;

    public Accesorio (String nombre, int precio, int stock, String tipo){
        super(nombre, precio, stock);
        this.tipo=tipo;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Nombre: " + getNombre() + ", Precio: " + getPrecio() + ", Stock: " + getStock() + ", Stock: " + getStock() + ", Tipo: " + getTipo()  );
    }
}
