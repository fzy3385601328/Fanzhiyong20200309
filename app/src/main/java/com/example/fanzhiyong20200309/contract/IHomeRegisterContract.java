package com.example.fanzhiyong20200309.contract;

import java.util.HashMap;

public interface IHomeRegisterContract {

    //定义登录的契约类
    //V层的接口
    interface OnHomeRegisterView{
        //定义成功的方法
        void onViewSuccess(String json);
        //定义失败的方法
        void onViewError(String msg);
    }

    //P层的接口
    interface OnHomeRegisterPresenter{
        //定义普通的方法
        void onRegisterMothed(String url, HashMap<String,String> map, HashMap<String,String>head);
    }

    //定义M层的接口
    interface OnHomeRegisterModel{
        //定义M层的方法进行接口回调
        void OnHomeRegisterModel(String url, HashMap<String,String>map,
                              HashMap<String,String>head, onRegisterICallBack iCallBack);

        //定义M层内部的接口
        interface onRegisterICallBack{
            //成功的方法
            void onRegisterSuccess(String json);

            //失败的方法
            void onRegisterError(String msg);
        }
    }
}
