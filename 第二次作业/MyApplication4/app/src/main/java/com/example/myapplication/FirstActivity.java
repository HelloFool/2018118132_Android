package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("FirstActivity","Task id is"+getTaskId());
       // Log.d("FirstActivity",this.toString());
        setContentView(R.layout.first_layout);
        Button button1=(Button)findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
               // Toast.makeText(FirstActivity.this,"You clicked Button 1",
                     //   Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
                //startActivity(intent);
             //   Intent intent =new Intent(Intent.ACTION_VIEW);
           //     intent.setData(Uri.parse("http://www.baidu.com"));
            //    startActivity(intent);
               // Intent intent=new Intent(FirstActivity.this,FirstActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }
@Override
    protected void onRestart(){
        super.onRestart();
     //   Log.d("FirstActivity","onRestart");
}

}