import Persona.Cliente;
import Persona.Empleado;
import Producto.Producto;
import Tienda.Tienda;
import Tienda.Venta;
import Producto.Videojuego;
import Producto.Consola;


public class Main {
    public static void main(String[] args) {

        Tienda tienda = new Tienda("Tienda gogogo");
        Producto pou = new Videojuego("Pou",1000,5,"drama","aa");
        Producto xbox = new Consola("Xbox",2000,10,"nose","nuevo");
        Producto minecraft = new Videojuego("Minecraft",200,100,"Explorar","no me acuerdo");
        Producto roblox = new Videojuego("Roblox premium",500,2,"cine","Steam");


        Cliente c1 = tienda.crearCliente("Juan",2345,"juan@gmail.com");
        Empleado e1 = tienda.crearEmpleado("Pepe",1234,"Empleado");


        tienda.mostrarEmpleados();
        tienda.mostrarClientes();

        Venta v = new Venta(e1,c1);
        v.agregarProducto(pou);
        v.agregarProducto(xbox);
        v.agregarProducto(minecraft);
        v.agregarProducto(roblox);
        v.mostrarDetalle();
    }
}

// ventana pricipal, botones todx lo de tienda va en interfaz grafica, en crear cliente se pide datos pero se puege hacer un panel generico, que sea pedir datos, y luego llamar a ese panel
// un solo panel