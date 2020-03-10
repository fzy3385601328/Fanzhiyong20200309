package com.example.fanzhiyong20200309.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.fanzhiyong20200309.base.App;

import java.util.HashMap;
import java.util.Map;

public class VolleyUtils {

    //创建请求队列
    RequestQueue eQueue;

    //创建私有的构造方法
    private VolleyUtils(){
        Volley.newRequestQueue(App.getmContext());
    }
    //创建静态的私有化的单例模式
    private static class SingleInstance{
        private static VolleyUtils volley = new VolleyUtils();
    }

    //创建公共的VolleyUtils类
    public static VolleyUtils getInstance(){
        return SingleInstance.volley;
    }


    //创建接口回调方法
    public interface ICallBack{
        //创建成功的方法
        void onSuccess(String json);
        //创建失败的方法
        void onError(String msg);

    }

    //判断是否有网
    public boolean isNetActivice(Context context){
        //获取网络判断
        ConnectivityManager coms = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = coms.getActiveNetworkInfo();
        //如果有网
        if (info!=null){
            return true;
        }
        return false;
    }

    //设置请求get方式
    public void doGet(String url, final ICallBack iCallBack){
        //创建字符串请求对象
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                 //调用成功的方法
                 iCallBack.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //调用失败的方法
                iCallBack.onError(error.getMessage());
            }
        });
        eQueue.add(stringRequest);
    }

    //Post请求
    public void doPost(String url, HashMap<String,String>map, HashMap<String,String>head, final ICallBack iCallBack){
        //创建字符串请求对象
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //Post请求调用成功的方法
                iCallBack.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Post请求调用失败的方法
                iCallBack.onError(error.getMessage());
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return super.getHeaders();
            }
        };
        //添加请求队列中
        eQueue.add(stringRequest);
    }


}
