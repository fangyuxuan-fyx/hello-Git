package com.example.myfithapp;

import java.util.HashMap;

import java.util.Map;

import android.content.BroadcastReceiver;

import android.content.Context;

import android.content.Intent;

import android.os.BatteryManager;

import android.os.Message;
import android.util.Log;


public class BatteryLevelReceiver extends BroadcastReceiver {


    Message message;


    Map map = null;

    @Override

    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();

        if (action.equals(Intent.ACTION_BATTERY_CHANGED)) {
            Log.i("", "cjpnghisj");
            map = new HashMap();

/** 电池剩余电量 */

            map.put("level", intent.getIntExtra("level", 0) + "");


/** 获取电池状态 */

            map.put("status", intent.getIntExtra("status", BatteryManager.BATTERY_STATUS_UNKNOWN) + "");


        }
    }
}

