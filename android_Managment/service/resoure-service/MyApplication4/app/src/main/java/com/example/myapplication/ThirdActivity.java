package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.servicetest.MyService;


public class ThirdActivity extends AppCompatActivity implements View.OnClickListener{
    DrawerLayout drawerLayout;
    Button btn, btn2;

    public static final int UPDATE_TEXT=1;
    private TextView text;
    private Handler handler=new Handler(){
        public void handleMessage(Message msg){
            switch (msg.what){
                case UPDATE_TEXT:
                    text.setText("Nice to meet you");
                    break;
                default:
                    break;
            }
        }
    };
    private MyService.DownloadBinder downloadBinder;
    private ServiceConnection connection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder service) {
            downloadBinder=(MyService.DownloadBinder) service;
            downloadBinder.startDownload();
            downloadBinder.getProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_layout);
        drawerLayout = (DrawerLayout) findViewById(R.id.draw);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }
        btn = (Button) findViewById(R.id.btn);
        text=(TextView)findViewById(R.id.text);
        btn2 = (Button) findViewById(R.id.btn2);
        //实现方法一：定义好xml文件后手指侧滑就可以拉出侧滑界面了
        // 实现方法二：定义好xml文件后，在java文件中添加点击事件也可以拉出侧滑菜单，代码如下：

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            { new Thread(new Runnable(){
                @Override
                public void run(){
                    Message message=new Message();
                    message.what=UPDATE_TEXT;
                    handler.sendMessage(message);
                }
            }).start();
            }
        });
        // 点击侧滑界面中的按钮缩回侧滑界面
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.closeDrawer(Gravity.LEFT);
            } });
        Button startService=(Button)findViewById(R.id.start_service);
        startService.setOnClickListener(this);
        Button stopService=(Button)findViewById(R.id.stop_service);
        stopService.setOnClickListener(this);
        Button bindService=(Button)findViewById(R.id.bind_service);
        bindService.setOnClickListener(this);
        Button unbindService=(Button)findViewById(R.id.unbind_service);
        unbindService.setOnClickListener(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.setting:
                Toast.makeText(this, "222223", Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
            default:
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start_service:
                Intent startIntent=new Intent(this, MyService.class);
                startService(startIntent);
                break;
            case R.id.stop_service:
                Intent stopIntent=new Intent(this,MyService.class);
                stopService(stopIntent);
                break;
            case R.id.bind_service:
                Intent bindIntent=new Intent(this,MyService.class);
                bindService(bindIntent,connection,BIND_AUTO_CREATE);
                break;
            case R.id.unbind_service:
                unbindService(connection);
                break;
            default:
                break;
        }
    }
}
