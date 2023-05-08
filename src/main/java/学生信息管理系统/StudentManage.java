package 学生信息管理系统;

/*学生信息管理系统：
1、添加学生
2、删除学生
3、修改学生
4、查看学生
5、退出系统*/

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManage {

    public static void main(String[] args) {
        //创建集合
        ArrayList<Student> array = new ArrayList<>();

        //while死循环：
        while (true) {

            //显示界面：
            System.out.println("学生信息管理系统：\n" +
                    "1、添加学生\n" +
                    "2、删除学生\n" +
                    "3、修改学生\n" +
                    "4、查看学生\n" +
                    "5、退出系统\n" +
                    "请输入选择：");
            Scanner sc = new Scanner(System.in);
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("添加学生");
                    addStudent(array);
                    break;
                case 2:
                    System.out.println("删除学生");
                    deleteStudent(array);
                    break;
                case 3:
                    System.out.println("修改学生");
                    editStudent(array);
                    break;
                case 4:
                    System.out.println("查看学生");
                    findStudent(array);
                    break;
                case 5:
                    System.out.println("退出系统");
                    System.exit(0);
                default:
                    System.out.println("输入有误，请重新输入");
                    break;
            }
        }
    }

    public static void addStudent(ArrayList<Student> array) {
        //输入数据：
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生学号：");
        String sid = sc.nextLine();

        for (int i = 0; i < array.size(); i++) {

            //System.out.println(i);
            if (sid.equals(array.get(i).sid)) {
                System.out.println("该学号已存在，请重新输入：");
                sid = sc.nextLine();
                i = -1;
                //System.out.println(i);
            }
        }

        System.out.println("请输入学生姓名：");
        String name = sc.nextLine();
        System.out.println("请输入学生年龄：");
        int age = sc.nextInt();
        sc = new Scanner(System.in);
        System.out.println("请输入学生地址：");
        String address = sc.nextLine();

        //新建学生对象，调用方法传参
        Student student = new Student();
        student.setSid(sid);
        student.setName(name);
        student.setAge(age);
        student.setAddress(address);

        //用集合添加数据:
        array.add(student);
        System.out.println("添加数据成功！");

    }

    public static void findStudent(ArrayList<Student> array) {
        System.out.println("学号\t姓名\t年龄\t地址");
        /*遍历集合：*/
        /*for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);//将遍历的每一个集合赋值给对象s
            System.out.println(s.getSid() + "\t" + s.getName() + "\t" + s.getAge() + "岁\t\t" + s.getAddress());
        }*/
        for (Student s:array){//超级for循环遍历
            System.out.println(s.getSid() + "\t" + s.getName() + "\t" + s.getAge() + "岁\t\t" + s.getAddress());

        }
    }

    public static void deleteStudent(ArrayList<Student> array) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除学生学号：");
        String id = sc.nextLine();
        int index = -1;
        /*遍历集合*/
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            if (id.equals(s.sid)) {//如果集合中有id与输入id相等
                array.remove(i);//则执行删除该条数据操作
                System.out.println("删除成功！");
                index += 1;
                break;
            }
            /*不能用else，否则不能达到想要的运行效果，设一个index，用其完成效果
            else {
                System.out.println("该学号不存在！");
            }*/
        }
        if (index == -1) {
            System.out.println("该学号不存在！");
        }
    }

    public static void editStudent(ArrayList<Student> array) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要修改学生学号：");
        String id = sc.nextLine();
        int index = -1;
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            if (id.equals(s.sid))//如果学号存在，则执行以下操作
            {
                System.out.println("请输入姓名：");
                String name = sc.nextLine();
                System.out.println("请输入年龄：");
                int age = sc.nextInt();
                System.out.println("请输入地址：");
                sc = new Scanner(System.in);
                String address = sc.nextLine();
                /*Student s1=new Student();用s即可重新赋值，无需重新创建对象
                s.setSid(id);*/
                s.setName(name);
                s.setAge(age);
                s.setAddress(address);
                array.set(i, s);//更改该条数据
                System.out.println("修改成功！");
                index += 1;
                break;
            }
        }
        if (index == -1) {
            System.out.println("该学号不存在！");
        }
    }
}
