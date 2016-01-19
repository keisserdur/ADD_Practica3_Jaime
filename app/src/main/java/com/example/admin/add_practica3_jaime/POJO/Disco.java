package com.example.admin.add_practica3_jaime.POJO;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.admin.add_practica3_jaime.base.de.datos.Contrato;

/**
 * Created by Admin on 18/01/2016.
 */
public class Disco {
    private long id;
    private String nombre;
    private long interprete;

    public Disco() {
    }

    public Disco(long id, String nombre, long interprete) {
        this.id = id;
        this.nombre = nombre;
        this.interprete = interprete;
    }

    public long getInterprete() {
        return interprete;
    }

    public void setInterprete(long interprete) {
        this.interprete = interprete;
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
        return "Disco\n" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", interprete=" + interprete +
                '\n';
    }

    public ContentValues getContentValues(){
        ContentValues cv = new ContentValues();
        cv.put(Contrato.TablaDisco.NOMBRE,this.nombre);
        cv.put(Contrato.TablaDisco.ID_INTERPRETE,this.interprete);
        return cv;
    }

    public void set(Cursor c){
        this.id = c.getLong(c.getColumnIndex(Contrato.TablaDisco._ID));
        this.nombre = c.getString(c.getColumnIndex(Contrato.TablaDisco.NOMBRE));
        this.interprete = c.getLong(c.getColumnIndex(Contrato.TablaDisco.ID_INTERPRETE));
    }
}
