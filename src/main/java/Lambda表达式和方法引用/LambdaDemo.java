package Lambda表达式和方法引用;

import java.util.function.Function;

public class LambdaDemo {
    public static void main(String[] args) {
        String msg = "周明,23";

        // !!! Lambda 表达式本质是将一个方法体作为参数传递 !!!
        // 此处定义 lambda 表达式的方法体，在 change 方法中，fun1 和 fun2 的 apply 方法逻辑来自此处，
        // 但它们的实参来自 change 方法内部，这类似于 javascript 的回调函数
        change(msg, firstConvert -> firstConvert.split(",")[1], secondConvert -> Integer.parseInt(secondConvert) + 77);
    }

    public static void change(String string, Function<String, String> fun1, Function<String, Integer> fun2) {
        Function<String, Integer> firstConvert = fun1.andThen(fun2); // 此处只实现了逻辑，并未涉及参数
        Integer secondConvert = firstConvert.apply(string); // apply 逻辑在调用时被实现
        System.out.println(secondConvert);
    }
}
