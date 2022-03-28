package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class SqliteWithoutOpenholder extends AppCompatActivity {

    EditText edesig, econ_no, ecity, earea;
    AutoCompleteTextView ename;
    Button add, show, update, delete, reset;

    SQLiteDatabase db;
    private static final String DB_NAME = "myDB.db";
    private static final String TABLE_NAME ="emp_details";

    List<String> item = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    Cursor cur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_without_openholder);

        ename = (AutoCompleteTextView) findViewById(R.id.ename);
        edesig = (EditText) findViewById(R.id.edesignation);
        econ_no = (EditText) findViewById(R.id.econt);
        ecity = (EditText) findViewById(R.id.ecity);
        earea = (EditText) findViewById(R.id.earea);
        add = (Button) findViewById(R.id.add);
        show = (Button) findViewById(R.id.show);
        update = (Button) findViewById(R.id.update);
        delete = (Button) findViewById(R.id.delete);
        reset = (Button) findViewById(R.id.reset);

        db = openOrCreateDatabase(TABLE_NAME, Context.MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, DESIGNATION TEXT, CONTACT NUMBER, CITY TEXT, AREA TEXT);");
        db.close();

        ename.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                item.clear();
                db = openOrCreateDatabase(TABLE_NAME, Context.MODE_PRIVATE,null);
                cur = db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
                cur.moveToFirst();

                while(cur.isAfterLast() == false){
                    String name = cur.getString(0);
                    item.add(name);
                    cur.moveToNext();
                }

                adapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_list_item_1,item);
                ename.setAdapter(adapter);
                ename.setThreshold(1);
                db.close();
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = openOrCreateDatabase(TABLE_NAME, Context.MODE_PRIVATE,null);
                db.execSQL("INSERT INTO " + TABLE_NAME + "(NAME, DESIGNATION, CONTACT, AREA, CITY) "+
                        "VALUES( '" + ename.getText().toString() + "', '" + edesig.getText().toString() + "', '"
                        + econ_no.getText() + "', '" + ecity.getText().toString()
                        + "', '" + earea.getText().toString() + "')");
                db.close();
                ename.getText().clear();
                edesig.getText().clear();
                econ_no.getText().clear();
                ecity.getText().clear();
                earea.getText().clear();

            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = openOrCreateDatabase(TABLE_NAME, Context.MODE_PRIVATE,null);
                db.execSQL("UPDATE " + TABLE_NAME + " SET DESIGNATION='" + edesig.getText().toString() +"' WHERE NAME='" + ename.getText().toString() +"'");
                db.close();
                ename.getText().clear();
                edesig.getText().clear();
            }
        });
    }
}