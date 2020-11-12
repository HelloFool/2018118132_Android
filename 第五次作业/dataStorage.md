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
**实验结果与分析**

![](https://github.com/HelloFool/2018118132_Android/blob/master/广播/photo/c364963e84b55cb72acfd18f0bf240c.png) )

 ![https://github.com/HelloFool/2018118132_Android/blob/master/%E7%AC%AC%E4%BA%94%E6%AC%A1%E4%BD%9C%E4%B8%9A/result/result.png](https://github.com/HelloFool/2018118132_Android/blob/master/第五次作业/result/result.png) 

运行程序时需要输入登录账户和密码，这里对账号实现数据文件持久化操作，第一次输入账号后，退出程序重新打开，可以看到

用户的账户被保存，下一次只输入密码即可