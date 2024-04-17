package 获取项目路径;

import java.io.File;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Paths;

/**
 * 获取项目根路径的方法
 */
public class GetProjectPathDemo {
    public static void main(String[] args) {

        printCurrentWorkingDirectory1();
        printCurrentWorkingDirectory2();
        printCurrentWorkingDirectory3();
        printCurrentWorkingDirectory4();

        GetProjectPathDemo getProjectPathDemo = new GetProjectPathDemo();
        InputStream fileFromResourceAsStream = getProjectPathDemo.getFileFromResourceAsStream("mysql-config.properties");
        System.out.println("Loaded the file: " + fileFromResourceAsStream);
    }

    // System Property
    private static void printCurrentWorkingDirectory1() {
        String userDirectory = System.getProperty("user.dir");
        System.out.println("System property: " + userDirectory);
    }

    // Path, Java 7
    private static void printCurrentWorkingDirectory2() {
        String userDirectory = Paths.get("")
            .toAbsolutePath()
            .toString();
        System.out.println("Path, for java 7: " + userDirectory);
    }

    // File("")
    private static void printCurrentWorkingDirectory3() {
        String userDirectory = new File("").getAbsolutePath();
        System.out.println("File instance: " + userDirectory);
    }

    // FileSystems
    private static void printCurrentWorkingDirectory4() {
        String userDirectory = FileSystems.getDefault()
            .getPath("")
            .toAbsolutePath()
            .toString();
        System.out.println("FileSystems: " + userDirectory);
    }


    // 类路径下与 resources 文件夹下的文件，需要通过类加载路径读取
    // Get a file from the `resources` folder, root of classpath in JAR
    private InputStream getFileFromResourceAsStream(String fileName) {

        // The class loader that loaded the class
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        // The stream holding the file content
        if (inputStream == null) {
            throw new IllegalArgumentException("File not found! File: " + fileName);
        } else {
            return inputStream;
        }
    }

}
