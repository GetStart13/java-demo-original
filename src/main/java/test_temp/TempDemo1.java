package test_temp;


import java.io.PrintWriter;
import java.io.StringWriter;

public class TempDemo1 {


    public static void main(String[] args) {
        TempDemo1 demo1 = new TempDemo1();
        demo1.test();
    }

    void test() {
        try {
            testException();
        } catch (Exception e) {
            StringWriter stringWriter = new StringWriter();
            e.printStackTrace(new PrintWriter(stringWriter));
            String string = stringWriter.toString();
            System.out.println(string);
        }
    }

    void testException() {
        String msg = "someException";
        throw new RuntimeException("throw msg: " + msg);
    }
}
