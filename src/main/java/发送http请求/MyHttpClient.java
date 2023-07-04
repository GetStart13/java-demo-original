package 发送http请求;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * <p> 2023/5/17 </p>
 * 步骤：
 * <br> 1、构建 URL 对象，打开连接
 * <br> 2、（GET 请求可忽略）设置请求方法、设置请求属性（请求头）、设置 URL 写出为 true、写入请求体参数
 * <br> 3、读取请求响应，读取输入流
 * <br> 4、关闭连接
 *
 * @author Fqq
 */
public class MyHttpClient {

    /**
     * Http 连接
     */
    private final HttpURLConnection connection;

    /**
     * 构建 GET httpClient 并建立连接
     *
     * @param url    URL
     * @param params 参数
     */
    private MyHttpClient(String url, Map<String, String> params) throws IOException {
        connection = buildConnection(url, params);
    }

    /**
     * 构建 POST httpClient 并建立连接
     *
     * @param url      URL
     * @param params   路径参数
     * @param jsonBody 请求体参数
     */
    private MyHttpClient(String url, Map<String, String> params, String jsonBody) throws IOException {
        connection = buildConnection(url, params);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json;charset=utf-8");
        // 允许连接写出数据，也可以允许连接写入数据：connection.setDoInput(true);。
        connection.setDoOutput(true);

        try (DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream())) {
            outputStream.writeBytes(jsonBody);
            outputStream.flush();
        }
    }

    /**
     * 发送 GET 请求
     *
     * @param url    URL
     * @param params 请求参数
     * @return 自定义 http 客户端
     */
    public static MyHttpClient get(String url, Map<String, String> params) throws IOException {
        return new MyHttpClient(url, params);
    }

    /**
     * 发送 post 请求
     *
     * @param url      URL
     * @param params   请求参数
     * @param jsonBody 请求体
     * @return 自定义客户端
     */
    public static MyHttpClient post(String url, Map<String, String> params, String jsonBody) throws IOException {
        return new MyHttpClient(url, params, jsonBody);
    }

    /**
     * 创建 http 连接
     *
     * @param url    请求路径
     * @param params 请求参数，可以为空
     * @return http 连接
     */
    private HttpURLConnection buildConnection(String url, Map<String, String> params) throws IOException {
        String requestParams = getParamsString(params);
        return (HttpURLConnection) new URL(requestParams != null ? url + "?" + requestParams : url).openConnection();
    }

    /**
     * 获取 http 请求响应结果
     *
     * @return 响应结果，失败抛异常
     */
    public String getResponse() throws IOException {
        int responseCode = connection.getResponseCode();
        if (responseCode >= HttpURLConnection.HTTP_OK && responseCode < HttpURLConnection.HTTP_MULT_CHOICE) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();

            connection.disconnect();
            return response.toString();
        } else {
            connection.disconnect();
            InputStream errorStream = connection.getErrorStream();
            if (errorStream == null) {
                throw new ConnectException("request fail");
            }
            throw new ConnectException(new String(errorStream.readAllBytes(), StandardCharsets.UTF_8));
        }
    }

    /**
     * 拼接请求参数
     *
     * @param params 参数 map
     * @return 请求参数字符串
     */
    public static String getParamsString(Map<String, String> params) {
        if (params == null || params.isEmpty()) {
            return null;
        }

        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, String> entry : params.entrySet()) {
            result.append(URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8));
            result.append("&");
        }

        String resultString = result.toString();
        return resultString.length() > 0
                ? resultString.substring(0, resultString.length() - 1)
                : resultString;
    }
}
