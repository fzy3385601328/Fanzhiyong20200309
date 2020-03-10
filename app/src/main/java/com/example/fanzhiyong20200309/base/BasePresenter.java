package com.example.fanzhiyong20200309.base;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends IBaseView> {

    //使用弱应用包裹泛型
    private WeakReference<V> weakReference;

    public BasePresenter(V v){
        //补全成员变量
        weakReference = new WeakReference<>(v);

        //创建抽象的方法
        getModel();
    }

    protected abstract void getModel();

    //绑定的方法
    public V getView(){
        //判断如果弱引用不为空
        if (weakReference!=null){
            return weakReference.get();
        }
        return null;
    }
    //创建解绑的方法
    protected void onDeatchView(){
        //判断如果弱引用不为空
        if (weakReference!=null){
            //清除并置空
            weakReference.clear();
            weakReference=null;
        }
    }
}
