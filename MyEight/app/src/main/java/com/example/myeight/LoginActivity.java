package com.example.myeight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;





public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button startBtn;
    private Button readyBtn;
    private Button closeBtn;
    private Button oseBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startBtn= (Button) findViewById(R.id.button);
        readyBtn= (Button) findViewById(R.id.button2);
        closeBtn=(Button)findViewById(R.id.button3);
        oseBtn=(Button)findViewById(R.id.button5);
        startBtn.setOnClickListener(this);

        readyBtn.setOnClickListener(this);
        closeBtn.setOnClickListener(this);
        oseBtn .setOnClickListener(this);
    }
    private MyService.DownloadBinder downloadBinder;
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
       downloadBinder = (MyService.DownloadBinder) service;
            downloadBinder.startDownload();
            downloadBinder.getProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }

    };

    @Override
    public void onClick(View v) {
        Intent it=new Intent(this, MyService.class);
        switch (v.getId()){
            case R.id.button:
                startService(it);

                break;
            case R.id.button2:
                Intent bindIntent = new Intent(LoginActivity.this,MyService.class);
                bindService(bindIntent,connection,BIND_AUTO_CREATE);
                break;

            case R.id.button3:
                stopService(it);
                break;

        case R.id.button5:
            unbindService(connection);
            break;

        }
    }
}