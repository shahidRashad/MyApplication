package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.net.URI;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        EditText url = (EditText) findViewById(R.id.url);
        Button go = (Button) findViewById(R.id.go);
        TextView tv = (TextView)findViewById(R.id.textView13);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ur = url.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www."+ur+".com"));
                startActivity(intent);
            }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ScrollviewActivity.class);
                startActivity(intent);
            }
        });
        TextView tvmusic = (TextView) findViewById(R.id.musictv);
        tvmusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MediaActivity.class);
                startActivity(intent);
            }
        });

        TextView tvvideo = (TextView) findViewById(R.id.videotv);
        tvvideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),VideoActivity.class);
                startActivity(intent);
            }
        });
    }
}