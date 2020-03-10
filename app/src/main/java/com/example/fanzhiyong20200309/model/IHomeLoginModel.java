package com.example.fanzhiyong20200309.model;

import com.example.fanzhiyong20200309.contract.IHomeLoginContract;
import com.example.fanzhiyong20200309.utils.VolleyUtils;

import java.util.HashMap;

public class IHomeLoginModel implements IHomeLoginContract.OnHomeLoginModel {

    //这里直接可以调用VolleyUtils工具类
    @Override
    public void OnHomeLoginModel(String url, HashMap<String, String> map, HashMap<String, String> head, final LoginICallBack iCallBack) {

        VolleyUtils.getInstance().doPost(url, map, head, new VolleyUtils.ICallBack() {
            @Override
            public void onSuccess(String json) {
                //调用登录成功的方法
                iCallBack.onLoginSuccess(json);
            }

            @Override
            public void onError(String msg) {
                 //调用登录失败的方法
                iCallBack.onLoginError(msg);
            }
        });
    }
}
