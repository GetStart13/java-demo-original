package 异常;

import 异常.打印异常堆栈信息.ExceptionLogStackTrace;
import 异常.自定义异常.MyException;

class Demo {
    public static void main(String[] args) {
        ExceptionLogStackTrace logStackTrace = new ExceptionLogStackTrace();
        logStackTrace.catchException();
        Demo demo = new Demo();
        demo.test();
    }

    void test() {
        testCustomException();
    }

    void testCustomException() {
        try {
            customException();
            allException();
        } catch (MyException myException) {
            System.out.println(">>>>>>>>>>>>>> 自定义异常 >>>>>>>>>>>>");
            myException.printStackTrace();
        } catch (Exception e) {
            throw new MyException(">>>>>>>>>>>>> 转换成自定义异常，并且捕获异常发生原因 >>>>>>>>>>>>>", e);
        }
    }

    void customException() {
//        throw new MyException("自定义异常");
    }

    void allException() {
        String msg = null;
        System.out.println(msg.length());
    }
}
