package com.example.behocnhanbiet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DatabaseHandler extends SQLiteOpenHelper{
    // Khai báo bi?n
    private Context dbContext;
    private SQLiteDatabase db;
    private static final String dbPath =  "/data/data/com.example.behocnhanbiet/databases/Nhanbiet.sqlite";
    private static final String dbName = "Nhanbiet.sqlite";
    private static final int dbVersion = 1;


    // Phuong th?c 1: Phuong th?c kh?i d?ng
    public DatabaseHandler(Context context) {
        super(context, dbName, null, dbVersion);
        this.dbContext = context;
    }

    public void copyDB2SDCard() throws IOException {
        boolean check = false;
        try {
            File file = new File(dbPath);
            check = file.exists();
            if (check) {
                this.close();
            } else if (!check) {
                this.getReadableDatabase();
                InputStream myInput = dbContext.getAssets().open(dbName);
                String outFileName = dbPath;
                OutputStream myOutput = new FileOutputStream(outFileName);
                byte[] buffer = new byte[1024];
                int length;
                while ((length = myInput.read(buffer)) > 0) {
                    myOutput.write(buffer, 0, length);
                }
                myOutput.flush();
                myOutput.close();
                myInput.close();
            }
        } catch (Exception e) {
//            throw new Error("L?i không copy du?c database");
        }
    }
//    public void copyDB2SDCard1() {
//        SQLiteDatabase dbCheck = null;
//        try {
//            dbCheck = SQLiteDatabase.openDatabase(dbPath, null,
//                    SQLiteDatabase.OPEN_READWRITE);
//            if (dbCheck != null) {
//                dbCheck.close();
//            } else if (dbCheck == null) {
//                InputStream myInput = dbContext.getAssets().open("qlmt.db");
//                String outFileName = dbPath;
//                OutputStream myOutput = new FileOutputStream(outFileName);
//                byte[] buffer = new byte[1024];
//                int length;
//                while ((length = myInput.read(buffer)) > 0) {
//                    myOutput.write(buffer, 0, length);
//                }
//                myOutput.flush();
//                myOutput.close();
//                myInput.close();
//            }
//        } catch (Exception ex) {
//
//        }
//    }
//  */



    // Phuong th?c 3: M? CSDL

    public void openDB() {
        db = SQLiteDatabase.openDatabase(dbPath, null,SQLiteDatabase.OPEN_READWRITE);
    }

    // Phuong th?c 4: Ðóng CSDL

    public void closeDB() {
        db.close();
    }


    //Phuong th?c 5: Ð?c CSDL
    public Cursor getCursor(String strSQL) {
        //B1
        openDB();
        //B2
        Cursor c = db.rawQuery(strSQL, null);
        //B3
        return c;
    }

    /*public Cursor getCursor2(String sql) {
        openDB();
        Cursor cursor = null;
        try {
            cursor = db.rawQuery(sql, null);
        } catch (SQLiteException e) {
            e.printStackTrace();
            db.close();
        }
        return cursor;
    }*/


    //Phuong th?c 6: th?c thi câu l?nh SQL: Insert, Update, Delete
    public void excuteSQL(String sql) {
        //B1
        openDB();
        //B2
        db.execSQL(sql);
        //B3
        closeDB();
    }

    // Phuong th?c 7: d?m d?i tu?ng trong SQL
    public int GetCount(String sql)
    {
        openDB();
        Cursor cur=db.rawQuery(sql,null);
        int count=cur.getCount();
        closeDB();
        return  count;


    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

}
