package com.example.studydemo;

import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.studydemo.domain.vo.LoginBean;
import com.example.studydemo.domain.vo.LoginResponse;
import com.example.studydemo.util.OkHttpUtil;
import com.example.studydemo.util.SpUtil;
import com.google.gson.Gson;

import java.io.IOException;

public class LoginActivity extends AppCompatActivity {
    private Button submit, show;
    private EditText username, password;
    private TextView tokenText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Log.i("study", "[LoginActivity -> onCreate]");
        submit = findViewById(R.id.submit);
        submit.setOnClickListener(sendLoginRequest());
        show = findViewById(R.id.show_token);
        show.setOnClickListener(showToken());
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        username.addTextChangedListener(watchUsername());
        tokenText = findViewById(R.id.print_token);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("study", "[LoginActivity -> onStart]");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("study", "[LoginActivity -> onResume]");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("study", "[LoginActivity -> onPause]");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("study", "[LoginActivity -> onStop]");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("study", "[LoginActivity -> onDestroy]");
    }

    private TextWatcher watchUsername() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.i("usernameWatcher", "Edit username before:" + s);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.i("usernameWatcher", "Edit username content:" + s);
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.i("usernameWatcher", "Edit username after:" + s);
            }
        };
    }

    private View.OnClickListener sendLoginRequest() {
        // 监听器外的代码块会被设置监听器代码块初始化时直接执行
        return view -> {
            Log.i("username", username.getText().toString());
            Log.i("password", password.getText().toString());
            if (TextUtils.isEmpty(username.getText().toString()) || TextUtils.isEmpty(password.getText().toString())) {
                Toast.makeText(LoginActivity.this, "请输入用户名和密码", Toast.LENGTH_SHORT).show();
                return;
            }
            Gson gson = new Gson();
            String url = "xxxx",
                    body = gson.toJson(new LoginBean("xxxx", password.getText().toString()));
            OkHttpUtil.config(url, body);
            Toast.makeText(LoginActivity.this, "请求发送中", Toast.LENGTH_SHORT).show();
            new Thread() {
                @Override
                public void run() {
                    try {
                        String result = OkHttpUtil.post(url, body);
                        Log.i("post result", result);
                        LoginResponse loginResponse = gson.fromJson(result, LoginResponse.class);
                        SpUtil.save(LoginActivity.this, "token", loginResponse.toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                        Toast.makeText(LoginActivity.this, "请求失败,请检查网络状况", Toast.LENGTH_SHORT).show();
                    }
                }
            }.start();
        };
    }

    private View.OnClickListener showToken() {
        return view -> {
            tokenText.setText("正在加载...");
            tokenText.setText(SpUtil.get(LoginActivity.this, "token"));
        };
    }
}
