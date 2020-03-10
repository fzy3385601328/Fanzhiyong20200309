package com.example.fanzhiyong20200309.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SPUtils {

   private static final String USERINFO_KEY_USERID = "USER_ID";
   private static final String USERINFO_KEY_SESSIONID="SESSIONID";
   private static final String USERINFO_KEY_NICK_NAME = "NICK_NAME";
   private static final String USERINFO_KEY_PHONE="PHONE";
   private static final String USERINFO_KEY_HEADPIC="HEADPIC";
   private static final String USERINFO_KEY_SEX = "SEX";
   private static final String USERINFO_KEY_ISCHECKED="ISCHECKED";

   public void doString(Context context,String name, String key, String value){
       SharedPreferences sp = context.getSharedPreferences(name,Context.MODE_PRIVATE);
       SharedPreferences.Editor edit = sp.edit();
       edit.putString(key,value);
       edit.commit();

   }

   public void getString(Context context,String name,String key){
       SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
       sp.getString(key, "");


   }

    public void doBoolean(Context context,String name, String key, String value){
        SharedPreferences sp = context.getSharedPreferences(name,Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putBoolean(key, Boolean.parseBoolean(value));
        edit.commit();
    }

    public void getLogin(Context context, String name, String key){
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        sp.getBoolean(key, false);



    }



}
