import java.util.ArrayList;
import java.util.List;

// Interfaz para la cola circular
interface CircularQueue<E> {
    boolean enqueue(E element);  
    E dequeue();                 
    boolean isEmpty();           
    int size();                  
}

// Implementación de la cola circular utilizando ArrayList
class ArrayListCircularQueue<E> implements CircularQueue<E> {
    private List<E> queue;       
    private int front;           
    private int rear;            
    private int maxSize;         

    
    public ArrayListCircularQueue(int maxSize) {
        this.maxSize = maxSize;
        queue = new ArrayList<>(maxSize);
        front = 0;
        rear = -1;
    }

   
    @Override
    public boolean enqueue(E element) {
        if (size() == maxSize) {
            return false;  // La cola está llena
        }
        rear = (rear + 1) % maxSize;
        queue.add(rear, element);
        return true;
    }

    
    @Override
    public E dequeue() {
        if (isEmpty()) {
            return null;  
        }
        E removedElement = queue.remove(front);
        rear = (rear - 1 + maxSize) % maxSize;
        return removedElement;
    }


    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    
    @Override
    public int size() {
        return (rear - front + maxSize) % maxSize + 1;
    }

    public static void main(String[] args) {
        CircularQueue<Integer> queue = new ArrayListCircularQueue<>(5);

        
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        
        System.out.println("La cola está llena: " + queue.enqueue(6));

        
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
        
        System.out.println("La cola está vacía: " + queue.isEmpty());
    }
}
