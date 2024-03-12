package 通过getter方法获取实体属性值;

import java.io.Serializable;
import java.util.function.Function;

/**
 * <p> 2024/3/12 </p>
 * 实现了 Serializable 接口的函数式接口才会有序列化的 writeReplace 方法
 *
 * @author Fqq
 */
@FunctionalInterface
public interface GetterFunction<T, N> extends Function<T, N>, Serializable {

}
