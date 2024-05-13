package 反射.实体类;

public class Student implements People {
    private int id;
    private String name;

    public Student() {
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void publicMethod() {
        System.out.println("public method");
    }

    public void publicMethod(String name) {
        System.out.println("public method" + name);
    }

    private String privateMethod(String name, int id) {
        return "private method: " + name + id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", s_name='" + name + '\'' +
                '}';
    }
}
