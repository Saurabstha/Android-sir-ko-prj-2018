package com.anew.user.class3pmnov14;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import com.anew.user.class3pmnov14.helper.Userinfo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by User on 12/8/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    static String name = "class3pmdb";
    static int version = 1;
    String createTable = "CREATE TABLE if not exists`user` (\n" +
            "\t`id`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "\t`name`\tTEXT,\n" +
            "\t`email`\tTEXT,\n" +
            "\t`password`\tTEXT,\n" +
            "\t`gender`\tTEXT,\n" +
            "\t`address`\tTEXT,\n" +
            "\t`image`\tBLOB\n" +
            ")";

    public DatabaseHelper(Context context) {
        super(context, name, null, version);
        getWritableDatabase().execSQL(createTable);
    }

    public void insertUser(ContentValues cv) {
        getWritableDatabase().insert("user", " ", cv);
    }

    public void updateUser(String id, ContentValues cv) {
        getWritableDatabase().update("user", cv, "id=" + id, null);
    }

    public void deleteUser(String id) {
        getWritableDatabase().delete("user", "id=" + id, null);
    }

    public ArrayList<Userinfo> getUserList() {

        String sql = "Select * from user ";
        ArrayList<Userinfo> list = new ArrayList<Userinfo>();
        Cursor c = getReadableDatabase().rawQuery(sql, null);
        while (c.moveToNext()) {
            Userinfo info = new Userinfo();
            info.id = c.getString(c.getColumnIndex("id"));
            info.username = c.getString(c.getColumnIndex("name"));
            info.password = c.getString(c.getColumnIndex("password"));
            info.address = c.getString(c.getColumnIndex("address"));
            //info.phone=c.getString(c.getColumnIndex("phone"));
            info.gender = c.getString(c.getColumnIndex("gender"));
            info.image = c.getBlob(c.getColumnIndex("image"));
            list.add(info);


        }
        c.close();
        return list;
    }
    public ArrayList<String> getUsernameList() {

        String sql = "Select * from user ";
        ArrayList<String> list = new ArrayList<String>();
        Cursor c = getReadableDatabase().rawQuery(sql, null);
        while (c.moveToNext()) {

            list.add(c.getString(c.getColumnIndex("name")));


        }
        c.close();
        return list;
    }


    public boolean isValidLogin(String username, String password) {
        String sql = "select count(*) from user where name='" + username + "' and password=='" + password + "'";
        SQLiteStatement statement = getReadableDatabase().compileStatement(sql);
        long l = statement.simpleQueryForLong();
        if (l == 1) {
            return true;
        }
        return false;
    }

    public Userinfo getUserInfo(String id) {
        Userinfo info = new Userinfo();
        String sql = "Select * from user where id=" + id;
        Cursor c = getReadableDatabase().rawQuery(sql, null);
        while (c.moveToNext()) {
            info.id = c.getString(c.getColumnIndex("id"));
            info.username = c.getString(c.getColumnIndex("name"));
            info.password = c.getString(c.getColumnIndex("password"));
            info.address = c.getString(c.getColumnIndex("address"));
            //info.phone=c.getString(c.getColumnIndex("phone"));
            info.gender = c.getString(c.getColumnIndex("gender"));


        }
        c.close();
        return info;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void concept() {
        ArrayList<String> stringArrayList = new ArrayList<String>();
        stringArrayList.add("Ram");
        stringArrayList.add("Shyam");
        stringArrayList.add("Hari");
        for (String value : stringArrayList
                ) {
            Log.i("Prev", value);
        }
        Collections.shuffle(stringArrayList);
        for (String value : stringArrayList
                ) {
            Log.i("after", value);
        }
        HashMap<String, String> hashMap = new HashMap<String, String>();
        HashMap<String, Userinfo> userinfoHashMap = new HashMap<String, Userinfo>();
        Userinfo info = new Userinfo();
        info.username = "Ram";
        info.password = "1234";
        userinfoHashMap.put("aa", info);
        Userinfo info1 = userinfoHashMap.get("Ram");

        ContentValues cv = new ContentValues();
        cv.put("name", "Amun");
        cv.put("password", "Amun111");
        cv.put("gender", "Female");

    }
}
