package com.example.fanzhiyong20200309.contract;

import java.util.HashMap;

public interface IHomeLoginContract {


    //定义登录的契约类
    //V层的接口
    interface OnHomeLoginView{
        //定义成功的方法
        void onViewSuccess(String json);
        //定义失败的方法
        void onViewError(String msg);
    }

    //P层的接口
    interface OnHomeLoginPresenter{
        //定义普通的方法
        void onLoginMothed(String url, HashMap<String,String>map,HashMap<String,String>head);
    }

    //定义M层的接口
    interface OnHomeLoginModel{
        //定义M层的方法进行接口回调
        void OnHomeLoginModel(String url,HashMap<String,String>map,
                              HashMap<String,String>head,LoginICallBack iCallBack);

        //定义M层内部的接口
        interface LoginICallBack{
            //成功的方法
            void onLoginSuccess(String json);

            //失败的方法
            void onLoginError(String msg);
        }
    }
}
