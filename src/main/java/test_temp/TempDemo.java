package test_temp;


import java.util.Optional;
import java.util.Random;

public class TempDemo {
    public static void main(String[] args) {
        String command = "command:$REQUEST,2,6\r\n";
        String content = Optional.ofNullable(command)
                .map(s -> s.substring(s.lastIndexOf(",")+1))
                .map(String::trim)
                .orElse("");
        System.out.println(content);
        Integer integer = new Random().nextInt(10) * 10;
        System.out.println(integer);
        double nextDouble = new Random().nextDouble(10);
        System.out.println(Double.toString(nextDouble).substring(0, 3));
    }

}
