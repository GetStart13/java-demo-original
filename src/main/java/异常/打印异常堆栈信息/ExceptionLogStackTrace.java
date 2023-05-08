package 异常.打印异常堆栈信息;

import 异常.自定义异常.MyException;
import 异常.获取造成异常的根本原因.GetThrowableRootCause;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionLogStackTrace {
    /**
     * 捕获异常的类
     */
    public void catchException() {
        try {
            exceptionCause();
        } catch (Exception e) {
            Throwable cause = GetThrowableRootCause.getThrowableRootCause(e);
            System.out.println(cause instanceof MyException);
            // e 的信息不等同于 根异常原因
            System.out.println(cause.getMessage());
            // StringWriter 保存异常信息
            StringWriter stringWriter = new StringWriter();
            // 将堆栈信息保存到 StringWriter 中
            e.printStackTrace(new PrintWriter(stringWriter));
            // 转成 String
            String stackTraceMessage = stringWriter.toString();
            // 打印
            System.out.println(stackTraceMessage);
        }
    }

    /**
     * 发生异常的类
     */
    private void exceptionCause() {
        String parameter = "key";
        throw new MyException("some exception cause, value is: " + parameter);
    }
}
