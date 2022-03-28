package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SMSActivity extends AppCompatActivity {

    EditText mobno, sms;
    Button sendsms;
    SmsManager smsManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smsactivity);

        mobno = (EditText) findViewById(R.id.smsmob);
        sms = (EditText) findViewById(R.id.smstext);
        sendsms = (Button) findViewById(R.id.smsBtn);
        sendsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sendmessage();
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100){
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                sendmessage();
            }
        }
    }

    private void sendmessage() {
        try {
            if (Build.VERSION.SDK_INT > 22) {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(SMSActivity.this, new String[]{Manifest.permission.SEND_SMS}, 100);
                    return;
                }
                String message = sms.getText().toString();
                String num = mobno.getText().toString();
                smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(num, null, message, null, null);
                Toast.makeText(getApplicationContext(), "Message sent", Toast.LENGTH_SHORT).show();
            }
            else{
                String message = sms.getText().toString();
                String num = mobno.getText().toString();
                smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(num, null, message, null, null);
                Toast.makeText(getApplicationContext(), "Message sent", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Some fields are Empty", Toast.LENGTH_SHORT).show();
        }
    }
}