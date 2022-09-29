package com.example.studydemo.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SpUtil {
    public static void save(Context context,String key, String value ) {
        SharedPreferences.Editor editor = context.getSharedPreferences("orange_tree", Context.MODE_PRIVATE).edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String get(Context context,String key) {
        return context.getSharedPreferences("orange_tree", Context.MODE_PRIVATE).getString(key, "无结果");
    }
}
