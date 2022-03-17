package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class CustomAlert extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_alert);

        Button simple = (Button) findViewById(R.id.simplebutton);
        Button items = (Button) findViewById(R.id.items);
        Button multi = (Button) findViewById(R.id.multi_choice);
        Button editext = (Button) findViewById(R.id.edit_text);
        Button image = (Button) findViewById(R.id.image_view);
        Button seekbar = (Button) findViewById(R.id.seekbar);
        Button ratingbar = (Button) findViewById(R.id.ratingbar);



        simple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(CustomAlert.this);
                builder.setTitle("Simple Alert Box");
                builder.setMessage("How Are You");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "Ok is Clicked", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setCancelable(false);
                builder.show();
            }
        });


        items.setOnClickListener(new View.OnClickListener() {
            
            String[] fruits = {"Apple","Banana","Orange","Grape"};
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(CustomAlert.this);
                builder.setTitle("List of Items").setItems(fruits, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), fruits[i]+" is Clicked", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setPositiveButton("Ok",null);
                builder.setNegativeButton("No",null);
                builder.setNeutralButton("Cancel",null);
                builder.setCancelable(false);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                Button button = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE);
                button.setBackgroundColor(Color.BLUE);
                button.setPadding(5,5,5,5);
                button.setTextColor(Color.WHITE);
            }
        });

        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] fruits = {"Apple","Banana","Orange","Grape"};
                final ArrayList<Integer> selectedlist = new ArrayList<>();
                AlertDialog.Builder builder = new AlertDialog.Builder(CustomAlert.this);
                builder.setTitle("This is a Multi choice Alert Box");
                builder.setMultiChoiceItems(fruits, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        if (b){
                            selectedlist.add(i);
                        }
                        else if (selectedlist.contains(i)){
                            selectedlist.remove(Integer.valueOf(i));
                        }
                    }
                });
                builder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        final ArrayList<String> selectedString = new ArrayList<>();
                        for (int j=0 ; j< selectedlist.size(); j++){
                            selectedString.add(fruits[selectedlist.get(j)]);
                        }
                        Toast.makeText(getApplicationContext(), "Selected Items are "+ Arrays.toString(selectedString.toArray()), Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });

        editext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(CustomAlert.this);
                builder.setTitle("With Edit Text");

                EditText input = new EditText(CustomAlert.this);
                LinearLayout.LayoutParams layout = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
                input.setLayoutParams(layout);
                builder.setView(input);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "The entered Text is \n"+input.getText().toString(), Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });

        seekbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(CustomAlert.this);
                builder.setTitle("Alert Dialog with Seekbar");
                SeekBar seek = new SeekBar(CustomAlert.this);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
                seek.setLayoutParams(lp);
                builder.setView(seek);
                builder.setCancelable(false);
                builder.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "Progress is "+seek.getProgress(), Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                builder.show();
            }
        });

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(CustomAlert.this);
                builder.setTitle("Alert with a Image View");
                LayoutInflater inflater = getLayoutInflater();
                View view1 = inflater.inflate(R.layout.alert_dialog_with_image,null);
                builder.setView(view1);
                builder.setPositiveButton("Ok",null);
                builder.show();
            }
        });

        ratingbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(CustomAlert.this);
                builder.setTitle("Rate the Movie");
                LayoutInflater inflater = getLayoutInflater();
                View view1 = inflater.inflate(R.layout.alert_dialog_with_ratingbar,null);
                builder.setView(view1);
                RatingBar ratingBar = view1.findViewById(R.id.ratingBar2);
                builder.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "Your rating is "+ratingBar.getRating()+"/5", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setCancelable(false);
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                Button button = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE);
                button.setBackgroundColor(Color.BLUE);
                button.setTextColor(Color.WHITE);
            }
        });
    }
}