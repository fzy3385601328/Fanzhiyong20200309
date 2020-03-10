package com.example.fanzhiyong20200309.presenter;


import com.example.fanzhiyong20200309.base.BasePresenter;
import com.example.fanzhiyong20200309.base.IBaseView;
import com.example.fanzhiyong20200309.contract.IHomeLoginContract;
import com.example.fanzhiyong20200309.model.IHomeLoginModel;

import java.util.HashMap;

public class IHomeLoginPresenter extends BasePresenter implements IHomeLoginContract.OnHomeLoginPresenter {

    IHomeLoginContract.OnHomeLoginModel model;

    public IHomeLoginPresenter(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void getModel() {
        model = new IHomeLoginModel();
    }

    @Override
    public void onLoginMothed(String url, HashMap<String, String> map, HashMap<String, String> head) {

        model.OnHomeLoginModel(url, map, head, new IHomeLoginContract.OnHomeLoginModel.LoginICallBack() {
            @Override
            public void onLoginSuccess(String json) {
                //调用登录接口成功的数据
                IBaseView iBaseView = getView();
                if (iBaseView instanceof IHomeLoginContract.OnHomeLoginView){
                    IHomeLoginContract.OnHomeLoginView iBaseView1 = (IHomeLoginContract.OnHomeLoginView) iBaseView;
                    //调用成功的数据
                    iBaseView1.onViewSuccess(json);
                }
            }

            @Override
            public void onLoginError(String msg) {
                IBaseView iBaseView = getView();
                if (iBaseView instanceof IHomeLoginContract.OnHomeLoginView){
                    IHomeLoginContract.OnHomeLoginView iBaseView1 = (IHomeLoginContract.OnHomeLoginView) iBaseView;
                    //调用失败的数据
                    iBaseView1.onViewError(msg);
                }
            }
        });
    }
}
