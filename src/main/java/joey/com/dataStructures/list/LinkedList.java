package joey.com.dataStructures.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T> {

    private Node<T> front;
    private Node<T> rear;
    private Integer size;

    public LinkedList() {
        this.size = 0;
    }

    public Node<T> getFront() {
        return front;
    }

    public void setFront(Node<T> front) {
        this.front = front;
    }

    public Node<T> getRear() {
        return rear;
    }

    public void setRear(Node<T> rear) {
        this.rear = rear;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public void addNoInicio(T valor) {
        Node<T> newNode = new Node<>(valor);
        if (this.front == null && this.rear == null) {
            this.front = newNode;
            this.rear = newNode;
        } else {
            newNode.setNextNode(this.front);
            this.front = newNode;
        }
        this.size++;
    }

    public void addNoFinal(T valor) {
        Node<T> newNode = new Node<>(valor);
        if (this.front == null && this.rear == null) {
            this.front = newNode;
            this.rear = newNode;
        } else {
            this.rear.setNextNode(newNode);
            this.rear = newNode;
        }
        this.size++;
    }

    public void removerByValue(T value) {
        Node<T> before = null;
        Node<T> current = this.front;
        for (int i = 0; i < this.size; i++) {
            if(current.getValue().equals(value)) {
                if (current == this.front && current == this.rear) {
                    this.front = null;
                    this.rear = null;
                } else if (current == this.front) {
                    this.front = current.getNextNode();
                    current.setNextNode(null);
                    current = null;
                } else if (current == this.rear) {
                    this.rear = before;
                    before.setNextNode(null);
                } else {
                    before.setNextNode(current.getNextNode());
                    current = null;
                }
                this.size--;
                break;
            }
            before = current;
            current = current.getNextNode();
        }
    }

    public void removePrimeiro() {
        if (this.front == null) {
            throw new NoSuchElementException("A lista está vazia.");
        }

        if (this.front == this.rear) {
            this.front = null;
            this.rear = null;
        } else {
            Node<T> temp = this.front;
            this.front = this.front.getNextNode();
            temp.setNextNode(null);
        }
        this.size--;
    }

    public Node<T> getNode(int position) {
        Node<T> current = this.front;
        for (int i = 0; i < position; i++) {
            if (current.getNextNode() != null) {
                current = current.getNextNode();
            }
        }
        return current;
    }

    public Node<T> getNodeByValue(T valor) {
        Node<T> current = this.front;
        for (int i = 0; i < this.size; i++) {
            if (current.getValue().equals(valor)) {
                return current;
            }
            current = current.getNextNode();
        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = front;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = current.getValue();
                current = current.getNextNode();
                return value;
            }
        };
    }
}
