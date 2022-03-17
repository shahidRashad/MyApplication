package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class MediaActivity extends AppCompatActivity {

    private TextView songname, startTime, songTime;
    private ImageButton frwdButton, plyButton, pauseButton, bkwdButton;
    private SeekBar sngprgs;
    private MediaPlayer mediaPlayer;
    private int sTime = 0, eTime = 0, fTime = 5000, bTime = 5000, oTime = 0;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        songname = (TextView) findViewById(R.id.songname);
        songname.setText("Half Girlfriend");
        startTime = (TextView) findViewById(R.id.spoint);
        songTime = (TextView) findViewById(R.id.epoint);
        frwdButton = (ImageButton) findViewById(R.id.foreward);
        plyButton = (ImageButton) findViewById(R.id.play);
        pauseButton = (ImageButton) findViewById(R.id.pause);
        bkwdButton = (ImageButton) findViewById(R.id.backward);
        sngprgs = (SeekBar) findViewById(R.id.seekBar3);

        mediaPlayer = MediaPlayer.create(this,R.raw.half_girlfriend);
        sngprgs.setClickable(false);
        pauseButton.setEnabled(false);

        plyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Media Playing", Toast.LENGTH_SHORT).show();
                mediaPlayer.start();
                eTime = mediaPlayer.getDuration();
                sTime = mediaPlayer.getCurrentPosition();
                sngprgs.setProgress(sTime);
                if (oTime == 0){
                    sngprgs.setMax(eTime);
                    oTime = 1;
                }
                startTime.setText(String.format("%d min %d sec", TimeUnit.MILLISECONDS.toMinutes(sTime),
                        TimeUnit.MILLISECONDS.toSeconds(sTime) - TimeUnit.MILLISECONDS.toSeconds(TimeUnit.MILLISECONDS.toMinutes(sTime))));
                songTime.setText(String.format("%d min %d sec",TimeUnit.MILLISECONDS.toMinutes(eTime),
                        TimeUnit.MILLISECONDS.toSeconds(eTime) - TimeUnit.MILLISECONDS.toSeconds(TimeUnit.MILLISECONDS.toMinutes(eTime))));
                handler.postDelayed(updateSong, 100);

                plyButton.setEnabled(false);
                pauseButton.setEnabled(true);
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Media Paused", Toast.LENGTH_SHORT).show();
                mediaPlayer.pause();
                pauseButton.setEnabled(false);
                plyButton.setEnabled(true);
            }
        });

        frwdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((sTime + fTime) <= eTime){
                    sTime = sTime + fTime;
                    mediaPlayer.seekTo(sTime);
                }
                else Toast.makeText(getApplicationContext(), "Cant jump foreward 5 seconds", Toast.LENGTH_SHORT).show();
                if (!plyButton.isEnabled()){
                    plyButton.setEnabled(true);
                }
            }
        });

        bkwdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((sTime - bTime) > 0){
                    sTime = sTime - bTime;
                    mediaPlayer.seekTo(sTime);
                }
                else Toast.makeText(getApplicationContext(), "Cant jump backward 5 seconds", Toast.LENGTH_SHORT).show();
                if (!plyButton.isEnabled()){
                    plyButton.setEnabled(true);
                }
            }
        });

    }
    private Runnable updateSong = new Runnable() {
        @Override
        public void run() {

                sTime = mediaPlayer.getCurrentPosition();
                startTime.setText(String.format("%d min, %d sec", TimeUnit.MILLISECONDS.toMinutes(sTime),
                        TimeUnit.MILLISECONDS.toSeconds(sTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(sTime))));
                sngprgs.setProgress(sTime);
                handler.postDelayed(this,100);
        }
    };
}