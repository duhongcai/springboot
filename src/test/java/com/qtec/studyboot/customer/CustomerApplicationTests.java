package com.qtec.studyboot.customer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerApplicationTests {

    @Test
    public void testGet() {
        try {
            // 1 准备参数（路径 + 参数）get 请求可以拼接参数 post不行
            String uri = "http://trade.zgyxcgw.cn:9092/tradeInterface/v1/testConnection";
            String params1 = "logtime=" + new Date().getTime();
            String params2 = "orgUserName="+"duhc";
            URL requestUri = new URL(uri + "?" + params1+"&"+params2);
            // 2 打开连接
            HttpURLConnection connection = (HttpURLConnection) requestUri.openConnection();
            // 3 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            //  4 建立实际连接
            connection.connect();
            // 5 获取返回值
            // 5.1获取状态码 对于http请求 如果是200则表示该次请求正常
            System.out.println("========================获取请求状态码========================");
            System.out.println( connection.getResponseCode());
            // 5.2 获取报文内容
            System.out.println("========================报文内容========================");
            InputStream inputStream = connection.getInputStream();
            byte[] b = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int len = 0;
            while (true) {
                len = inputStream.read(b);
                if (len == -1) {
                    break;
                }
                byteArrayOutputStream.write(b, 0, len);
            }
            String response = byteArrayOutputStream.toString();
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPost() {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
            try{
                // 1 拼写请求
                String url =  "http://trade.zgyxcgw.cn:9092/tradeInterface/v1/companyInterface/drug/purchaseOrder/getOrder";
                URL requestUrl = new URL(url);
                HttpURLConnection connection = (HttpURLConnection) requestUrl.openConnection();
                // 2 设置请求方式
                connection.setRequestMethod("POST");
                // 3 设置通用的请求属性
                connection.setRequestProperty("accept", "*/*");
                connection.setRequestProperty("connection", "Keep-Alive");
                connection.setRequestProperty("user-agent",
                        "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
                connection.setDoOutput(true);
                connection.setDoInput(true);
                out = new PrintWriter(connection.getOutputStream());

                // 4 设置参数
                String params1 = "accessToken=abc";
                String params2 = "startTime=2016-1-1 00:00:00";
                String params3 = "endTime=2017-1-1 00:00:00";
                String params4 = "currentPageNumber=1";
                out.print(params1+"&"+params2+"&"+params3+"&"+params4);

                // 5  flush输出流的缓冲
                out.flush();
                //获取状态码
                System.out.println("========================获取请求状态码========================");
                System.out.println(connection.getResponseCode());
                // 6 定义BufferedReader输入流来读取URL的响应
                in = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                String line;
                while ((line = in.readLine()) != null) {
                    result += line;
                }
                // 7 获取内容
                System.out.println("========================报文内容========================");
            System.out.println(result);
            }catch (Exception e){
                e.printStackTrace();
            }
    }

}
