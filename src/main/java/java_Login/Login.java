package java_Login;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        String username = "godlike";
        String password = "123";
        Scanner sc = new Scanner(System.in);
        int i = 3;
        while (i > 0) {
            System.out.println("请输入用户名：");
            String name = sc.nextLine();
            System.out.println("请输入密码：");
            String pws = sc.nextLine();
            i--;
            if (name.equals(username) && pws.equals(password)) {
                System.out.println("登陆成功!");
                break;
            }
            if (i == 0) {
                System.out.println("你完蛋了！");
            } else {
                System.out.println("登陆失败，还有" + i + "次机会");
            }
        }
    }
}
