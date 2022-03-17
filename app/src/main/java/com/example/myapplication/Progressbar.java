package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class Progressbar extends AppCompatActivity {

    int value = 0;
    Button b;
    ProgressBar p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progressbar);

        b = (Button) findViewById(R.id.download);
        p = (ProgressBar) findViewById(R.id.progressBar);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setprogressvalue(value);
            }
        });
    }
    void setprogressvalue(int progress){
        p.setProgress(progress);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setprogressvalue(progress+10);
            }
        });
        thread.start();
    }
}