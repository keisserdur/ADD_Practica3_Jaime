package com.example.admin.add_practica3_jaime.POJO;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.admin.add_practica3_jaime.base.de.datos.Contrato;

/**
 * Created by Admin on 18/01/2016.
 */
public class Cancion {
    private long id;
    private String titulo;
    private long disco;
    private long duracion;

    public Cancion() {
    }

    public Cancion(long id, String titulo, long disco, long duracion) {
        this.id = id;
        this.titulo = titulo;
        this.disco = disco;
        this.duracion = duracion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public long getDisco() {
        return disco;
    }

    public void setDisco(long disco) {
        this.disco = disco;
    }

    public long getDuracion() {
        return duracion;
    }

    public void setDuracion(long duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Cancion \n" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", disco=" + disco +
                ", duracion=" + duracion +
                "\n";
    }

    public ContentValues getContentValues(){
        ContentValues cv = new ContentValues();
        cv.put(Contrato.TablaCancion.DURATION,this.duracion);
        cv.put(Contrato.TablaCancion.TITULO,this.titulo);
        cv.put(Contrato.TablaCancion.ID_DISCO,this.disco);

        return cv;
    }

    public void set(Cursor c){
        this.id = c.getLong(c.getColumnIndex(Contrato.TablaCancion._ID));
        this.titulo = c.getString(c.getColumnIndex(Contrato.TablaCancion.TITULO));
        this.duracion= c.getLong(c.getColumnIndex(Contrato.TablaCancion.DURATION));
        this.disco= c.getLong(c.getColumnIndex(Contrato.TablaCancion.ID_DISCO));
    }
}
