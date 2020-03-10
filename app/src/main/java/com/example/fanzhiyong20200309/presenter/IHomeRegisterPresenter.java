package com.example.fanzhiyong20200309.presenter;


import com.example.fanzhiyong20200309.base.BasePresenter;
import com.example.fanzhiyong20200309.base.IBaseView;
import com.example.fanzhiyong20200309.contract.IHomeRegisterContract;
import com.example.fanzhiyong20200309.model.IHomeRegisterModel;

import java.util.HashMap;

public class IHomeRegisterPresenter extends BasePresenter implements IHomeRegisterContract.OnHomeRegisterPresenter {
    IHomeRegisterContract.OnHomeRegisterModel model;

    public IHomeRegisterPresenter(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void getModel() {
        model = new IHomeRegisterModel();
    }

    @Override
    public void onRegisterMothed(String url, HashMap<String, String> map, HashMap<String, String> head) {

        model.OnHomeRegisterModel(url, map, head, new IHomeRegisterContract.OnHomeRegisterModel.onRegisterICallBack() {
            @Override
            public void onRegisterSuccess(String json) {
                //在P层中调用成功的方法
                IBaseView iBaseView = getView();

                if (iBaseView instanceof IHomeRegisterContract.OnHomeRegisterView){
                    IHomeRegisterContract.OnHomeRegisterView iBaseView1 = (IHomeRegisterContract.OnHomeRegisterView) iBaseView;
                    iBaseView1.onViewSuccess(json);
                }
            }

            @Override
            public void onRegisterError(String msg) {
                //在P层中调用失败的方法
                IBaseView iBaseView = getView();
                if (iBaseView instanceof IHomeRegisterContract.OnHomeRegisterView){
                    IHomeRegisterContract.OnHomeRegisterView iBaseView1 = (IHomeRegisterContract.OnHomeRegisterView) iBaseView;
                    //调用失败的数据
                    iBaseView1.onViewError(msg);
                }
            }
        });
    }
}
