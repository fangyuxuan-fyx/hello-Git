package com.example.myeight;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;


public class MyService extends Service {
    private DownloadBinder mBinder = new DownloadBinder();
    /**
     * 绑定服务时才会调用
     * 必须要实现的方法
     * @param intent
     * @return
     */
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    /**
     * 首次创建服务时，系统将调用此方法来执行一次性设置程序（在调用 onStartCommand() 或 onBind() 之前）。
     * 如果服务已在运行，则不会调用此方法。该方法只被调用一次
     */
    @Override
    public void onCreate() {
        System.out.println("onCreate invoke");
        Log.i("service","onCreate invoke");
        super.onCreate();
    }


   /* @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }*/

    /**
     * 每次通过startService()方法启动Service时都会被回调。
     * @param intent
     * @param flags
     * @param startId
     * @return
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("onStartCommand invoke");
        Log.i("service","onStartCommand invoke");

        return super.onStartCommand(intent, flags, startId);
    }

    /**
     * 服务销毁时的回调
     */
    @Override
    public void onDestroy() {
        System.out.println("onDestroy invoke");
        Log.i("service","onDestroy invoke");
        super.onDestroy();
    }



    class DownloadBinder extends Binder {
        public void startDownload() {
            ActivityManager activityManager=(ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
            String runningActivity=activityManager.getRunningTasks(1).get(0).topActivity.getClassName();
if(runningActivity.indexOf("Login") != -1) {
    Log.i("service", runningActivity);

}else{
    Log.i("MyService", "startDownload executed");
}

        }
        public int getProgress() {
            Log.d("MyService", "getProgress executed");
            return 0;
        }
    }
}
