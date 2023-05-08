package 获取项目根路径;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * 获取项目根路径的方法
 */
public class MyUrlDemo {


    public static void main(String[] args) {
        MyUrlDemo muDemo = new MyUrlDemo();
        try {
            muDemo.showURL();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void showURL() throws IOException {

        // 第一种： 获取类加载的根路径   D:\项目路径\target\classes
        File classFileAbsolutePath = new File(this.getClass().getResource("/").getPath());
        System.out.println("path1: " + classFileAbsolutePath);

        // 获取当前类的所在工程路径; 如果不加 “/”  获取当前类的加载目录  D:\项目路径\target\classes\my_directory
        File classFileRelativePath = new File(this.getClass().getResource("").getPath());
        System.out.println("path1: " + classFileRelativePath);

        // 第二种： 获取项目路径    D:\项目路径\项目文件夹名
        File directory = new File("");// 参数为空
        String courseFile = directory.getCanonicalPath();
        System.out.println("path2: " + courseFile);


        // 第三种： file:/D:/项目路径/target/classes/
        URL xmlPath = this.getClass().getClassLoader().getResource("");
        System.out.println("path3: " + xmlPath);

        // 第四种： D:\项目路径
        System.out.println("path4:" + System.getProperty("user.dir"));

        // 第五种：  获取所有的类路径，包括 jar 包的路径
        System.out.println("path5: " + System.getProperty("java.class.path").split(";")[0]);

        // 第六种：  获取项目路径  D:/g项目路径/target/classes/
        System.out.println("path6: " + Thread.currentThread().getContextClassLoader().getResource("").getPath());

        // 第七种  表示到项目的根目录下，要是想到目录下的子文件夹，修改 "/" 即可，request 是 HttpServletRequest 类对象
        /*String path7 = request.getSession().getServletContext().getRealPath("/");
        System.out.println("path7: " + path7);*/
    }
}
