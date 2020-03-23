package com.bw.nierunzhang20200323.util;

import android.content.Context;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * <p>文件描述：<p>
 * <p>作者：聂润璋<p>
 * <p>创建时间：2020.3.23<p>
 * <p>更改时间：2020.3.23<p>
 */
public class NetUtils {
   // b)使用单例模式封装NetUtils网络工具类
   // c)封装网络判断的方法，可以获取有网、无网、wifi、4G
   // d)封装获取网络数据的方法，并使用该方法完成接口数据的请求
    //e)封装获取网络图片的方法，并使用该方法完成图片的请求
    private NetUtils(){};

    public static NetUtils getInstance() {
        return NET_UTIL;
    }
    private static  final NetUtils NET_UTIL=new NetUtils();
    public boolean hasNet(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        final NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo!=null&&activeNetworkInfo.isAvailable()){
            return true;
        }else {
            return false;
        }

    }

    private String ioToString(InputStream inputStream) throws IOException {
        final byte[] bytes = new byte[1024];
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int len=-1;
        while ((len=inputStream.read(bytes))!=-1){
            byteArrayOutputStream.write(bytes, 0, len);
        }
        final byte[] bytes1 = byteArrayOutputStream.toByteArray();
        final String json = new String(bytes1);
        return json;
    }
    private Bitmap ioToBitmap(InputStream inputStream){
        return BitmapFactory.decodeStream(inputStream);
    }
    public String doGet(String httpUrl){
        try {
            final URL url = new URL(httpUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode()==200){
                final InputStream inputStream = httpURLConnection.getInputStream();
                final String json = ioToString(inputStream);
                Log.e("TAG", json);
                return json;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public Bitmap doGetPhoto(String photo){
        try {
            final URL url = new URL(photo);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode()==200){
                final InputStream inputStream = httpURLConnection.getInputStream();
                final Bitmap bitmap = ioToBitmap(inputStream);
             return bitmap;

            }
        } catch (Exception e) {
            e.printStackTrace();

        }
       return null ;
    }

}
