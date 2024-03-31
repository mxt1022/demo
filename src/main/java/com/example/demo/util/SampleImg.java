package com.example.demo.util;


import com.baidu.aip.imageclassify.AipImageClassify;
import org.json.JSONObject;

import java.util.HashMap;

public class SampleImg {
    //设置APPID/AK/SK
    public static final String APP_ID = "58801373";
    public static final String API_KEY = "09j2VuwybmXOJN6nphpbZC4k";
    public static final String SECRET_KEY = "SFvwrFS5EjmAMj91f2ZEeUQqklThm1iI";

    public static void main(String[] args) {
        // 初始化一个AipImageClassify
        String APP_ID = "58801373";
        String API_KEY = "09j2VuwybmXOJN6nphpbZC4k";
        String SECRET_KEY = "SFvwrFS5EjmAMj91f2ZEeUQqklThm1iI";
        AipImageClassify client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 调用接口
        String path = "C:\\Users\\mxt\\Desktop\\codeforces.jpg";
        JSONObject res = client.advancedGeneral(path, new HashMap<String, String>());
        System.out.println(res.toString(2));

    }
}