package com.example.fanzhiyong20200309.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fanzhiyong20200309.R;
import com.example.fanzhiyong20200309.base.BaseActivity;
import com.example.fanzhiyong20200309.base.BasePresenter;
import com.example.fanzhiyong20200309.contract.IHomeLoginContract;
import com.example.fanzhiyong20200309.presenter.IHomeLoginPresenter;
import com.example.fanzhiyong20200309.utils.SPUtils;
import com.example.fanzhiyong20200309.utils.VolleyUtils;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends BaseActivity implements IHomeLoginContract.OnHomeLoginView,
View.OnClickListener{


    private EditText editPhone,editPass;
    private CheckBox checkBox;
    private Button btnRegister,btnLogin;
    private TextView hint;
    private IHomeLoginPresenter mPresenter;

    @Override
    protected BasePresenter initPresenter() {
        return mPresenter = new IHomeLoginPresenter(this);
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        //找控件
        editPhone = findViewById(R.id.edit_phone);
        editPass = findViewById(R.id.edit_pass);
        checkBox = findViewById(R.id.check_box);
        hint = findViewById(R.id.show_hint);
        btnRegister = findViewById(R.id.btn_register);
        btnLogin= findViewById(R.id.btn_login);

        btnRegister.setOnClickListener(this);

        btnLogin.setOnClickListener(this);
    }



    @Override
    protected void getData() {
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btn_register:
                doLogin();
                break;
            case R.id.btn_login:
                doRegister();
                break;
        }
    }

    private void doRegister() {
        //注册的按钮的思路基本与登录相同
        //获取用户输入的数据进行判断
        String phone = editPhone.getText().toString();
        String pwd = editPass.getText().toString();

        if (!TextUtils.isEmpty(phone)&&matchPass(phone)){
            //开始判断用户是否密码正确
            if (!TextUtils.isEmpty(pwd)){
                //正确的话进行是否联网的判断
                if (VolleyUtils.getInstance().isNetActivice(this)){
                    //将用户的数据存入到map集合中
                    HashMap<String,String> map = new HashMap<>();
                    map.put(phone,"phone");
                    map.put(pwd,"pwd");

                    //设置登录的链接
                    String LoginURl="http://mobile.bwstudent.com/small/user/v1/register";


                    mPresenter.onLoginMothed(LoginURl,map,new HashMap<String,String>());

                    Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "抱歉，您还没有连接网络", Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(this, "密码不正确，请重新输入", Toast.LENGTH_SHORT).show();
            }
        }else {
            //如果输入错误就提示用户重新进行输入
            Toast.makeText(this, "账户名错误，请重新输入", Toast.LENGTH_SHORT).show();
        }
    }

    private void doLogin() {
        //获取用户输入的数据进行判断
        String phone = editPhone.getText().toString();
        String pwd = editPass.getText().toString();

        if (!TextUtils.isEmpty(phone)&&matchPass(phone)){
           //开始判断用户是否密码正确
            if (!TextUtils.isEmpty(pwd)){
                //正确的话进行是否联网的判断
                if (VolleyUtils.getInstance().isNetActivice(this)){
                    //将用户的数据存入到map集合中
                    HashMap<String,String> map = new HashMap<>();
                    map.put(phone,"phone");
                    map.put(pwd,"pwd");

                    //设置登录的链接
                    String LoginURl="http://mobile.bwstudent.com/small/user/v1/login";

                    mPresenter.onLoginMothed(LoginURl,map,new HashMap<String,String>());

                    Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "抱歉，您还没有连接网络", Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(this, "密码不正确，请重新输入", Toast.LENGTH_SHORT).show();
            }
        }else {
            //如果输入错误就提示用户重新进行输入
            Toast.makeText(this, "账户名错误，请重新输入", Toast.LENGTH_SHORT).show();
        }

    }

    //给输入的手机号设置正则校验
    private boolean matchPass(String phone) {
        Pattern compile = Pattern.compile("^1////{10}$");
        Matcher matcher = compile.matcher(phone);

        return matcher.matches();
    }



    /*@Override
    public boolean onTouch(View v, MotionEvent event) {

        int id = v.getId();
        switch (id){
            case R.id.show_hint:
                if (event.getAction()==MotionEvent.ACTION_MOVE){
                    editPass.setText(HideReturnsTransformationMethod.getInstance());
                }else if (event.getAction()==MotionEvent.ACTION_UP){
                    editPass.setText(PasswordTransformationMethod.getInstance());
                }
                break;
        }
        return false;
    }*/

    @Override
    public void onViewSuccess(String json) {
        //打印成功的数据
        Log.w("LoginActivity",json);
        String phone = editPhone.getText().toString();
        String pwd = editPass.getText().toString();
        //点击登录后带着用户输入的数据进行跳转
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        //带着数据进行跳转
        intent.putExtra(phone,"phone");
        intent.putExtra(pwd,"pwd");

        //进行跳转
        startActivity(intent);

    }

    @Override
    public void onViewError(String msg) {
        //打印失败的数据
        Log.w("LoginActivity",msg);
    }


}
