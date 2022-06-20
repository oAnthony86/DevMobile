package com.example.times.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.times.model.Times;

import java.util.ArrayList;
import java.util.List;

public class TimesDAO extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String TABLE = "times";
    private static final String DATABASE = "TimesApp";
    private static final String[] COLUMNS = { "id", "name", "country" };

    public TimesDAO(Context context) {
        super(context, DATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String ddl = "CREATE TABLE " + TABLE + " (" +
                " id INTEGER PRIMARY KEY, " +
                " name VARCHAR(100) NOT NULL, " +
                " country TEXT NOT NULL)";

        db.execSQL(ddl);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + TABLE;
        db.execSQL(sql);
        onCreate(db);
    }

    public List<Times> getList() {
        List<Times> times = new ArrayList<>();

        Cursor cursor = getWritableDatabase().query(
                TABLE,
                COLUMNS,
                null,
                null,
                null,
                null,
                null
        );

        while (cursor.moveToNext()) {
            Times time = new Times();

            time.setId(cursor.getLong(0));
            time.setName(cursor.getString(1));
            time.setCountry(cursor.getString(2));

            times.add(time);
        }

        cursor.close();

        return times;
    }

    public void insert(Times time) {
        ContentValues values = new ContentValues();

        values.put("name", time.getName());
        values.put("country", time.getCountry());

        getWritableDatabase().insert(TABLE, null, values);
    }

    public void delete(Times time) {
        String[] args = {time.getId().toString()};

        getWritableDatabase().delete(TABLE, "id=?", args);
    }

    public void alter(Times time) {
        ContentValues values = new ContentValues();

        values.put("name", time.getName());
        values.put("country", time.getCountry());

        String[] args = {time.getId().toString()};
        getWritableDatabase().update(TABLE, values, "id=?", args);
    }

}
