package com.example.quiz;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.quiz.Models.LeaderboardModels;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {
    private  static  final String db="score.db";
    public Database(@Nullable Context context) {
        super(context, db, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query="create table Scoreboard(serial integer primary key autoincrement,email text,score text)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    sqLiteDatabase.execSQL("drop table if exists Scoreboard");
    }
    public boolean insert(String email,String score){
        SQLiteDatabase sdb=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("email",email);
        values.put("score",score);
        return sdb.insert("Scoreboard",null,values)>0;
    }
    public ArrayList<LeaderboardModels>getScore(){
        ArrayList<LeaderboardModels>alldata=new ArrayList<>();
        SQLiteDatabase sdb=this.getReadableDatabase();
        Cursor cursor=sdb.rawQuery("select * from Scoreboard",null);
        if(cursor.moveToFirst()){
            do{
                LeaderboardModels model=new LeaderboardModels();
                model.setId(cursor.getInt(0)+"");
                model.setName(cursor.getString(1));
                model.setScore(cursor.getString(2));

                alldata.add(model);
            }while (cursor.moveToNext());
        }
        return alldata;
    }
}
