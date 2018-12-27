package com.bw.com.zhangshuy.utils;

import android.content.Context;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpWorkUtils {

    public static String getHttpCont(Context context,String mpath,String mram){
        String message="";
        try {
            URL url=new URL(mpath);
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(5000);
            connection.setConnectTimeout(5000);
            int code = connection.getResponseCode();
            if (code==HttpURLConnection.HTTP_OK){
                InputStream stream = connection.getInputStream();
                byte[] bytes = new byte[512];
                ByteArrayOutputStream boat = new ByteArrayOutputStream();
                int len=0;
                while ((len=stream.read(bytes))!=-1){
                    boat.write(bytes,0,len);
                }
                message=boat.toString();
                stream.close();
                connection.connect();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }
}
