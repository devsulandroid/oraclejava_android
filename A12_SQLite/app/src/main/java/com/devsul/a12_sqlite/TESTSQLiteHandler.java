package com.devsul.a12_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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

    //delete
    public void delete(String name){
        db = helper.getWritableDatabase();

        db.delete("USER", "name = ?", new String[] {name});
    }

    //update
    public void update(String name, int newAge){
        db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("age", newAge);

        db.update("USER", values, "name = ?", new String[]{name});

    }

    //select
    public String selectAll(){
        db = helper.getWritableDatabase();

        String res = "";
        Cursor c = db.query("USER", null, null, null, null, null, null);

        while (c.moveToNext()){
            int id = c.getInt(c.getColumnIndex("id"));
            String name = c.getString(c.getColumnIndex("name"));
            int age = c.getInt(c.getColumnIndex("age"));
            String address = c.getString(c.getColumnIndex("address"));

            res += "id : " + id + ", name : " + name + ", age : " + age + ", address : " + address;
            res += "\n";
        }

        return res;
    }
}
