##                                       **实验报告五**

**实验题目：安卓的数据的持久化技术**
**实验目的：了解和运用安卓数据持久化技术**
**实验过程：**
**安卓系统提供了3种方式用于简单的实现数据的持久化功能，有文件存储，SharedPreferences存储，以及数据库存储**

**（1）文件存储**

实验主要代码



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


​    
​    public String load(){
​        FileInputStream in=null;
​        BufferedReader reader=null;
​        StringBuilder context=new StringBuilder();
​        try {
​            in=openFileInput("accountData");
​            reader =new BufferedReader(new InputStreamReader(in));
​            String line="";
​            while((line=reader.readLine())!=null){
​                context.append(line);
​            }
​        } catch (FileNotFoundException e) {
​            e.printStackTrace();
​        } catch (IOException e) {
​            e.printStackTrace();
​        }finally {
​            if(reader!=null){
​                try {
​                    reader.close();
​                } catch (IOException e) {
​                    e.printStackTrace();
​                }
​            }
​        }
​        return context.toString();
​    }
**实验结果与分析**

![](https://github.com/HelloFool/2018118132_Android/blob/master/广播/photo/c364963e84b55cb72acfd18f0bf240c.png) )

 ![https://github.com/HelloFool/2018118132_Android/blob/master/%E7%AC%AC%E4%BA%94%E6%AC%A1%E4%BD%9C%E4%B8%9A/result/result.png](https://github.com/HelloFool/2018118132_Android/blob/master/第五次作业/result/result.png) 

运行程序时需要输入登录账户和密码，这里对账号实现数据文件持久化操作，第一次输入账号后，退出程序重新打开，可以看到

用户的账户被保存，下一次只输入密码即可

**(2)SharedPreferences存储**

通过)SharedPreferences对象和editor对象实现对数据的存储操作，这里通过记住用户密码来实现

主要代码

读：

    boolean isRemember = pref.getBoolean("remember_password", false);
        if (isRemember) {
            String account = pref.getString("account", "");
            String password = pref.getString("password", "");
            accountEdit.setText(account);
            passwordEdit.setText(password);
            rememberPass.setChecked(true);
        }

写：
                        editor.putBoolean("remember_password", true);
                        editor.putString("account", account);
                        editor.putString("password", password);



**运行结果**

![] (https://github.com/HelloFool/2018118132_Android/blob/master/第五次作业/result/Shared.png) 

**(3)数据库存储**

数据库存储现在流行的方式有SQLite数据库存储和LitePal数据库存储

*SQLite数据库存储*

这是一个轻量级的关系型数据库，运算快，占用资源少，遵守数据库的ACID事务，它的增删查改通过Helper帮助类实现

*LitePal数据库存储*

其中LitePal数据库存储是基于对象的关系映射存储的，对SQLite数据库存储进行封装，将程序员从繁杂的SQL语句中解脱出来，精心开发代码实现，代码更加简洁

***LitePal数据库存储*实验**

定义按钮实现数据的增删查改

主要代码



         //增
    
    LitePal.getDatabase();
      Button button=(Button)findViewById(R.id.send);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    LitePal.getDatabase();
                    Fruit fruit=new Fruit();
                    fruit.setImageId(R.drawable.orange_pic);
                    fruit.setName("I am cat");
                    fruit.save();
                    Intent intent=new Intent("com.example.recycleview.MY_BROADCAST");
                    sendBroadcast(intent);
                }
            });
    
    //改
         Button button2=(Button)findViewById(R.id.update);
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Fruit fruit=new Fruit();
                    fruit.setImageId(R.drawable.pear_pic);
                    fruit.updateAll("name=?","I am cat");   }
        });
        //删
        Button button3=(Button)findViewById(R.id.delete);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LitePal.deleteAll(Fruit.class,"id>?","9");
            }
        });//查
        Button button4=(Button)findViewById(R.id.query);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Fruit>fruits= LitePal.findAll(Fruit.class);
                for(Fruit f:fruits){
                    System.out.println("****My id is "+f.getId());
                    System.out.println("My words are "+f.getName()+"**");
                    System.out.println(f.getImageId());
                }
            }
        });
**实验结果**

![](https://github.com/HelloFool/2018118132_Android/blob/master/第五次作业/result/dataBase.png) 



#### 总结

**这次实验我学会使用数据的持久化技术进行数据的保存，分别对文件存储，SharedPreferences存储，以及数据库存储进行操作，**

**学会对关键数据的持久化，文件适用于简单的文本数据，SharedPreferences适用于存储键值对数据，数据库存储适用于复杂的数**

**据类型，收获良多，但仅仅掌握书本上的数据存储操作是远远不够的，持久化技术更为精细的用法要在未来项目实际需求来继续**

**探索和学习。**