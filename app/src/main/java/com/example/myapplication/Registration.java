package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    String district [] = {"Select District","Thiruvananthapuram","Kollam","Pathanamthtta","Kottayam","Idukki","Alappuzha","Ernakulam","Palakkad","Thrissure","Malappuram","Kozhikode","Wayanad","Kannur","kasargode"};
    Spinner dist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        Button register = (Button) findViewById(R.id.submit);
        dist = (Spinner)findViewById(R.id.district);
        ArrayAdapter adapt = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, district);
        dist.setAdapter(adapt);
        dist.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            if (i==0){

            }else{
                Toast.makeText(getApplicationContext(), district[i], Toast.LENGTH_SHORT).show();

            }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText un = (EditText) findViewById(R.id.email);
                EditText pw = (EditText) findViewById(R.id.pass);
                String uname = un.getText().toString();
                String pswd = pw.getText().toString();
                Intent in = new Intent(getApplicationContext(), Login.class);
                in.putExtra("username", uname);
                in.putExtra("password", pswd);
                startActivity(in);
            }
        });


    }
}