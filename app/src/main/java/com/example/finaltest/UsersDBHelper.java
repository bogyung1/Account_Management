package com.example.finaltest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import androidx.annotation.Nullable;




public class UsersDBHelper extends SQLiteOpenHelper {



    public UsersDBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);


    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql="create table myusers ( ";
        sql+= "site text, ";
        sql+= "url text, ";
        sql+= "name text";
        sql+= "password text";
        sql+=" )";

        Log.i("Edit_Page",sql);
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists myUsers");
        onCreate(db);
    }
}
