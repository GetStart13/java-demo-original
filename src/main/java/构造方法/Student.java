package 构造方法;

import java.util.Scanner;

/**
 * 构造方法，作用：创建对象，对构造出来的类的实例初始化
 */
public class Student {
    // 成员变量 / 属性 / 字段
    private String name;
    private int age;
    Scanner sc = new Scanner(System.in);

    /**
     * 无参构造方法
     */
    public Student() {
        name = sc.next();
        age = sc.nextInt();
        System.out.println("无参构造方法");
    }

    /**
     * 多参构造方法
     */
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("多参构造方法");
    }

    /**
     * 成员方法
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void show() {
        System.out.println(name + "," + age);
    }
}
