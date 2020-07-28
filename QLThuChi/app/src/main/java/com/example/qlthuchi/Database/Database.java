package com.example.qlthuchi.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Database extends SQLiteOpenHelper {


    final String d = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());


        public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }
    public void INSERT_Thu(String khoanthu, String loaithu, String sotienthu){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO THU VALUES( ?, ?, ?, ? , null)";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1, khoanthu);
        statement.bindString(2, loaithu);
        statement.bindString(3, sotienthu);
        statement.bindString(4, d);

        statement.executeInsert();
    }
    public void INSERT_Chi(String khoanchi, String loaichi, String sotienchi){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO CHI VALUES( ?, ?, ?, ? , null)";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1, khoanchi);
        statement.bindString(2, loaichi);
        statement.bindString(3, sotienchi);
        statement.bindString(4, d);

        statement.executeInsert();
    }
    public void UPDATE_CHI(String khoanchi, String loaichi, String sotienchi , int idchi){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "UPDATE CHI SET KHOANCHI = ?, LOAICHI = ?, SOTIENCHI = ?, NGAYTHANGCHI = ? WHERE IDCHI = ?";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1, khoanchi);
        statement.bindString(2, loaichi);
        statement.bindString(3, sotienchi);
        statement.bindString(4, d);
        statement.bindLong(5, idchi);


        statement.executeInsert();
    }
    public void UPDATE_THU(String khoanthu, String loaithu, String sotienthu , int idthu){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "UPDATE THU SET KHOANTHU = ?, LOAITHU = ?, SOTIENTHU = ?, NGAYTHANGTHU = ? WHERE IDTHU = ?";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1, khoanthu);
        statement.bindString(2, loaithu);
        statement.bindString(3, sotienthu);
        statement.bindString(4, d);
        statement.bindLong(5, idthu);

        statement.executeInsert();
    }
    public void DELETE_CHI(int idchi){
            SQLiteDatabase database = getWritableDatabase();
            String sql = "DELETE FROM CHI WHERE IDCHI = ?";
            SQLiteStatement statement = database.compileStatement(sql);
            statement.clearBindings();
            statement.bindLong(1, idchi);
            statement.executeInsert();
    }
    public void DELETE_THU(int idchi){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "DELETE FROM THU WHERE IDTHU = ?";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindLong(1, idchi);
        statement.executeInsert();
    }

        public void QueryData(String sql){
            SQLiteDatabase database = getWritableDatabase() ;
            database.execSQL(sql);
        }
        public Cursor GetData(String sql){
            SQLiteDatabase database = getReadableDatabase();
            return database.rawQuery(sql, null);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }

