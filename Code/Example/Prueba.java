package Example;
import Solution.CircularQueue; 

    public class Prueba {
        public static void main(String[] args) {
            CircularQueue<Persona> colaPersonas = new CircularQueue<>(5);

            // Simulación de llegada de clientes y clientes de baja
            colaPersonas.enqueue(new Cliente("Juan"));
            colaPersonas.enqueue(new ClienteDeBaja("María"));
            colaPersonas.enqueue(new Cliente("Pedro"));
            colaPersonas.enqueue(new ClienteDeBaja("Ana"));

            // Procesamiento de personas en la cola
            while (!colaPersonas.isEmpty()) {
                Persona persona = colaPersonas.dequeue();
                System.out.println("Procesando " + persona);
                // Lógica de procesamiento de persona...
            }
        }
    }
