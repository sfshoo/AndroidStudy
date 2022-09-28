package com.example.studydemo.util;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpUtil {
    private static final MediaType JSON = MediaType.parse("application/json;charset=utf-8");

    public static void post(String url, String body) {
        Request request = new Request.Builder().url(url).post(RequestBody.create(body, JSON)).build();
        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.e("net.OkHttpUtil.post", "Request Failed");
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                Log.e("net.OkHttpUtil.post", "Request Failed :" + response.body().string());
            }
        });
    }
}
