package Persona;

public class Empleado extends Persona{
    private String puesto;

    public Empleado (String nombre, int id, String puesto){
        super(nombre,id);
        this.puesto= puesto;
    }

    public String getPuesto() {
        return puesto;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Id: " + getId());
        System.out.println("Puesto: " + getPuesto());
    }
}
