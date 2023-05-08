package 反射;

import java.lang.reflect.Method;

public class 反射获取方法栈 {
    public static void main(String[] args) {
        反射获取方法栈 getMethodName = new 反射获取方法栈();
        getMethodName.useInnerClass();
        getMethodName.useThrowable();
        getMethodName.useException();
        getMethodName.useThreadStackTrace();
        getMethodName.middleMethod5();
    }

    void useInnerClass() {
        Method enclosingMethod = new Object() {
        }
                .getClass()
                .getEnclosingMethod();
        String name = enclosingMethod.getName();
        System.out.println("使用内部类的 getEnclosingMethod() : " + name);
    }

    void useThrowable() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        for (int i = 0; i < stackTrace.length; i++) {
            StackTraceElement element = stackTrace[i];
            System.out.println(i + ": " + element.getMethodName());
        }
    }

    void useException() {
        StackTraceElement[] stackTrace = new Exception().getStackTrace();
        for (int i = 0; i < stackTrace.length; i++) {
            StackTraceElement element = stackTrace[i];
            System.out.println(i + ": " + element.getMethodName());
        }
    }

    /**
     * 静态方法也是一样的
     */
    static void useThreadStackTrace() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (int i = 0; i < stackTrace.length; i++) {
            StackTraceElement element = stackTrace[i];
            System.out.println(i + ": " + element.getMethodName());
            System.out.println(i + "调用类类名: " + element.getClassName());
        }
    }

    void middleMethod1(String string) {
        useInnerClass();
        useThrowable();
        useException();
        useThreadStackTrace();
    }

    void middleMethod2() {
        middleMethod1("string");
    }

    void middleMethod3() {
        middleMethod2();
    }

    void middleMethod4() {
        middleMethod3();
    }

    void middleMethod5() {
        middleMethod4();
    }
}
