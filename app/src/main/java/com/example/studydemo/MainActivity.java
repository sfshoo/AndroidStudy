package com.example.studydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button jumpToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("study", "[MainActivity -> onCreate]");
        jumpToLogin = findViewById(R.id.jump_to_login);
        jumpToLogin.setOnClickListener(jumpToLogin());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("study", "[MainActivity -> onCreate]");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("study", "[MainActivity -> onStart]");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("study", "[MainActivity -> onPause]");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("study", "[MainActivity -> onStop]");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("study", "[MainActivity -> onDestroy]");
    }

    private View.OnClickListener jumpToLogin() {
        return view -> {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        };
    }
}