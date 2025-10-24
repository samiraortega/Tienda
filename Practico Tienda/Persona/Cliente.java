package Persona;

public class Cliente extends Persona {
    private String correo;

    public Cliente(String nombre, int id, String correo) {
        super(nombre, id);
        this.correo = correo;
    }

    public String getCorreo() {
        return correo;
    }

    @Override
    public String mostrarInfo() {
        return "- Nombre: " + getNombre() + "- Id: " + getId() + "- Correo: " + getCorreo();

    }
}
