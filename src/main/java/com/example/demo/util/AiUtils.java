package com.example.demo.util;

import com.baidu.aip.imageclassify.AipImageClassify;
import com.baidu.aip.nlp.AipNlp;
import com.baidu.aip.ocr.AipOcr;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

public class AiUtils {
    public static String img(MultipartFile file) throws IOException {
        String APP_ID = "58801373";
        String API_KEY = "09j2VuwybmXOJN6nphpbZC4k";
        String SECRET_KEY = "SFvwrFS5EjmAMj91f2ZEeUQqklThm1iI";
        AipImageClassify client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        JSONObject res = client.advancedGeneral(file.getBytes(), new HashMap<String, String>());
        JSONObject result = res.getJSONArray("result").getJSONObject(0);

        return "这张图"+result.getDouble("score")*100+"%的可能是"+result.getString("root")+"-"+result.getString("keyword");
    }
    public static String word(MultipartFile file) throws IOException {
        String APP_ID = "58800362";
        String API_KEY = "GffHfPIvUxUjst5zZkS6z4aB";
        String SECRET_KEY = "2Vi7gzPEtRevDL5me7R8iBXd6wtrCY4Q";
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        JSONObject res = client.basicGeneral(file.getBytes(), new HashMap<String, String>());
        JSONArray jsonArray = res.getJSONArray("words_result");
        StringBuffer sb=new StringBuffer();
        for (int i=0;i<jsonArray.length();i++){
            sb.append(jsonArray.getJSONObject(i).getString("words")).append("\n");
        }
        return sb.toString();
    }
    public static String nlp(String text){
        // 初始化一个AipNlp
        String APP_ID = "58802065";
        String API_KEY = "GGobzazML8nshKto0AjMN2GI";
        String SECRET_KEY = "rMmwExIKMR8cksHArKM2G0yAROmyNSHa";
        AipNlp client = new AipNlp(APP_ID, API_KEY, SECRET_KEY);
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        // 调用接口
        JSONObject res = client.ecnet(text, null);
        String res1=res.getJSONObject("item").getString("correct_query");
        return res1;
    }

    public static void main(String []args){
        String text = "百度是一家人工只能公司!!!!!!";
        System.out.println(nlp(text));
    }
}
