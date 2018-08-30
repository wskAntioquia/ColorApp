package com.example.worldskills.colorapp.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.worldskills.colorapp.modelo.Modelo;

public class DataBase extends SQLiteOpenHelper {
    SQLiteDatabase db;
    public DataBase(Context context) {
        super(context, "ColorApp.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String puntajes= " CREATE TABLE " + Constantes.TABLA_PUNTAJES  + "("
                +Constantes._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                +Constantes.CORRECTAS + " INTEGER)";
        db.execSQL(puntajes);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }

    public boolean guardarPuntajes (Modelo m){
        ContentValues v = new ContentValues();
        db=getWritableDatabase();
        v.put(Constantes.CORRECTAS, m.getCorrectas());
        return db.insert(Constantes.TABLA_PUNTAJES, null, v)>0;

    }

    public Cursor listarPuntajes (){
        db=getReadableDatabase();
        Cursor c= db.rawQuery(" SELECT * FROM " + Constantes.TABLA_PUNTAJES  + " ORDER BY " + Constantes.CORRECTAS + " DESC LIMIT 0,4",null);
        if (c.moveToNext()){
            return c;
        } else {
            return null;
        }
    }
}
