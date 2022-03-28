package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;

public class RecyclerWithCard extends AppCompatActivity {
    String[] personName = {"Lional messi","Cristiano Ronaldo","Marc Zuckerberg","Bill Gates","Narendra Modi","Virat Kohi","Sachin Tendulkar","Usain Bolt","Elon Musk","Decaprio"};
    int[] personImages = {R.drawable.messi,R.drawable.ronaldo,R.drawable.zuckerberg,R.drawable.gates,R.drawable.modi,R.drawable.kohli,R.drawable.sachin,R.drawable.bolt,R.drawable.musk,R.drawable.decaprio};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_with_card);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        CustCardAdapter custCardAdapter = new CustCardAdapter(RecyclerWithCard.this,personName,personImages);
        recyclerView.setAdapter(custCardAdapter);
    }
}