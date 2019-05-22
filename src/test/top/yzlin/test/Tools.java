package top.yzlin.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;


public class Tools {


    public static String sendGet(String url, String param) {
        return sendGet(url, param, conn -> {
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
        });
    }


    /**
     * 获取GET数据
     */
    public static String sendGet(String url, String param, SetConnection connections) {
        HttpURLConnection connection;
        try {
            connection = (HttpURLConnection) new URL(url + "?" + param).openConnection();
            connection.setConnectTimeout(30000);
            connections.setConnection(connection);
            HttpURLConnection.setFollowRedirects(true);
            connection.setInstanceFollowRedirects(false);
            connection.connect();
        } catch (IOException e) {
            e.printStackTrace();
            return Tools.sendGet(url, param, connections);
        }
        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf8"))) {
            String line;
            StringBuilder result = new StringBuilder();
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
            return result.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return Tools.sendGet(url, param, connections);
        }
    }


    /**
     * post数据
     *
     * @param url   网址
     * @param param 参数
     * @return 数据
     */
    public static String sendPost(String url, String param) {
        return sendPost(url, param, conn -> {
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
        });
    }

    /**
     * 获取post数据，可自定义头文件
     *
     * @param url   网址
     * @param param 参数
     * @param m     用map图来添加各项数据
     * @return 数据
     */
    public static String sendPost(String url, String param, Map<String, String> m) {
        return sendPost(url, param, conn -> {
            for (String key : m.keySet()) {
                conn.setRequestProperty(key, m.get(key));
            }
        });
    }


    /**
     * 获取post数据，可自定义头文件与异常处理方法
     *
     * @param url         网址
     * @param param       参数
     * @param connections 头文件接口
     * @return 数据
     */
    public static String sendPost(String url, String param, SetConnection connections) {
        URLConnection conn;
        try {
            conn = new URL(url).openConnection();
            conn.setConnectTimeout(30000);
            connections.setConnection(conn);
            conn.setDoOutput(true);
            conn.setDoInput(true);
        } catch (IOException e) {
            e.printStackTrace();
            return Tools.sendPost(url, param, connections);
        }
        try (PrintWriter out = new PrintWriter(conn.getOutputStream())) {
            out.print(param);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
            return Tools.sendPost(url, param, connections);
        }
        try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf8"))) {
            String line;
            StringBuilder result = new StringBuilder();
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
            return result.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return Tools.sendPost(url, param, connections);
        }
    }


}
