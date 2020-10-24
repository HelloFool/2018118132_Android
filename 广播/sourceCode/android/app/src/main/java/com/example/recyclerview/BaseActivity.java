package com.example.recyclerview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.recyclerview.control.ActivityCollerctor;

public class BaseActivity extends AppCompatActivity {
         @Override
    protected void onCreate(Bundle savedInstanceState) {

             super.onCreate(savedInstanceState);
             ActivityCollerctor.addActivity(this);
         }
    @Override
    protected void onDestroy() {

        super.onDestroy();
        ActivityCollerctor.removeActivity(this);
    }
}
