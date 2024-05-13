package 反射.读取文件内容并通过反射运行;


import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReadPropertiesFromFile {
    public static void main(String[] args) throws Exception {

        // 加载数据，实例化 Properties 对象
        Properties properties = new Properties();        //
        // 读取文件
        FileReader reader = new FileReader("temp/class.txt");
        // 加载文件
        properties.load(reader);
        // 关闭资源，节省资源
        reader.close();

        // 根据 properties key 获取 value
        String className = (String) properties.get("className");
        String methodName = properties.getProperty("methodName");

        // 通过 类全限定名 获取类对象
        Class<?> clazz = Class.forName(className);
        // 获取构造方法
        Constructor<?> constructor = clazz.getConstructor();
        // 实例化对象
        Object newInstance = constructor.newInstance();

        // 获取方法
        Method method = clazz.getMethod(methodName);
        // 调用方法
        method.invoke(newInstance);

    }
}
