##                                           第十次实验

### 实验目的：了解服务机制

### 实验过程：

##### 1.异步任务

UI操作必须在主线程进行，所以子线程若想实现UI操作可以通过异步机制来实现

这里通过更改UI的文本实验，主要代码：

```java
//UI操作
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
//消息机制
                public void run(){
                    Message message=new Message();
                    message.what=UPDATE_TEXT;
                    handler.sendMessage(message);
                }
            }).start();

```

**实验结果**

 ![]( https://github.com/HelloFool/2018118132_Android/blob/master/android_Managment/service/photo/6b760bb36e34166a7e4ccfc6eb12d71.png  )

![]( https://github.com/HelloFool/2018118132_Android/blob/master/android_Managment/service/photo/de11a48a30611897a429050d8ee0ca8.png )

##### 2.服务的启动和停止

在定义服务后，借助Intent可以实现服务的启动和停止，启动有onCreate方法和onStartCommand方法，停止为onDestory方法，主要代码如下：

```java
 public void onCreate() {
        super.onCreate();
        System.out.println("MyServiceonCreate executed");}
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("MyServiceonStartCommand executed");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("MyServiceonDestroy executed");
    }
```

**实验结果**

![](https://github.com/HelloFool/2018118132_Android/blob/master/android_Managment/service/photo/0904ef312dab2dfa557747810134b31.png )

![]( https://github.com/HelloFool/2018118132_Android/blob/master/android_Managment/service/photo/5ec9072d8cc4ad484600dee228bfe07.png )

![]( https://github.com/HelloFool/2018118132_Android/blob/master/android_Managment/service/photo/8477e490292e820f2cd0e057ea16ee5.png )

##### 3.子服务绑定

服务启动后，若想通过活动来控制服务的任务，需要在活动建立与服务的绑定关系，实现这个绑定关系可以创建一个专门的Binder对象来实现，这里通过按钮进行服务绑定和解除绑定

```java
public class MyService extends Service {

    public MyService() {
    }

    private DownloadBinder mBinder = new DownloadBinder();

    class DownloadBinder extends Binder {

        public void startDownload() {

            Log.e("MyService", "startDownload executed");
        }

        public int getProgress() {
            Log.e("MyService", "getProgress executed");
            return 0;
        }

    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("MyService", "onCreate executed");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("MyService", "onStartCommand executed");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("MyService", "onDestroy executed");
    }

}

```

**实验结果**



##### 4.多线程

由于在主线程直接处理耗时逻辑，很可能导致主线程被阻塞，所以要采用多线程的编程技术

这里分别打印了主线程和子线程的id