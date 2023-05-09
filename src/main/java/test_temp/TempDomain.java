package test_temp;

public class TempDomain {
    private int intType;
    private byte byteType;
    private char charType;
    private long longType;
    private short shortType;
    private float floatType;
    private double doubleType;
    private boolean booleanType;

    public TempDomain() {

    }

    public int getIntType() {
        return intType;
    }

    public void setIntType(int intType) {
        this.intType = intType;
    }

    public byte getByteType() {
        return byteType;
    }

    public void setByteType(byte byteType) {
        this.byteType = byteType;
    }

    public char getCharType() {
        return charType;
    }

    public void setCharType(char charType) {
        this.charType = charType;
    }

    public long getLongType() {
        return longType;
    }

    public void setLongType(long longType) {
        this.longType = longType;
    }

    public short getShortType() {
        return shortType;
    }

    public void setShortType(short shortType) {
        this.shortType = shortType;
    }

    public float getFloatType() {
        return floatType;
    }

    public void setFloatType(float floatType) {
        this.floatType = floatType;
    }

    public double getDoubleType() {
        return doubleType;
    }

    public void setDoubleType(double doubleType) {
        this.doubleType = doubleType;
    }

    public boolean isBooleanType() {
        return booleanType;
    }

    public void setBooleanType(boolean booleanType) {
        this.booleanType = booleanType;
    }

    @Override
    public String toString() {
        return "TempDomain{" +
                "intType=" + intType +
                ", byteType=" + byteType +
                ", charType=" + charType +
                ", longType=" + longType +
                ", shortType=" + shortType +
                ", floatType=" + floatType +
                ", doubleType=" + doubleType +
                ", booleanType=" + booleanType +
                '}';
    }
}
