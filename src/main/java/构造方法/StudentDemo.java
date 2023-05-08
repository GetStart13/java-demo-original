package 构造方法;
/*测试类*/

import 构造方法.Student;

public class StudentDemo {


    public static void main(String[] args) {
        Student s = new Student();
        s.show();
        Student s2 = new Student("周明", 22);
        s2.show();
        /*先有构造方法实例化对象：*/
        Student s3 = new Student("", 0);
        /*然后对象才可以使用类中成员方法：*/
        s3.setName("曹操");
        s3.setAge(56);
        s3.show();
    }
}
