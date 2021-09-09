package atomic;

public class Person {

    private Integer index;

    private String Name;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "index=" + index +
                ", Name='" + Name + '\'' +
                '}';
    }
}
