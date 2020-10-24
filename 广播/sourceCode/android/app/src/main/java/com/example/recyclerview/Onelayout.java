package com.example.recyclerview;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Onelayout extends AppCompatActivity {

     private IntentFilter intentFilter;
     private NetworkChangeReceiver networkChangeReceiver;
    private List<Fruit> fruitList = new ArrayList<Fruit>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onelayout);
        Button button=(Button)findViewById(R.id.send);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent("com.example.recycleview.MY_BROADCAST");
                sendBroadcast(intent);
            }
        });
        intentFilter=new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceiver =new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver,intentFilter);


        initFruits();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view1);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter adapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);
    }
    @Override
    protected void onDestroy() {

        super.onDestroy();
        unregisterReceiver(networkChangeReceiver);
    }
    private void initFruits() {
           for(int i=1;i<3;i++) {
               Fruit apple = new Fruit("这是彭欢迎的老弟，平时看起来傻傻的，我" +
                       "一开始以为是错觉，没想到还真是傻", R.drawable.apple_pic);
               fruitList.add(apple);
               Fruit banana = new Fruit("彭欢迎他爸，嗯，没什么好说的", R.drawable.banana_pic);
               fruitList.add(banana);
               Fruit orange = new Fruit("彭欢迎她自己，唯一让我两张图挑一个的角色", R.drawable.orange_pic);
               fruitList.add(orange);
               Fruit watermelon = new Fruit("这个就老惨了，一张图都没给，只能拿这个头像将就一下了，他是彭欢迎她妈", R.drawable.watermelon_pic);
               fruitList.add(watermelon);
               Fruit pear = new Fruit("这个大头是彭欢迎她姐，应该独占餐桌三分之一的男人", R.drawable.pear_pic);
               fruitList.add(pear);

           }
    }

    private String getRandomLengthName(String name) {
        Random random = new Random();
        int length = random.nextInt(20) + 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(name);
        }
        return builder.toString();
    }

    class NetworkChangeReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager=(ConnectivityManager)
                    getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo =connectivityManager.getActiveNetworkInfo();
            if(networkInfo!=null && networkInfo.isAvailable()){
                Toast.makeText(context, "你正在使用移动网络", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(context, "没网我很难替你办事", Toast.LENGTH_SHORT).show();
            }
        }
    }


}
