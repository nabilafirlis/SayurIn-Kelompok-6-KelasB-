package com.example.sayurin.Model;

//Class ini digunakan untuk memanipulasi data pada SharedPreferences

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class Session{
    private static final String USERNAME_KEY = "key_username";
    private static final String TOKEN_KEY = "key_token";
    private static final String KEEP_USERNAME_KEY = "key_keep_username";
    public static final String KEY_CART = "cart";

    private SharedPreferences preferences;

    public Session(Context context) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
    }


    public void addCart(List<OrderModels> list){
        Gson gson = new Gson();
        String json = gson.toJson(list);
        preferences.edit().putString(KEY_CART, json).apply();
    }


    public List<OrderModels> getCart(){
        Gson gson = new Gson();
        String json = preferences.getString(KEY_CART, null);
        Type type = new TypeToken<List<OrderModels>>() {}.getType();
        return gson.fromJson(json, type);
    }

    public Session(SharedPreferences preferences) {
        this.preferences = preferences;
    }

    public boolean isKeepUsername() {
        return preferences.getBoolean(KEEP_USERNAME_KEY, false);
    }

    public String getUsername() {
        return preferences.getString(USERNAME_KEY, null);
    }

    public void setUsername(String username) {
        preferences.edit().putString(USERNAME_KEY, username)
                .apply();
    }

    public void setSession(String token) {
        preferences.edit().putString(TOKEN_KEY, token)
                .apply();
    }

    public boolean isLoggedIn() {
        String token = preferences.getString(TOKEN_KEY, null);
        return (token != null);
    }

    public boolean validate(String username, String password, String confirm) {
        if (username.equals("admin") && password.equals("admin") && confirm.equals("admin")) {
            setSession(username);
            return true;
        }
        return false;
    }

    public void logout() {
        preferences.edit().remove(TOKEN_KEY)
                .apply();
    }
}