package com.example.myfithapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.util.Log;
import android.widget.Toast;

public class PowerConnectionReceiver extends BroadcastReceiver {

   /* int intLevel = 0;
    int intScale = 0;*/
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);

        float batteryPct = (level / (float)scale)*100;

            Log.i("power",""+batteryPct+"%");
            int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
            boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING ||
                    status == BatteryManager.BATTERY_STATUS_FULL;
            Log.i("www","ddd"+isCharging);
            if(isCharging){

                Log.i("手机","在充电"+batteryPct+"%");
            }
            else{
                Log.i("手机在放电","当前电量为"+batteryPct+"%");
    }
if(batteryPct<0.5){
    Log.i("手机当前电量不足","此时为："+batteryPct+"%");
}
else{
    Log.i("当前电量充足","此时为："+batteryPct+"%");
}

        int chargePlug = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
        boolean usbCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_USB;
        if(usbCharge){
            Log.i("usb","cd");
        }
        else{
            Log.i("usb","cd吧");
        }
        boolean acCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_AC;
    }
}