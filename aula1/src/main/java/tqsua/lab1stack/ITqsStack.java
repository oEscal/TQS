package tqsua.lab1stack;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ITqsStack<E> {

    private List<E> stack;
    private int max_size;

    public ITqsStack() {
        this.stack = new ArrayList<E>();
        this.max_size = -1;
    }

    public ITqsStack(int max_size) {
        this.stack = new ArrayList<E>();
        this.max_size = max_size;
    }

    public int size() {
        return this.stack.size();
    }

    public void push(E x) {
        if (this.max_size >= 0 && this.size() >= this.max_size)
            throw new IllegalStateException();
        this.stack.add(x);
    }

    public E pop() {
        try {
            return this.stack.remove(this.size() - 1);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new NoSuchElementException();
        }

    }

    public E peek() {
        if (this.size() == 0)
            throw new NoSuchElementException();
        return this.stack.get(this.size() - 1);
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public void clear() {
        this.stack.clear();
    }

    public void defineMaxSize(int max_size) {
        this.max_size = max_size;
    }
}
