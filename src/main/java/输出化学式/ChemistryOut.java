package 输出化学式;

import java.util.HashMap;
import java.util.Map;

public class ChemistryOut {
    /**
     * 只对4种输入有效，大小写字字母，数字，括号
     */
    private static Map<String, Integer> map = new HashMap<>();
    private static int i = 0;//定义全局变量，时间复杂度O(n)
    private static int x = 1;//全局变量，括号外的倍数（例子：Ca(OH)2中的2)

    public static Map<String, Integer> isOut(String str) {
        for (; i < str.length(); i++) {
            //如果大写开头
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                int num = 1;
                StringBuilder stb = new StringBuilder();
                stb.append(str.charAt(i));
                //如果大写后边是小写，就 i+1 ，继续添加stb
                if (i + 1 < str.length() && str.charAt(i + 1) >= 'a' && str.charAt(i + 1) <= 'z') {
                    i = i + 1;//遍历下一个
                    for (; i < str.length(); i++) {
                        if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') { //如果后边是小写
                            stb.append(str.charAt(i));
                        } else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {//小写后面是数字
                            //char转换字符串，解析为数字，不解析就是SCAII码
                            num = Integer.parseInt(str.charAt(i) + "");
                            //System.out.println(num);
                        } else {
                            //System.out.println(i+"x");
                            i--;
                            break; //跳出本次循环，可以保留 i 用于后继循环
                        }
                    }
                } else if (i + 1 < str.length() && str.charAt(i + 1) >= '0' && str.charAt(i + 1) <= '9') {//大写后边是数字的情况
                    num = Integer.parseInt(str.charAt(i + 1) + "");
                }
                String ss = stb.toString();
                if (map.get(ss) != null) {//如果已存在，相加
                    num = num * x + map.get(ss);
                    map.put(ss, num);
                } else {
                    map.put(ss, num * x);
                }
            } else if ((str.charAt(i) + "").equals("(")) {
                int brackets = 1;
                int z = i + 1;
                while (z < str.length()) {
                    if ((str.charAt(z) + "").equals("(")) {
                        brackets++;
                    }
                    if ((str.charAt(z) + "").equals(")")) {
                        brackets--;
                        if (z + 1 < str.length() && brackets == 0 && str.charAt(z + 1) >= '0' && str.charAt(z + 1) <= '9') {
                            x = Integer.parseInt(str.charAt(z + 1) + "") * x;
                            //System.out.println(y+"if");//Cab2A3GaAA(Fab3O+(CO3+O2)2(O2))4OXx2(DaCO3)5
                            i++;//越过'('，递归，如果不越过，无限递归
                            isOut(str);
                        }
                        if (brackets == 0) {
                            break;
                        }
                    }
                    z++;
                    try {
                        if (z == str.length() - 1 && brackets != 0) {
                            throw new WrongBracketsException("请检查括号！");
                        }
                    } catch (WrongBracketsException we) {
                        System.out.println(we.getMessage());
                    }
                }
            } else if ((str.charAt(i) + "").equals(")") &&
                    i + 1 < str.length() && str.charAt(i + 1) >= '0' && str.charAt(i + 1) <= '9') {
                x = x / Integer.parseInt(str.charAt(i + 1) + "");//除去括号后面倍数
            }
        }
        return map;
    }
}
