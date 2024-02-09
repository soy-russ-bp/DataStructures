package Example;

public class ClienteDeBaja extends Persona {
    public ClienteDeBaja(String nombre) {
        super(nombre);
    }

    @Override
    public String toString() {
        return "Cliente de baja: " + getNombre();
    }
}