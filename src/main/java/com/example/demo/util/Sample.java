package com.example.demo.util;


import java.util.*;
import org.json.JSONObject;
import com.baidu.aip.ocr.AipOcr;
public class Sample {
    //设置APPID/AK/SK
    public static final String APP_ID = "58800362";
    public static final String API_KEY = "GffHfPIvUxUjst5zZkS6z4aB";
    public static final String SECRET_KEY = "2Vi7gzPEtRevDL5me7R8iBXd6wtrCY4Q";

    public static void main(String[] args) {
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        String path = "C:\\Users\\mxt\\Desktop\\codeforces.jpg";
        JSONObject res = client.basicGeneral(path, new HashMap<String, String>());
        System.out.println(res.toString(2));

    }
}