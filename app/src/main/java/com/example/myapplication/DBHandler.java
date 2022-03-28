package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "coursedb";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "courses";
    private static final String ID_COL = "id";
    private static final String NAME_COL = "name";
    private static final String DURATION_COL = "duration";
    private static final String TRACK_COL = "track";
    private static final String DESCRIPTION_COL = "description";

    public DBHandler(Context context) {
        super(context,DB_NAME,null,DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE "+TABLE_NAME+" ("+ID_COL+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                NAME_COL+" TEXT, "+DURATION_COL+" TEXT, "+TRACK_COL+" TEXT, "+DESCRIPTION_COL+" TEXT);";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void addCourse(String courseName, String courseDuration, String courseTrack, String courseDescription) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(NAME_COL,courseName);
        values.put(DURATION_COL,courseDuration);
        values.put(TRACK_COL,courseTrack);
        values.put(DESCRIPTION_COL,courseDescription);

        db.insert(TABLE_NAME,null,values);
        db.close();
    }

    public ArrayList<CourseModel> readCourse() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        ArrayList<CourseModel> courseModelArrayList = new ArrayList<>();

        if (cursor.moveToFirst()){
            do{
                courseModelArrayList.add(new CourseModel(cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4)));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return courseModelArrayList;
    }
}
