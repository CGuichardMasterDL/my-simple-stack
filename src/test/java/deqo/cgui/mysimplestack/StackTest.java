package deqo.cgui.mysimplestack;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class StackTest {
    private Stack stack;

    @Before
    public void setUp() throws Exception {
        this.stack = new Stack();
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void isEmpty() {
        assertTrue(this.stack.isEmpty());
        this.stack.push(new Item());
        assertFalse(this.stack.isEmpty());
        this.stack.pop();
        assertTrue(this.stack.isEmpty());
    }

    @Test
    public void getSize() {
        assertEquals(0, this.stack.getSize());
        this.stack.push(new Item());
        assertNotEquals(0, this.stack.getSize());
        this.stack.pop();
        assertEquals(0, this.stack.getSize());
    }

    @Test
    public void push() {
        assertTrue(this.stack.isEmpty());
        this.stack.push(new Item());
        assertFalse(this.stack.isEmpty());
    }

    @Test
    public void peek() {
        Item item = new Item();
        this.stack.push(item);
        assertEquals(item, this.stack.peek());
        assertNotEquals(new Item(1), this.stack.peek());
        this.stack.pop();
        exception.expect(EmptyStackException.class);
        this.stack.peek();
    }

    @Test
    public void pop() {
        this.stack.push(new Item());
        assertFalse(this.stack.isEmpty());
        this.stack.pop();
        assertTrue(this.stack.isEmpty());
        exception.expect(EmptyStackException.class);
        this.stack.pop();
    }
}