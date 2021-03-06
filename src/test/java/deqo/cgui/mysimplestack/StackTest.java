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
        this.stack.push(new Item<Integer>("", 0));
        assertFalse(this.stack.isEmpty());
        this.stack.pop();
        assertTrue(this.stack.isEmpty());
    }

    @Test
    public void getSize() {
        assertEquals(0, this.stack.getSize());
        this.stack.push(new Item<Integer>("", 0));
        assertNotEquals(0, this.stack.getSize());
        this.stack.pop();
        assertEquals(0, this.stack.getSize());
    }

    @Test
    public void getLimit() {
        assertEquals(-1, this.stack.getLimit());
        int n = 20;
        Stack s = new Stack(n);
        assertEquals(n, s.getLimit());
    }

    @Test
    public void push() {
        assertTrue(this.stack.isEmpty());
        this.stack.push(new Item<Integer>("", 0));
        assertFalse(this.stack.isEmpty());

        int n = 10;
        Stack s = new Stack(n);
        for (int i = 0; i < n; ++i)
            s.push(new Item<Integer>("", 0));
        exception.expect(StackOverflowError.class);
        s.push(new Item<Integer>("", 0));
    }

    @Test
    public void peek() {
        Item<Integer> item = new Item<Integer>("", 0);
        System.out.println(item);
        this.stack.push(item);
        assertEquals(item, this.stack.peek());
        assertNotEquals(new Item<Integer>("", 1), this.stack.peek());
        assertNotEquals(new Item<Integer>("test", 0), this.stack.peek());
        this.stack.pop();
        exception.expect(EmptyStackException.class);
        this.stack.peek();
    }

    @Test
    public void pop() {
        this.stack.push(new Item<Integer>("", 0));
        assertFalse(this.stack.isEmpty());
        this.stack.pop();
        assertTrue(this.stack.isEmpty());
        exception.expect(EmptyStackException.class);
        this.stack.pop();
    }
}