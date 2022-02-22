package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    String user ="shahid";
    String pw = "abc";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText username = (EditText) findViewById(R.id.username);
        EditText password = (EditText) findViewById(R.id.password);
        Button login = (Button) findViewById(R.id.submit);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname = username.getText().toString();
                String pswd = password.getText().toString();
                if (uname.equals(user) && pswd.equals(pw)){
                    Intent i = new Intent(getApplicationContext(), HomePage.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(getApplicationContext(), "invalid username or password", Toast.LENGTH_LONG).show();

                }
            }
        });

    }
}