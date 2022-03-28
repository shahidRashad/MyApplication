package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BroadcastActivity extends AppCompatActivity {

    private Button getBat;
    private TextView status;
    IntentFilter intentFilter;
    int batteryStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);

        getBat = (Button) findViewById(R.id.battery);
        status = (TextView) findViewById(R.id.status);

        intentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);

        getBat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BroadcastActivity.this.registerReceiver(broadcastreciever,intentFilter);
            }
        });
    }

    BroadcastReceiver broadcastreciever = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            batteryStatus = intent.getIntExtra(BatteryManager.EXTRA_STATUS,-1);
            if (batteryStatus == BatteryManager.BATTERY_STATUS_CHARGING){
                status.setText("Battery Status = Charging");
            }
            if (batteryStatus == BatteryManager.BATTERY_STATUS_DISCHARGING){
                status.setText("Battery Status = Discharging");
            }
            if (batteryStatus == BatteryManager.BATTERY_STATUS_FULL){
                status.setText("Battery Status = Battrey Full");
            }
            if (batteryStatus == BatteryManager.BATTERY_STATUS_NOT_CHARGING){
                status.setText("Battery Status = Not Charging");
            }
            if (batteryStatus == BatteryManager.BATTERY_STATUS_UNKNOWN){
                status.setText("Battery Status = Unknown");
            }
        }
    };
}