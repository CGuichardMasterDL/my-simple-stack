package deqo.cgui.mysimplestack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {
    Item item;
    String name;
    int value;

    @Before
    public void setUp() throws Exception {
        this.name = "Item test";
        this.value = 5;
        this.item = new Item(this.name, this.value);
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
        assertEquals(this.item.getValue(), this.value);
        assertNotEquals(this.item.getValue(), this.value+5);
    }

    @Test
    public void setValue() {
        int ajout = 45;
        this.item.setValue(this.value+ajout);
        assertNotEquals(this.item.getValue(), this.value);
        assertEquals(this.item.getValue(), this.value+ajout);
        this.item.setValue(this.value);
        assertEquals(this.item.getValue(), this.value);
    }

    @Test
    public void increaseValue() {
        int ajout = 5;
        assertEquals(this.item.getValue(), this.value);
        this.item.increaseValue(ajout);
        assertEquals(this.item.getValue(), this.value + ajout);
        for (int i = 0; i < ajout ; ++i) {
            this.item.increaseValue(ajout);
        }
        assertEquals(this.item.getValue(), this.value + ajout + ajout*ajout);
    }

    @Test
    public void decreaseValue() {
        int retire = 5;
        assertEquals(this.item.getValue(), this.value);
        this.item.decreaseValue(retire);
        assertEquals(this.item.getValue(), this.value - retire);
        for (int i = 0; i < retire ; ++i) {
            this.item.decreaseValue(retire);
        }
        assertEquals(this.item.getValue(), this.value - retire - retire*retire);
    }

    @Test
    public void testEquals() {
        Item itemEq = new Item(this.name, this.value);
        Item itemNotEq1 = new Item(this.name+" différent", this.value);
        Item itemNotEq2 = new Item(this.name, this.value+1);
        assertEquals(this.item, itemEq);
        assertNotEquals(this.item, itemNotEq1);
        assertNotEquals(this.item, itemNotEq2);

        Item itemt1 = new Item();
        Item itemt2 = new Item(this.value);
        Item itemt3 = new Item(this.name);
        assertNotEquals(this.item, itemt1);
        assertNotEquals(this.item, itemt2);
        assertNotEquals(this.item, itemt3);
        itemt1.setValue(this.value);
        itemt1.setName(this.name);
        itemt2.setName(this.name);
        itemt3.setValue(this.value);
        assertEquals(this.item, itemt1);
        assertEquals(this.item, itemt2);
        assertEquals(this.item, itemt3);
    }

    @Test
    public void testToString() {
        assertTrue(this.item.toString().contains("Item"));
    }
}