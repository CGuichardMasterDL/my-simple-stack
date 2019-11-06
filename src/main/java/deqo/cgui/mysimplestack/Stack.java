package deqo.cgui.mysimplestack;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class Stack implements SimpleStack {
    private ArrayList<Item<Integer>> items;
    private int limit;

    public Stack() {
        this.items = new ArrayList<Item<Integer>>();
        this.limit = -1;
    }
    public Stack(int limit) {
        this.items = new ArrayList<Item<Integer>>();
        this.limit = limit;
    }

    @Override
    public boolean isEmpty() {
        return this.items.isEmpty();
    }

    @Override
    public int getSize() {
        return this.items.size();
    }

    @Override
    public int getLimit() {
        return this.limit;
    }

    @Override
    public void push(Item<Integer> item) throws StackOverflowError {
        if (this.limit == -1 || this.getSize() < this.limit )
            this.items.add(item);
        else
            throw new StackOverflowError("Stack is at maximum capacity.");
    }

    @Override
    public Item<Integer> peek() throws EmptyStackException {
        if (this.isEmpty())
            throw new EmptyStackException();
        return this.items.get(0);
    }

    @Override
    public Item<Integer> pop() throws EmptyStackException {
        if (this.isEmpty())
            throw new EmptyStackException();
        return this.items.remove(0);
    }
}
