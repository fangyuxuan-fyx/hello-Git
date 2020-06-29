package com.example.myfithapp;

import android.os.Bundle;

import android.app.Activity;


public class Battery extends Activity {



    BatteryLevelReceiver receiver = new BatteryLevelReceiver();

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);





    }

  /*  private void regReceiver() {

        IntentFilter filter = new IntentFilter();

        filter.addAction(Intent.ACTION_BATTERY_CHANGED);

        receiver = new BatteryLevelReceiver();

        registerReceiver(receiver, filter);

    }

    protected void onDestroy() {

        super.onDestroy();


        unregisterReceiver(receiver);

    }*/
}
