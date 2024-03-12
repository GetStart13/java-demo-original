package 自定义注解;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class DebugToController {
    public static void main(String[] args) {
        debugToControllerTest();
    }

    /**
     * 通过 jdk 的 NativeMethodAccessorImpl 类的 invoke 方法，断点添加条件以截住 controller 注解
     * <li>一共有两个注解: </li>
     * <br>
     * <li>@RestController</li>
     * <li>@Controller</li>
     * <li>断点条件</li>
     * <br> obj != null && (obj.getClass().getAnnotation(org.springframework.web.bind.annotation.RestController.class) != null || obj.getClass().getAnnotation(org.springframework.stereotype.Controller.class) != null)
     * <br>
     * <br> 该方法存在明显缺点，经常无法截断 DEBUG 断点，应在 RequestMappingHandlerAdapter 类 -> invokeHandlerMethod 方法出打断点
     */
    static void debugToControllerTest() {
        MyObject obj = new MyObject();
        boolean annotation = obj != null &&
                (obj.getClass().getAnnotation(RestController.class) != null || obj.getClass().getAnnotation(Controller.class) != null);
        System.out.println("判断是否存在注解: " + annotation);
    }

    @RestController
    static class MyObject {
    }

    @Retention(RetentionPolicy.RUNTIME)
    @interface RestController {
        String value() default "";
    }

    @Retention(RetentionPolicy.RUNTIME)
    @interface Controller {
        String value() default "";
    }
}
