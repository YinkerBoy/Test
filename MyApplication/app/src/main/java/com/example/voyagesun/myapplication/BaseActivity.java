package com.example.voyagesun.myapplication;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by voyageSun on 17/3/29.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView(savedInstanceState);
    }
    public abstract void initView(Bundle savedInstanceState);
}
