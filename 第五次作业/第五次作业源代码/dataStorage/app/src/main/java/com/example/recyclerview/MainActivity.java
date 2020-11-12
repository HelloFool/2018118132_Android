package com.example.recyclerview;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;
        import androidx.recyclerview.widget.StaggeredGridLayoutManager;

        import android.content.BroadcastReceiver;
        import android.content.Context;
        import android.content.Intent;
        import android.net.ConnectivityManager;
        import android.net.NetworkInfo;
        import android.os.Bundle;
        import android.text.TextUtils;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.LinearLayout;
        import android.widget.Toast;

        import java.io.BufferedReader;
        import java.io.BufferedWriter;
        import java.io.FileInputStream;
        import java.io.FileNotFoundException;
        import java.io.FileOutputStream;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.io.OutputStreamWriter;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.Random;

public class MainActivity extends BaseActivity {

    private EditText accountEdit;
    private EditText passwordEdit;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        accountEdit=(EditText)findViewById(R.id.account);
        passwordEdit=(EditText)findViewById(R.id.password);
        String inputText=load();
        if(!TextUtils.isEmpty(inputText)){
            accountEdit.setText(inputText);
            accountEdit.setSelection(inputText.length());
            Toast.makeText(this,"welcoome",Toast.LENGTH_SHORT).show();
        }
        login =(Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String account=accountEdit.getText().toString();
                String password=passwordEdit.getText().toString();
                if(((account.equals("PengHuanYing"))||(account.equals("彭欢迎")))&&password.equals("1121")){
                    Intent intent=new Intent(MainActivity.this,Onelayout.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(MainActivity.this,"account or password is invalid",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    protected void onDestry() throws IOException {
        super.onDestroy();
        String inputText=accountEdit.getText().toString();
        save(inputText);
    }
    public void save(String inputText) throws IOException {
        FileOutputStream out=null;
        BufferedWriter writer=null;
        try {
            out=openFileOutput("accountData",Context.MODE_APPEND);
            writer=new BufferedWriter(new OutputStreamWriter((out)));
            writer.write(inputText);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                if(writer!=null){
                    writer.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }
    public String load(){
        FileInputStream in=null;
        BufferedReader reader=null;
        StringBuilder context=new StringBuilder();
        try {
            in=openFileInput("accountData");
            reader =new BufferedReader(new InputStreamReader(in));
            String line="";
            while((line=reader.readLine())!=null){
                context.append(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return context.toString();
    }

    }
