package 输出化学式;

import java.util.Map;

import static 输出化学式.ChemistryOut.isOut;


public class Demo {
    public static void main(String[] args) {
        //String str="Cab2A3GaAA(Fab3O+(CO3+O2)2(O2))4OXx2(DaCO3)5";
        String str="Ca(OH)2(H2(CO)3)3";
        Map<String, Integer> out = isOut(str);
        System.out.println(out);
    }
}
