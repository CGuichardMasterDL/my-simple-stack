package deqo.cgui.mysimplestack;

public class Item<N> {
    private String name;
    private N value;

    public Item(String name, N value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public N getValue() {
        return value;
    }

    public void setValue(N value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        return this.name.equals(((Item<N>)o).getName())
        && this.value.equals(((Item<N>)o).getValue());
    }

    @Override
    public String toString() {
        return "<Item " +
                "name='" + name + '\'' +
                ", value=" + value +
                '>';
    }
}
