package Socket套接字;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class InternetServer {
    private final ServerSocket serverSocket;

    public InternetServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(10000);
    }

    public void run() {
        try {
            System.out.println("等待端口[" + serverSocket.getLocalPort() + "]的连接...");
            Socket server = serverSocket.accept();

            System.out.println("远程主机地址：" + server.getRemoteSocketAddress());

            DataInputStream clientInputStream = new DataInputStream(server.getInputStream());
            System.out.println("客户端信息：" + clientInputStream.readUTF());

            // 向客户端发送信息
            DataOutputStream responseStream = new DataOutputStream(server.getOutputStream());
            responseStream.writeUTF("我的 IP 是：" + server.getLocalSocketAddress());
            responseStream.writeUTF("我随后将关闭服务！");
            server.close();
        } catch (SocketTimeoutException s) {
            System.out.println("Socket timed out!");
            s.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int port = 8080;
        try {
            InternetServer internetServer = new InternetServer(port);
            internetServer.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
