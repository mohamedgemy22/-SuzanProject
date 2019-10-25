package com.enggemy22.myapplication;

import android.content.Context;

import java.util.HashMap;

public class SharedPreferences {
android.content.SharedPreferences sharedPreferences;
android.content.SharedPreferences.Editor  editor;
Context context;

    private static final String FILE_NAME="my_name";
    private static final String KEY_Name="user_name";
    private static final String KEY_password="password";
    private static final String KEY_status="status";

    public SharedPreferences(Context context) {
        this.context = context;
        sharedPreferences=context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
    }
    public void  saveData(String UserName, String Password, boolean Status){
        editor.putString(KEY_Name,UserName);
        editor.putString(KEY_password,Password);
        editor.putBoolean(KEY_status,Status);
        editor.apply();
    }

    public HashMap<String , String> getmap(){
        HashMap<String,String> map= new HashMap<>();
        map.put(KEY_Name,sharedPreferences.getString(KEY_Name,null));
        map.put(KEY_password,sharedPreferences.getString(KEY_password,null));
        return map;
    }

    public Boolean isLogin(){
        return sharedPreferences.getBoolean(KEY_status,false);
    }
}
