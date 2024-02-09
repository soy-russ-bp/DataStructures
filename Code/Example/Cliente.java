package Example;

public class Cliente extends Persona {
    public Cliente(String nombre) {
        super(nombre);
    }

    @Override
    public String toString() {
        return "Cliente: " + getNombre();
    }
}