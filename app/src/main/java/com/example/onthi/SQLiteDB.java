package com.example.onthi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.onthi.model.Classroom;
import com.example.onthi.model.Student;

import java.util.ArrayList;
import java.util.List;

public class SQLiteDB extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "database.db";
    private static final int DATABASE_VERSION = 1;

    public SQLiteDB(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql1 = "CREATE TABLE student(" +
                "ma INTEGER PRIMARY KEY AUTOINCREMENT," +
                "ten TEXT," +
                "namSinh TEXT," +
                "queQuan TEXT," +
                "namHoc TEXT);";

        String sql2 = "CREATE TABLE classroom(" +
                "ma INTEGER PRIMARY KEY AUTOINCREMENT," +
                "ten TEXT," +
                "moTa TEXT);";

        db.execSQL(sql1);
        db.execSQL(sql2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addStudent(Student student) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("ten", student.getTen());
        contentValues.put("namSinh", student.getNamSinh());
        contentValues.put("queQuan", student.getQueQuan());
        contentValues.put("namHoc", student.getNamHoc());

        SQLiteDatabase db = getWritableDatabase();
        db.insert("student", null, contentValues);
    }

    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("student", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            int ma = cursor.getInt(0);
            String ten = cursor.getString(1);
            String namSinh = cursor.getString(2);
            String queQuan = cursor.getString(3);
            String namHoc = cursor.getString(4);

            list.add(new Student(ma, ten, namSinh, queQuan, namHoc));
        }
        cursor.close();

        return list;
    }

    public void addClassroom(Classroom cl) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("ten", cl.getTen());
        contentValues.put("moTa", cl.getMoTa());

        SQLiteDatabase db = getWritableDatabase();
        db.insert("classroom", null, contentValues);
    }

    public List<Classroom> getAllClassrooms() {
        List<Classroom> list = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("classroom", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            int ma = cursor.getInt(0);
            String ten = cursor.getString(1);
            String moTa = cursor.getString(2);

            list.add(new Classroom(ma, ten, moTa));
        }
        cursor.close();

        return list;
    }
}
