package deqo.cgui.mysimplestack;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class Stack implements SimpleStack {
    private ArrayList<Item> items;

    public Stack() {
        this.items = new ArrayList<Item>();
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
    public void push(Item item) {
        this.items.add(item);
    }

    @Override
    public Item peek() throws EmptyStackException {
        if (this.isEmpty())
            throw new EmptyStackException();
        return this.items.get(0);
    }

    @Override
    public Item pop() throws EmptyStackException {
        if (this.isEmpty())
            throw new EmptyStackException();
        return this.items.remove(0);
    }
}
