package 序列化和反序列化;

import java.io.Serial;
import java.io.Serializable;

public class Student implements Serializable {
    // 序列化 ID
    @Serial
    private static final long serialVersionUID = -8412550649904251736L;
    private String name;
    private Integer age;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
