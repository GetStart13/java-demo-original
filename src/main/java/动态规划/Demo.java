package 动态规划;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Demo {

    /**
     * 给定硬币种类，用最少硬币数，拼成给定金额数值
     */
    public int f(int x, int[] arr) {
        // 用数组标记
        int[] g = new int[x + 1];
        // 初始设置第 0 个数组为 1 是因为：无法使用任何硬币拼成 0 这个面值，而如果任何数值减去一个硬币能等于 0，则说明它可以由这个硬币拼成，
        // 所以对 0 这个位置做特殊标记，用于表示它可以被拼成，这里我们设置为 1，在返回时只要 -1 就能够得到原解
        g[0] = 1;
        // 循环遍历每一个数值的，使用对应的数组下标记录拼成它的最少硬币数的解
        for (int i = 1; i <= x; ++i) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int value : arr) {  // arr[] 输入硬币类型
                // g[i - value] != 0 ：说明 i - value 这个数值有解，value 为硬币面值，i 为需要拼成的数值，我们也利用它作为下标
                // 记录拼成该数值的最少硬币数，如果 g[i - value] 不为 0，则说明 i - value 这个数值，可以用最少硬币拼成，那么我们
                // 用它加上这个硬币值 value ，就得到了拼成这个数值的一种方法（解），但不能确定它是不是最优的（因为硬币不止一种，
                // 其它硬币也可能可以和其它数值拼成这个数值），所以先把它存进集合里，用作以后判断。
                // i >= value 只是用作防止数组越界
                if (i >= value && g[i - value] != 0) {
                    // 既然 i - value 这个数值有解，它加上硬币面值 value 等于 i，那么就是 i 的解等于它的解 +1，因为一个 value 代表一个硬币
                    list.add(g[i - value] + 1);
                }
            }
            // 如果该数值（x）的集合长度不为空，则说明它可以由这些硬币拼成这个面值
            if (!list.isEmpty()) {
                // 取最小的硬币数作为该数值的解
                g[i] = Collections.min(list);
            }
        }
        // 输出每一个数值对应的解
        System.out.println(Arrays.toString(g));
        // 减去前面对 0 位数组的标记
        return g[x] - 1;
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        int[] ints = {2, 5, 7};
        System.out.println(demo.f(27, ints));
    }
}
