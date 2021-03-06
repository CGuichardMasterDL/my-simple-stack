package deqo.cgui.mysimplestack;

import java.util.EmptyStackException;

public interface SimpleStack {
    /**
     * Tests if this stack is empty
     */
    public boolean isEmpty();
    /**
     * Returns the number of items in this stack.
     */
    public int getSize();
    /**
     * Returns the maximal number of items stocked in the simple stack     */
    public int getLimit();
    /**
     * Pushes an item onto the top of this stack.
     * null item is allowed.
     */
    public void push(Item<Integer> item);
    /**
     * Looks at the object at the top of this stack without removing it from the stack.
     */
    public Item<Integer> peek() throws EmptyStackException;
    /**
     * Removes the object at the top of this stack and returns that object as the value of this function.
     * ​ @throws​ EmptyStackException if this stack is empty.
     */
    public Item<Integer> pop() throws EmptyStackException;
}
