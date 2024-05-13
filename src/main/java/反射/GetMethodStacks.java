package 反射;

import java.lang.reflect.Method;

/**
 * <p> 2024/4/17 </p>
 * 获取方法栈
 *
 * @author Fqq
 */
public class GetMethodStacks {
    public static void main(String[] args) {
        GetMethodStacks getMethodName = new GetMethodStacks();
        getMethodName.useInnerClass();
        getMethodName.useThrowable();
        getMethodName.useException();
        GetMethodStacks.useThreadStackTrace();
        getMethodName.middleMethod5();
    }

    private void useInnerClass() {
        Method enclosingMethod = new Object() {
        }
            .getClass()
            .getEnclosingMethod();
        String name = enclosingMethod.getName();
        System.out.println("Get current method name through `getEnclosingMethod` method: " + name);
    }

    private void useThrowable() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        for (int i = 0; i < stackTrace.length; i++) {
            StackTraceElement element = stackTrace[i];
            System.out.println(i + ": " + element.getMethodName());
        }
    }

    private void useException() {
        StackTraceElement[] stackTrace = new Exception().getStackTrace();
        for (int i = 0; i < stackTrace.length; i++) {
            StackTraceElement element = stackTrace[i];
            System.out.println(i + ": " + element.getMethodName());
        }
    }

    /**
     * 静态方法也是一样的
     */
    private static void useThreadStackTrace() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (int i = 0; i < stackTrace.length; i++) {
            StackTraceElement element = stackTrace[i];
            System.out.println(i + ": " + element.getMethodName());
            System.out.println(i + "调用类类名: " + element.getClassName());
        }
    }

    private void middleMethod1(String string) {
        useInnerClass();
        useThrowable();
        useException();
        useThreadStackTrace();
    }

    private void middleMethod2() {
        middleMethod1("string");
    }

    private void middleMethod3() {
        middleMethod2();
    }

    private void middleMethod4() {
        middleMethod3();
    }

    private void middleMethod5() {
        middleMethod4();
    }
}
