package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  Log.d("FirstActivity","Task id is"+getTaskId());
       // Log.d("FirstActivity",this.toString());
        setContentView(R.layout.first_layout);
        Button button1=(Button)findViewById(R.id.button_1);
        editText=(EditText)findViewById(R.id.edit_text);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
               // Toast.makeText(FirstActivity.this,"You clicked Button 1",
                     //   Toast.LENGTH_SHORT).show();

               // Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
                //startActivity(intent);
                String inputText=editText.getText().toString();
              Intent intent =new Intent(Intent.ACTION_VIEW);
             intent.setData(Uri.parse(inputText));
            //    startActivity(intent);
               // Intent intent=new Intent(FirstActivity.this,FirstActivity.class);
                startActivity(intent);
            }
        });

        Button button_a=(Button)findViewById(R.id.button_a);
        button_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText(FirstActivity.this,"You clicked Button 1",
                //   Toast.LENGTH_SHORT).show();

                 Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
                startActivity(intent);
                //String inputText = editText.getText().toString();
                //Intent intent = new Intent(Intent.ACTION_VIEW);
                //intent.setData(Uri.parse(inputText));
                //startActivity(intent);
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
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "不是吧，你觉得我在骗你", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "失望值+9999", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }


    @Override
    protected void onRestart(){
        super.onRestart();
     //   Log.d("FirstActivity","onRestart");
}


}