package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread obj = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent i = new Intent(getApplicationContext(), Login.class);
                startActivity(i);
            }
        };
        obj.start();

        ImageView iv = (ImageView)findViewById(R.id.imageView);
        Animation zoomin = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
        iv.startAnimation(zoomin);
    }
}