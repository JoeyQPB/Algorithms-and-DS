package joey.com.dataStructures.stack.impl;

import joey.com.dataStructures.list.LinkedList;
import joey.com.dataStructures.stack.Stack;

// LIFO
public class StackImpl<T extends Comparable<T>> implements Stack<T> {

    LinkedList<T> linkedList = new LinkedList<>();

    @Override
    public void push(T data) {
        this.linkedList.addNoInicio(data);
    }

    @Override
    public void pop() {
        this.linkedList.removerByValue(this.peek());
    }

    @Override
    public T peek() {
        return this.linkedList.getFront().getValue();
    }

    @Override
    public Boolean isEmpty() {
        return this.linkedList.getSize() == 0;
    }

    @Override
    public int getSize() {
        return this.linkedList.getSize();
    }
}
