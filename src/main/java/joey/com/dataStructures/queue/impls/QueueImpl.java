package joey.com.dataStructures.queue.impls;

import joey.com.dataStructures.list.LinkedList;
import joey.com.dataStructures.queue.Queue;

// FIFO
public class QueueImpl<T extends Comparable<T>> implements Queue<T> {

    LinkedList<T> linkedList = new LinkedList<>();

    @Override
    public void enqueue(T data) {
        this.linkedList.addNoFinal(data);
    }

    @Override
    public void dequeue() {
        this.linkedList.removerByValue(this.peek());
    }

    @Override
    public T peek() {
        return this.linkedList.getFront().getValue();
    }

    @Override
    public boolean isEmpty() {
        return this.getSize() == 0;
    }

    @Override
    public int getSize() {
        return this.linkedList.getSize();
    }
}
