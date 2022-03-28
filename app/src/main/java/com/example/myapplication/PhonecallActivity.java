package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PhonecallActivity extends AppCompatActivity {

    private EditText mob;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phonecall);

        mob = (EditText) findViewById(R.id.mob_no);
        button = (Button) findViewById(R.id.callBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makephonecall();
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 101){
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                makephonecall();
            }
        }
    }

    private void makephonecall() {
        try {
            if (Build.VERSION.SDK_INT > 22) {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(PhonecallActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 101);
                    return;
                }
                Intent CallInt = new Intent(Intent.ACTION_DIAL);
                CallInt.setData(Uri.parse("tel:" + mob.getText().toString()));
                startActivity(CallInt);
            } else {
                Intent CallInt = new Intent(Intent.ACTION_CALL);
                CallInt.setData(Uri.parse("tel:" + mob.getText().toString()));
                startActivity(CallInt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}