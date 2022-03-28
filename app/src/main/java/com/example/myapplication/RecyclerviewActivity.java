package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;

public class RecyclerviewActivity extends AppCompatActivity {

    ArrayList<String> personName = new ArrayList<>(Arrays.asList("Lional messi","Cristiano Ronaldo","Marc Zuckerberg","Bill Gates","Narendra Modi","Virat Kohi","Sachin Tendulkar","Usain Bolt","Elon Musk","Decaprio"));
    ArrayList<Integer> personImages = new ArrayList<>(Arrays.asList(R.drawable.messi,R.drawable.ronaldo,R.drawable.zuckerberg,R.drawable.gates,R.drawable.modi,R.drawable.kohli,R.drawable.sachin,R.drawable.bolt,R.drawable.musk,R.drawable.decaprio));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),3, LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);

        CustRecyclerAdapter custRecyclerAdapter = new CustRecyclerAdapter(RecyclerviewActivity.this,personName,personImages);
        recyclerView.setAdapter(custRecyclerAdapter);
    }
}