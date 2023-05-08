package 枚举;

/**
 * <p> 2023/1/28 </p>
 * 忽略大小写解析
 *
 * @author Fqq
 */
public class EnumParser {
    private EnumParser() {
    }

    @SuppressWarnings("unchecked")
    public static <T extends Enum<T>> T parse(Enum<T>[] enums, String code) {
        for (Enum<T> anEnum : enums) {
            if (anEnum.name().equalsIgnoreCase(code)) {
                return (T) anEnum;
            }
        }
        return (T) enums[0];
    }
}
