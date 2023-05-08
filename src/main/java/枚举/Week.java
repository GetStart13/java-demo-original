package 枚举;

import java.util.EnumMap;

/**
 *
 */
public enum Week {
    MONDAY(1, "星期一"),
    TUESDAY(2, "星期二"),
    WEDNESDAY(3, "星期三"),
    THURSDAY(4, "星期四"),
    FRIDAY(5, "星期五"),
    SATURDAY(6, "星期六"),
    SUNDAY(7, "星期日");

    private final Integer key;
    private final String desc;

    /**
     * 构造方法，如果枚举被创建对象，则构造方法内语句会被执行总枚举数次，本例为7
     * 构造方法的入参决定了枚举的参数，本例中构造方法入参有两个，所以每一个枚举常量必须也有两个参数
     *
     * @param key  构造方法入参
     * @param desc 构造方法入参
     */
    Week(Integer key, String desc) {
        this.key = key;
        this.desc = desc;
    }

    public static Week inCode(Integer code) {
        if (code.equals(MONDAY.key)) {
            return MONDAY;
        }
        if (code.equals(TUESDAY.key)) {
            return TUESDAY;
        }
        if (code.equals(WEDNESDAY.key)) {
            return WEDNESDAY;
        }
        if (code.equals(THURSDAY.key)) {
            return THURSDAY;
        }
        if (code.equals(FRIDAY.key)) {
            return FRIDAY;
        }
        if (code.equals(SATURDAY.key)) {
            return SATURDAY;
        }
        if (code.equals(SUNDAY.key)) {
            return SUNDAY;
        } else {
            return MONDAY;
        }
    }

    public static Week inCode1(Integer code) {
        for (Week value : Week.values()) {
            if (code.equals(value.key)) {
                return value;
            }
        }
        return null;
    }

    public static String getDay(Week week) {
        // EnumMap<> : 专门操作枚举的 map 集合，具有高性能的优点
        EnumMap<Week, String> day = new EnumMap<>(Week.class);
        day.put(MONDAY, MONDAY.desc);
        day.put(TUESDAY, TUESDAY.desc);
        day.put(WEDNESDAY, WEDNESDAY.desc);
        day.put(THURSDAY, THURSDAY.desc);
        day.put(FRIDAY, FRIDAY.desc);
        day.put(SATURDAY, SATURDAY.desc);
        day.put(SUNDAY, SUNDAY.desc);
        return day.get(week);
    }

    public Integer getKey() {
        return key;
    }

    public String getDesc() {
        return desc;
    }

}
