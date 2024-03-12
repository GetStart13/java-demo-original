package test_temp;


public class TempDemo {
    public static void main(String[] args) {
        int count = 0;
        for (float y = 2.5F; y > -2.0F; y -= 0.12F) {
            for (float x = -2.3F; x < 2.3F; x += 0.041F) {
                float a = x * x + y * y - 4F;
                if ((a * a * a - x * x * y * y * y) < 0.0F) {
                    String str = "I love you!";
                    int num = count % str.length();
                    System.err.print(str.charAt(num));
                    count++;
                } else {
                    System.err.print(" ");
                }
            }
            System.err.println();
        }
    }
}
