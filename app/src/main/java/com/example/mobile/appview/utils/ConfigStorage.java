package com.example.mobile.appview.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class ConfigStorage {

    private final SharedPreferences pref;
    private final SharedPreferences.Editor editor;

    private static final String PREF_NAME = "ConfigStorage";
    private static final String KEY_LOGIN = "KEY_LOGIN";
    private static final String KEY_EMAIL = "KEY_EMAIL";
    private static final String KEY_PASSWORD = "KEY_PASSWORD";

    public static final String regEx = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b";

    public ConfigStorage(Context ctx){
        int PRIVATE_MODE = 0;
        pref = ctx.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
        editor.apply();
    }

    public void SetNotLogin(boolean Login){
        editor.putBoolean(KEY_LOGIN,Login);
        editor.commit();
    }

    public boolean isNotLogin(){
        return pref.getBoolean(KEY_LOGIN,true);
    }


    public void SetEmail(String User){
        editor.putString(KEY_EMAIL,User);
        editor.commit();
    }

    public String GetEmail(){
        return pref.getString(KEY_EMAIL,"");
    }

    public void SetPass(String Pass){
        editor.putString(KEY_PASSWORD,Pass);
        editor.commit();
    }

    public String GetPass(){
        return pref.getString(KEY_PASSWORD,"");
    }

}
