package com.example.admin.add_practica3_jaime.POJO;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.admin.add_practica3_jaime.base.de.datos.Contrato;

/**
 * Created by Admin on 18/01/2016.
 */
public class Interprete {
    private long id;
    private String nombre;

    public Interprete() {
    }

    public Interprete(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Interprete\n" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '\n';
    }

    public ContentValues getContentValues(){
        ContentValues cv = new ContentValues();
        cv.put(Contrato.TablaInterprete.NOMBRE,this.nombre);
        return cv;
    }

    public void set(Cursor c){
        this.id = c.getLong(c.getColumnIndex(Contrato.TablaInterprete._ID));
        this.nombre = c.getString(c.getColumnIndex(Contrato.TablaInterprete.NOMBRE));
    }
}
