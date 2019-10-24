package deqo.cgui.mysimplestack;

public class Item {
    private String name;
    private int value;

    public Item() {
        this.name = "";
        this.value = 0;
    }

    public Item(String name) {
        this.name = name;
        this.value = 0;
    }

    public Item(int value) {
        this.name = "";
        this.value = value;
    }

    public Item(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void increaseValue(int val) {
        this.value += val;
    }

    public void decreaseValue(int val) {
        this.value -= val;
    }

    @Override
    public boolean equals(Object o) {
        return this.name.equals(((Item)o).name) && this.value == ((Item)o).value;
    }

    @Override
    public String toString() {
        return "<Item " +
                "name='" + name + '\'' +
                ", value=" + value +
                '>';
    }
}
