package com.devsul.a12_sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by c on 2016-04-23.
 * SQLiteOpenHelper 사용하기 위한 커스텀 SQLiteOpenHelper 생성
 */
public class TESTSQLiteOpenHelper extends SQLiteOpenHelper {

    public TESTSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //디비가 생성될때 한번만 실행
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE USER (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                     "nabe TEXT, age, INTEGER, address TEXT)";

        db.execSQL(sql);
    }

    //디비 버전이 높을때 한번 실행됨
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS USER";
        db.execSQL(sql);

        onCreate(db);
    }
}
