package domein;

import java.io.Serializable;

public class Node<E extends Serializable> implements Serializable {

    private final E data;
    private Node<E> next;

    public Node(E data) {
        this.data = data;
    }

    public E getData() {
        return data;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getNext() {
        return next;
    }
}
