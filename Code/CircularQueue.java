import java.util.ArrayList;
import java.util.NoSuchElementException;

public class CircularQueue<E> {
    private ArrayList<E> queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            this.queue.add(null); // Inicializar todos los elementos como nulos
        }
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int size() {
        return size;
    }

    public void enqueue(E item) {
        if (isFull()) {
            throw new IllegalStateException("La cola está llena");
        }
        rear = (rear + 1) % capacity;
        queue.set(rear, item);
        size++;
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("La cola está vacía");
        }
        E item = queue.get(front);
        queue.set(front, null);
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("La cola está vacía");
        }
        return queue.get(front);
    }

    public static void main(String[] args) {
        CircularQueue<Integer> queue = new CircularQueue<>(5);

        // Enqueue
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        // Intentar agregar más elementos para demostrar que la cola está llena
        try {
            queue.enqueue(6);
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Dequeue y peek
        System.out.println("Elemento eliminado: " + queue.dequeue());
        System.out.println("Elemento en la parte delantera: " + queue.peek());

        // Agregar un nuevo elemento después de dequeue
        queue.enqueue(6);

        // Vaciar la cola
        while (!queue.isEmpty()) {
            System.out.println("Elemento eliminado: " + queue.dequeue());
        }

        // Intentar eliminar de una cola vacía
        try {
            queue.dequeue();
        } catch (NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
