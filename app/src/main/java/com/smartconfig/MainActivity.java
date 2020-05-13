package com.smartconfig;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        doLogic(true);
    }

    private void doLogic(boolean isUseGson) {
        if (isUseGson) {
            Gson gson = new Gson();
        } else {
            System.out.println("不使用Gson");
        }
    }
}
