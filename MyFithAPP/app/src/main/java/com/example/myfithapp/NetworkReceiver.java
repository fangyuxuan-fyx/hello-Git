package com.example.myfithapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class NetworkReceiver extends BroadcastReceiver {
    private String getConnectionType(int type) {
        String connType = "";
        if (type == ConnectivityManager.TYPE_MOBILE) {
            connType = "4G网络数据";
        } else if (type == ConnectivityManager.TYPE_WIFI) {
            connType = "WIFI网络";
        }
        return connType;
    }

    //接受广播
    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager connectionManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectionManager.getActiveNetworkInfo();
        if (networkInfo != null) {
            Toast.makeText(context, "network is available",
                    Toast.LENGTH_SHORT).show();
            Log.i("网络", "连接上了");
            if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI
                    || networkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                Log.i("TAG", getConnectionType(networkInfo.getType()) + "连上");
            } else {
                Log.i("TAG", getConnectionType(networkInfo.getType()) + "断开");
            }
        } else {

            Toast.makeText(context, "network is unavailable",
                    Toast.LENGTH_SHORT).show();
            Log.i("网络", "连接bu上了");
        }
    }
}




