package tqsua.lab1stack;

import java.util.ArrayList;
import java.util.List;

public class ITqsStack<E> {

    private List<E> stack;


    public ITqsStack() {
        this.stack = new ArrayList<E>();
    }

    public int size() {
        return this.stack.size();
    }

    public void push(E x) {
        this.stack.add(x);
    }

    public E pop() {
        return this.stack.remove(this.size() - 1);
    }

    public E peek(E x) {
        return this.stack.get(this.size() - 1);
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }
}
