package 枚举;

public enum Sex {
    MAN("男"),
    WOMAN("女");

    private final String code;

    Sex(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public Sex parse(String code) {
        return EnumParser.parse(Sex.values(), code);
    }

}
