package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ViewCourse extends AppCompatActivity {

    private ArrayList<CourseModel> courseModelArrayList;
    private DBHandler dbHandler;
    private CourseRVAdapter courseRVAdapter;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_course);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewCourse);
        courseModelArrayList = new ArrayList<>();
        dbHandler = new DBHandler(ViewCourse.this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(ViewCourse.this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        courseModelArrayList = dbHandler.readCourse();
        courseRVAdapter = new CourseRVAdapter(courseModelArrayList, ViewCourse.this);
        recyclerView.setAdapter(courseRVAdapter);
    }
}