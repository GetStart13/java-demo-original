package 多态;

public class Animal {
    protected String name = "animal";

    public void eat() {
        System.out.println("猫");
    }

    public String getName() {
        return name;
    }

    public String getNameAnimal() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
