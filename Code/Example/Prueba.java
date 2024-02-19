package Example;
import java.util.ArrayList;

public class Prueba<T> { 
    private ArrayList<T> lista = new ArrayList<>();

    // Método para agregar un elemento a la lista
    public void agregarElemento(T elemento) {
        lista.add(elemento);
    }

    // Método para procesar elementos en la lista
    public void procesarElementos() {
        // Procesamiento de elementos en la cola
        while (!lista.isEmpty()) {
            T elemento = lista.remove(0);
            System.out.println("Procesando " + elemento);
            // Lógica de procesamiento de elemento...
        }
    }

    public static void main(String[] args) {
        // Crear una instancia de Prueba con tipo Persona
        Prueba<Persona> prueba = new Prueba<>();

        // Simulación de llegada de personas a la cola
        prueba.agregarElemento((Persona)new Cliente("Juan"));
        prueba.agregarElemento((Persona)new ClienteDeBaja("María"));
        prueba.agregarElemento((Persona)new Cliente("Pedro"));
        prueba.agregarElemento((Persona)new ClienteDeBaja("Ana"));

        // Procesamiento de personas en la cola
        prueba.procesarElementos();
    }
}
