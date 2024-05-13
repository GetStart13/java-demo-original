package 构造方法;

public class StudentDemo {


    public static void main(String[] args) {
        Student student = new Student();
        student.show();
        Student student1 = new Student("周明", 22);
        student1.show();
        // 先有构造方法实例化对象
        Student student2 = new Student("", 0);
        // 然后对象才可以使用类中成员方法
        student2.setName("曹操");
        student2.setAge(56);
        student2.show();
    }
}
