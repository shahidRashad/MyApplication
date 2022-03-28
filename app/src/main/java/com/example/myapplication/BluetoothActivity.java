package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Set;

public class BluetoothActivity extends AppCompatActivity {

    private final int REQUEST_ENABLE_BT = 0;
    private final int REQUES_DISCOVERABLE_BT = 1;
    Button onButton, offButton, disButton, pairedButton;
    TextView statTv, deviceTv;
    ImageView blueIv;
    BluetoothAdapter bluetoothAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);
        onButton = (Button) findViewById(R.id.onBtn);
        offButton = (Button) findViewById(R.id.offBtn);
        disButton = (Button) findViewById(R.id.disBtn);
        pairedButton = (Button) findViewById(R.id.pairedBtn);
        statTv = (TextView) findViewById(R.id.statustv);
        deviceTv = (TextView) findViewById(R.id.pairedtv);
        blueIv = (ImageView) findViewById(R.id.iconiv);

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        if (bluetoothAdapter == null){
            statTv.setText("Bluetooth is not Available");
        }
        else {
            statTv.setText("Bluetooth is Available");
        }
        if (bluetoothAdapter.isEnabled()){
            blueIv.setImageResource(R.drawable.bluetoothon);
        }
        else {
            blueIv.setImageResource(R.drawable.bluetoothoff);
        }

        onButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!bluetoothAdapter.isEnabled()){
                    Toast.makeText(getApplicationContext(), "Turning on Bluetooth", Toast.LENGTH_SHORT).show();
                    blueIv.setImageResource(R.drawable.bluetoothon);
                    Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(intent,REQUEST_ENABLE_BT);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Bluetooth is already On", Toast.LENGTH_SHORT).show();
                }
            }
        });

        offButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bluetoothAdapter.isEnabled()){
                    bluetoothAdapter.disable();
                    Toast.makeText(getApplicationContext(), "Bluetooth is Turning Off", Toast.LENGTH_SHORT).show();
                    blueIv.setImageResource(R.drawable.bluetoothoff);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Bluetooth is already Off", Toast.LENGTH_SHORT).show();
                }
            }
        });

        disButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!bluetoothAdapter.isDiscovering()){
                    Toast.makeText(getApplicationContext(), "Making your Device Discoverable", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                    startActivityForResult(intent,REQUES_DISCOVERABLE_BT);
                    blueIv.setImageResource(R.drawable.bluetoothon);
                }
            }
        });

        pairedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bluetoothAdapter.isEnabled()){
                    deviceTv.setText("Paired Devices:");
                    Set<BluetoothDevice> devices = bluetoothAdapter.getBondedDevices();
                    for (BluetoothDevice device: devices) {
                        deviceTv.append("\n"+device.getName()+", "+device);
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "Turn on Bluetooth to get paired devices", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode){
            case REQUEST_ENABLE_BT:
                if (resultCode == RESULT_OK){
                    blueIv.setImageResource(R.drawable.bluetoothon);
                    Toast.makeText(getApplicationContext(), "Bluetooth is on", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Couldnt on Bluetooth", Toast.LENGTH_SHORT).show();
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}