package joey.com.dataStructures.queue;

public interface Queue<T extends Comparable<T>> {

    // add um el ao final da fila
    void enqueue(T data);

    // remove o primeiro el da fila
    void dequeue();

    // acessa o priemiro el
    T peek();

    // retornar true se a fila esta vaiza
    boolean isEmpty();

    // retorna o comprimento da fila
    int getSize();
}
