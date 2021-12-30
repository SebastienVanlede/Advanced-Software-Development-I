package domein;

import java.io.Serializable;

public class MyStack <E extends Serializable>{

    private MyListIterable<E> list;

    public MyStack() {
        this("Stack");
    }

    public MyStack(String name) {
        list = new MyListIterable(name);
    }

    public void push(E data) {
        list.insertAtFront(data);
    }

    public E pop() {
        return list.removeFromFront();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return list.toString();
    }

}
