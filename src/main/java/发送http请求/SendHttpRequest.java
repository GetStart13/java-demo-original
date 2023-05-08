package 发送http请求;

import java.io.IOException;
import java.util.Map;

public class SendHttpRequest {
    public static void main(String[] args) throws IOException {

        MyHttpClient myHttpClient = MyHttpClient.get("http://127.0.0.1:8083/springboot/http/get",
                Map.of("param", "1"));
        String resultGet = myHttpClient.getResponse();
        System.out.println(resultGet);


        MyHttpClient httpClient = MyHttpClient.post("http://127.0.0.1:8083/springboot/http/post",
                null,
                "[1,2,3,4,5]");
        String resultPost = httpClient.getResponse();
        System.out.println(resultPost);

    }

}
