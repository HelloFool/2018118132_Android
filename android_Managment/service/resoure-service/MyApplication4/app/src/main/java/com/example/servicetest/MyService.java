package com.example.servicetest;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    private DownloadBinder mBinder = new DownloadBinder();

    public MyService() {
  }

    public class DownloadBinder extends Binder {

        public void startDownload() {

            Log.e("MyService", "startDownload executed");
            System.out.println("startDownload executed");
        }

        public int getProgress() {
            Log.e("MyService", "getProgress executed");
            System.out.println("getProgress executed");
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
        System.out.println("MyServiceonCreate executed");
     /*   Intent intent = new Intent(this, ThirdActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("This is content title")
                .setContentText("This is content text")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                .setContentIntent(pi)
                .build();
        startForeground(1, notification);*/
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("MyServiceonStartCommand executed");
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.e("MyService","Therad is"+Thread.currentThread().getId());

            }
        }).start();

        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("MyServiceonDestroy executed");
    }

}
