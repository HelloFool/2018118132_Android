package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.adapter.FruitAdapter;
import com.example.tutth.Fruit;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {
    private List<Fruit> fruitLst=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Log.d("SecondActivity","Task id is"+getTaskId());
        setContentView(R.layout.second_layout);
        initFruits();
      //  ArrayAdapter<String>adapter=new ArrayAdapter<String>(
        //        SecondActivity.this,android.R.layout.simple_list_item_1,data);

        FruitAdapter adapter=new FruitAdapter(SecondActivity.this,R.layout.fruit_item,fruitLst);
        ListView listView=(ListView)findViewById(R.id.List_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Fruit fruit=fruitLst.get(position);
                Toast.makeText(SecondActivity.this,fruit.getBrith(),Toast.LENGTH_SHORT).show();
            }
        });
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }
        Button button2=(Button)findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SecondActivity.this,ThirdActivity.class);
                startActivity(intent);
            }
        });

    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
      //  Log.d("SecondActivity","onDestroy");
    }
   private void initFruits(){
        for (int i=0;i<2;i++){
            Fruit mother=new Fruit("mother","洗完碗再告诉你，我生日是7月13号",R.drawable.mother);
            fruitLst.add(mother);
            Fruit father=new Fruit("father","怎么会告诉你我生日是8月25号",R.drawable.father);
            fruitLst.add(father);
            Fruit sister=new Fruit("sister","老子生日1月18号",R.drawable.sister);
            fruitLst.add(sister);
            Fruit borther=new Fruit("brother","4月23，增胖节",R.drawable.borther);
            fruitLst.add(borther);
            Fruit me=new Fruit("me","wish today is 1/21",R.drawable.me);
            fruitLst.add(me);
        }
   }
}