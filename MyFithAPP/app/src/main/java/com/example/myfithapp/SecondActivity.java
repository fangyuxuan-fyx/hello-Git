package com.example.myfithapp;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
 /*  private int BatteryN;//目前电量
    private int BatteryV;//电池电压
    private double BatteryT;//电池温度
    private String BatteryStatus;//电池状态
    private String BatteryTemp;//电池使用情况
    //public TextView TV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerReceiver(mBatInfoReceive, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        //TV= (TextView) findViewById(R.id.TV);
    }
    //创建广播接收器
    private BroadcastReceiver mBatInfoReceive=new BroadcastReceiver() {


        @Override
        public void onReceive(Context context, Intent intent) {
            String action=intent.getAction();
            if(Intent.ACTION_BATTERY_CHANGED.equals(action)){
                BatteryN=intent.getIntExtra("level",0);
                Log.i("shouji","在充电");
                switch (intent.getIntExtra("status", BatteryManager.BATTERY_STATUS_UNKNOWN)){
                    case BatteryManager.BATTERY_STATUS_CHARGING:
                        BatteryStatus="充电状态";
                        break;
                    case BatteryManager.BATTERY_STATUS_DISCHARGING:
                        BatteryStatus="放电状态";
                        break;
                    case BatteryManager.BATTERY_STATUS_NOT_CHARGING:
                        BatteryStatus="未充电";
                        break;
                    case BatteryManager.BATTERY_STATUS_FULL:
                        BatteryStatus="充满电";
                        break;
                    case BatteryManager.BATTERY_STATUS_UNKNOWN:
                        BatteryStatus="未知状态";
                        break;
                }
                switch (intent.getIntExtra("health",BatteryManager.BATTERY_HEALTH_UNKNOWN)){
                    case BatteryManager.BATTERY_HEALTH_UNKNOWN:
                        BatteryTemp="未知错误";
                        break;
                    case BatteryManager.BATTERY_HEALTH_GOOD:
                        BatteryTemp="状态良好";
                        break;
                    case BatteryManager.BATTERY_HEALTH_DEAD:
                        BatteryTemp="电池没有电";
                        break;
                    case BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE:
                        BatteryTemp="电池电压过高";
                        break;
                    case BatteryManager.BATTERY_HEALTH_OVERHEAT:
                        BatteryTemp="电池过热";
                        break;
                }
                Log.i("目前电量为"+BatteryN,"BatteryStatus"+BatteryStatus);
              //  TV.setText("目前电量为"+BatteryN+"%---"+BatteryStatus+"\n"+"电压为"+BatteryV+"mV---"+BatteryTemp+"\n"+"温度为"+(BatteryT*0.1)+"℃");
            }
            else{
                Log.i("shouji","在放电");
            }
        }
    };
}*/


   private PowerConnectionReceiver batteryReceiver = new PowerConnectionReceiver();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



         Log.e("qqq","qq");
        IntentFilter intentFilter = new IntentFilter();

        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);


        registerReceiver(batteryReceiver, intentFilter);

    }
    @Override
    protected void onDestroy() {
        //解除广播
        unregisterReceiver(batteryReceiver);
        super.onDestroy();
    }
    }


