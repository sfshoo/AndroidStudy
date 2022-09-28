package com.example.studydemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.studydemo.domain.vo.LoginBean;
import com.example.studydemo.util.OkHttpUtil;
import com.google.gson.Gson;

public class LoginActivity extends AppCompatActivity {
    private Button submit;
    private EditText username, password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Log.i("study", "[LoginActivity -> onCreate]");
        submit = findViewById(R.id.submit);
        submit.setOnClickListener(sendLoginRequest());
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

    private View.OnClickListener sendLoginRequest() {
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        Log.i("username", username.getText().toString());
        Log.i("password", password.getText().toString());
        String url = "xxxxx",
                body = new Gson().toJson(new LoginBean("xxxx", password.getText().toString()));
        return view -> OkHttpUtil.post(url, body);
    }
}
