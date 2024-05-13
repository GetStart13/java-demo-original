package Socket套接字;

import java.io.*;
import java.net.Socket;

public class InternetClient {
    public static void main(String[] args) {
        String serverName = "localhost";
        int port = 8080;
        try {
            System.out.println("连接到主机：" + serverName + " ，端口号：" + port);
            try (Socket client = new Socket(serverName, port)) {
                System.out.println("远程主机地址：" + client.getRemoteSocketAddress());

                // socket 输出流
                OutputStream sendToServer = client.getOutputStream();
                // socket 数据输出流
                DataOutputStream sendStream = new DataOutputStream(sendToServer);
                // 写入信息
                sendStream.writeUTF("信息来自：" + client.getLocalSocketAddress());

                // socket 输入流
                InputStream inputStreamFromServer = client.getInputStream();
                // 读取服务端响应信息
                DataInputStream responseStream = new DataInputStream(inputStreamFromServer);
                // responseStream.readUTF() 依次读取服务端响应信息，如果读取次数超出服务端响应次数将报错
                System.out.println("服务器响应信息 1： " + responseStream.readUTF());
                System.out.println("服务器响应信息 2： " + responseStream.readUTF());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
