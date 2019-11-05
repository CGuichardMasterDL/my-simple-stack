package deqo.cgui.mysimplestack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {
    private Item<Integer> item;
    private String name;
    private int value;

    @Before
    public void setUp() throws Exception {
        this.name = "Item test";
        this.value = 5;
        this.item = new Item<Integer>(this.name, this.value);
    }

    @Test
    public void getName() {
        assertEquals(this.item.getName(), this.name);
        assertNotEquals(this.item.getName(), this.name+"1");
    }

    @Test
    public void setName() {
        String ajout = "45";
        this.item.setName(this.name+ajout);
        assertNotEquals(this.item.getName(), this.name);
        assertEquals(this.item.getName(), this.name+ajout);
        this.item.setName(this.name);
        assertEquals(this.item.getName(), this.name);
    }

    @Test
    public void getValue() {
        assertEquals(this.item.getValue().intValue(), this.value);
        assertNotEquals(this.item.getValue().intValue(), this.value+5);
    }

    @Test
    public void setValue() {
        int ajout = 45;
        this.item.setValue(this.value+ajout);
        assertNotEquals(this.item.getValue().intValue(), this.value);
        assertEquals(this.item.getValue().intValue(), this.value+ajout);
        this.item.setValue(this.value);
        assertEquals(this.item.getValue().intValue(), this.value);
    }

    @Test
    public void testEquals() {
        Item<Integer> itemEq = new Item<Integer>(this.name, this.value);
        Item<Integer> itemNotEq1 = new Item<Integer>(this.name+" différent", this.value);
        Item<Integer> itemNotEq2 = new Item<Integer>(this.name, this.value+1);
        assertEquals(this.item, itemEq);
        assertNotEquals(this.item, itemNotEq1);
        assertNotEquals(this.item, itemNotEq2);

        Item<Integer> itemt1 = new Item<Integer>(this.name+"b", this.value+5);
        assertNotEquals(this.item, itemt1);
        itemt1.setValue(this.value);
        assertNotEquals(this.item, itemt1);
        itemt1.setName(this.name);
        assertEquals(this.item, itemt1);
    }

    @Test
    public void testToString() {
        assertTrue(this.item.toString().contains("Item"));
    }
}