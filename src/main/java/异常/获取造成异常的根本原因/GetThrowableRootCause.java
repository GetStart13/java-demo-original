package 异常.获取造成异常的根本原因;

import java.util.Objects;

public class GetThrowableRootCause {
    public static Throwable getThrowableRootCause(Throwable throwable) {
        Objects.requireNonNull(throwable);
        Throwable cause = throwable;
        while (cause.getCause() != null && cause.getCause() != cause) {
            cause = cause.getCause();
        }
        return cause;
    }
}
