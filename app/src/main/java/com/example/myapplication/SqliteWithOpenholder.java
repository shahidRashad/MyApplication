package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SqliteWithOpenholder extends AppCompatActivity {

    private EditText NameCourse, DurCourse, TrackCourse, DescCourse;
    private Button addCourse, viewcourse;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_with_openholder);

        NameCourse = (EditText) findViewById(R.id.idCourseName);
        DurCourse = (EditText) findViewById(R.id.idCourseDuration);
        TrackCourse = (EditText) findViewById(R.id.idCourseTrack);
        DescCourse = (EditText) findViewById(R.id.idCourseDescription);
        addCourse = (Button) findViewById(R.id.idAddButton);
        viewcourse = (Button) findViewById(R.id.idViewButton);

        dbHandler = new DBHandler(SqliteWithOpenholder.this);

        addCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String CourseName = NameCourse.getText().toString();
                String CourseDuration = DurCourse.getText().toString();
                String CourseTrack = TrackCourse.getText().toString();
                String CourseDescription = DescCourse.getText().toString();

                if (CourseName.isEmpty() && CourseDuration.isEmpty() && CourseTrack.isEmpty() && CourseDescription.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Please enter the data", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(SqliteWithOpenholder.this, "Course has been added", Toast.LENGTH_SHORT).show();
                dbHandler.addCourse(CourseName,CourseDuration,CourseTrack,CourseDescription);
                NameCourse.setText("");
                DurCourse.setText("");
                TrackCourse.setText("");
                DescCourse.setText("");
            }
        });

        viewcourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SqliteWithOpenholder.this,ViewCourse.class);
                startActivity(i);
            }
        });
    }
}