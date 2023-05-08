package label标签;

public class LabelTest {
    public static void main(String[] args) {
        LabelTest labelTest = new LabelTest();
        labelTest.ifElseBreak();
    }

    /**
     * 结束标签体
     */
    void ifElseBreak() {
        int i = 1;
        label01:
        {
            if (i == 0) {
                System.out.println(0);
                break label01;
            }
            if (i == 1) {
                System.out.println(1);
                break label01;
            }
            if (i == 2) {
                System.out.println(2);
                break label01;
            }
            System.out.println("run to here");
        }
    }
}
