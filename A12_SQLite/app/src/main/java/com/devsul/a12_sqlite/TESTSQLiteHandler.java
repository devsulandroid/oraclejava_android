package com.devsul.a12_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by c on 2016-04-23.
 */
public class TESTSQLiteHandler {
    TESTSQLiteOpenHelper helper;
    SQLiteDatabase db;

    // 생성자
    public TESTSQLiteHandler(Context context) {
        helper = new TESTSQLiteOpenHelper(context, "people", null, 1);
    }

    //insert
    public void insert(String name, int age, String address){
        db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("age", age);
        values.put("address", address);

        db.insert("USER", null, values);
    }
}
