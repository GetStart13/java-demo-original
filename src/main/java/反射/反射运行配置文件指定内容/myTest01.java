package 反射.反射运行配置文件指定内容;


import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;

public class myTest01 {
    public static void main(String[] args) throws Exception {

        //加载数据
        Properties pro=new Properties();        //获取Properties对象
        FileReader reader = new FileReader("class.txt");//获取文件对象，读取文件
        pro.load(reader);                               //加载文件
        reader.close();             //关闭资源，节省资源

        String className = (String) pro.get("className");//通过key获取value
        String me = pro.getProperty("methodName");//通过key获取value

        Class<?> c = Class.forName(className);//通过 全类名 获取类的对象
        Constructor<?> con = c.getConstructor();//获取构造方法
        Object obj = con.newInstance();//获取对象

        Method method = c.getMethod(me);//获取方法
        method.invoke(obj);//调用方法

    }
}
