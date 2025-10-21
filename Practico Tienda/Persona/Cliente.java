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
    public void mostrarInfo() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Id: " + getId());
        System.out.println("Correo: " + getCorreo());
    }
}
