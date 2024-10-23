package joey.com.dataStructures.stack;

public interface Stack<T extends Comparable<T>> {

    // add um el na pilha (no topo)
    void push(T data);

    // remove um el na pilha (remove o topo)
    void pop();

    // acessa o el do topo
    T peek();

    // verifica se a pilah esta vazia
    Boolean isEmpty();

    // retorna o comprimento da pilha
    int getSize();
}
