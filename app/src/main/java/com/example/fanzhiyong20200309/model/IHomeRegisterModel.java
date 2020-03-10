package com.example.fanzhiyong20200309.model;

import com.example.fanzhiyong20200309.contract.IHomeRegisterContract;
import com.example.fanzhiyong20200309.utils.VolleyUtils;

import java.util.HashMap;

public class IHomeRegisterModel implements IHomeRegisterContract.OnHomeRegisterModel {


    @Override
    public void OnHomeRegisterModel(String url, HashMap<String, String> map, HashMap<String, String> head, final onRegisterICallBack iCallBack) {
        VolleyUtils.getInstance().doPost(url, map, head, new VolleyUtils.ICallBack() {
            @Override
            public void onSuccess(String json) {
                //成功的方法
                 iCallBack.onRegisterSuccess(json);
            }

            @Override
            public void onError(String msg) {
                //失败方法
                iCallBack.onRegisterError(msg);
            }
        });
    }
}
