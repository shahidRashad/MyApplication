package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class Seekbar extends AppCompatActivity {

   

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seekbar);

        TextView tv = (TextView) findViewById(R.id.textView8);
        SeekBar seekbar = (SeekBar) findViewById(R.id.seekBar);
        SeekBar seekbar1 = (SeekBar) findViewById(R.id.seekBar2);
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                this.progress = progress;
                tv.setTextSize(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(), "Started Touching", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(), "Seekbar progress "+progress, Toast.LENGTH_SHORT).show();

            }
        });

        seekbar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                this.progress = i;
                tv.setTextSize(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(), "Started Touching", Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(), "Seekbar progress "+progress, Toast.LENGTH_SHORT).show();

            }
        });
    }
}