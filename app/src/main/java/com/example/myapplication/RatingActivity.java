package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class RatingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        RatingBar rb = (RatingBar) findViewById(R.id.ratingBar);
        Button get = (Button) findViewById(R.id.getrate);
        TextView tv = (TextView) findViewById(R.id.textView9);

        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int numstar = rb.getNumStars();
                float rate = rb.getRating();
                tv.setText("Rating: "+rate+"/"+numstar);
            }
        });
    }
}