package 多态;

public class Cat extends Animal {
    protected String name = "cat";

    @Override
    public void eat() {
        System.out.println("猫");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
