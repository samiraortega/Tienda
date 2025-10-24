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
    public String mostrarInfo() {
        return "- Nombre: " + getNombre() + "- Id: " + getId() + "- Puesto: " + getPuesto();
    }
}
