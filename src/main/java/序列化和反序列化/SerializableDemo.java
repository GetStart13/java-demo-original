package 序列化和反序列化;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableDemo {
    private final Student student = new Student("driftBottle", 24);

    public static void main(String[] args) {
        SerializableDemo demo = new SerializableDemo();
        demo.serializable();
        demo.deSerializable();
    }

    /**
     * 序列化
     */
    void serializable() {
        try {
            // 文件输出流 -> 输出到 student.out
            FileOutputStream fileOutputStream = new FileOutputStream(".\\student.out");
            // 文件输出流转对象输出流
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            // 写入对象二进制流
            objectOutputStream.writeObject(student);
            objectOutputStream.flush();
            objectOutputStream.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 反序列化
     */
    void deSerializable() {
        try {
            FileInputStream fileInputStream = new FileInputStream("./student.out");
            Object object;
            try (ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
                object = objectInputStream.readObject();
            }
            Student deSerializable = null;
            if (object instanceof Student stu) {
                deSerializable = stu;
            }
            System.out.println(deSerializable);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
