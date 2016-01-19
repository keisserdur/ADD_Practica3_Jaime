package com.example.admin.add_practica3_jaime.base.de.datos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Admin on 18/01/2016.
 */
public class Ayudante extends SQLiteOpenHelper {

    public static final String DATABASA_NAME="musica.sqlite";
    public static final int DATABASE_VERSION=1;

    public Ayudante(Context context) {
        super(context, DATABASA_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql;
        sql="CREATE TABLE "+ Contrato.TablaCancion.TABLA+" (" +
                Contrato.TablaCancion._ID+" integer primary key autoincrement," +
                Contrato.TablaCancion.TITULO+" text unique," +
                Contrato.TablaCancion.ID_DISCO+" integer, " +
                Contrato.TablaCancion.DURATION+" integer)";
        db.execSQL(sql);

        sql="CREATE TABLE "+ Contrato.TablaDisco.TABLADISCO+" (" +
                Contrato.TablaDisco._ID+" integer primary key autoincrement," +
                Contrato.TablaDisco.NOMBRE+" text," +
                Contrato.TablaDisco.ID_INTERPRETE+" integer)";
        db.execSQL(sql);

        sql="CREATE TABLE "+ Contrato.TablaInterprete.TABLA+" (" +
                Contrato.TablaInterprete._ID+" integer primary key autoincrement," +
                Contrato.TablaInterprete.NOMBRE+" text)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql="drop table if exists "
                + Contrato.TablaCancion.TABLA;
        db.execSQL(sql);

        sql="drop table if exists "
                + Contrato.TablaDisco.TABLADISCO;
        db.execSQL(sql);

        sql="drop table if exists "
                + Contrato.TablaInterprete.TABLA;
        db.execSQL(sql);

        onCreate(db);
    }
}
