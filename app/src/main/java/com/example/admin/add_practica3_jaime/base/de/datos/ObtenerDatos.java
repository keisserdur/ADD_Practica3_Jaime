package com.example.admin.add_practica3_jaime.base.de.datos;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import com.example.admin.add_practica3_jaime.POJO.Cancion;
import com.example.admin.add_practica3_jaime.POJO.Disco;
import com.example.admin.add_practica3_jaime.POJO.Interprete;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 19/01/2016.
 */
public class ObtenerDatos {

    private Context contexto;
    private Cursor c;
    public ObtenerDatos(Context contexto){
        this.contexto=contexto;
        c = contexto.getContentResolver().query(android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, MediaStore.Audio.Media.IS_MUSIC + " = 1", null, null);
        listaCanciones();
        listaDisco();
        listaInterprete();
    }

    public List<Cancion> listaCanciones (){
        Uri uri = Contrato.TablaCancion.CONTENT_URI;

        List<Cancion> lista=new ArrayList<Cancion>();
        c.moveToFirst();
        for (int i=0;i<c.getCount();i++){
            Cancion cancion = new Cancion();
            cancion.setDuracion(c.getLong(c.getColumnIndex(MediaStore.Audio.Media.DURATION)));
            cancion.setTitulo(c.getString(c.getColumnIndex(MediaStore.Audio.Media.TITLE)));
            cancion.setDisco(c.getLong(c.getColumnIndex(MediaStore.Audio.Media._ID)));
            cancion.setId(c.getLong(c.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID)));
            lista.add(cancion);

            Cursor aux=contexto.getContentResolver().query(uri,null,Contrato.TablaCancion.TITULO+"=?",new String[]{""+cancion.getTitulo()},null);
            if(aux.getCount()==0)
                contexto.getContentResolver().insert(uri, cancion.getContentValues());
            c.moveToNext();
        }


        return lista;
    }
    public List<Disco> listaDisco (){
        Uri uri = Contrato.TablaDisco.CONTENT_URI;

        List<Disco> lista=new ArrayList<Disco>();
        c.moveToFirst();
        for (int i=0;i<c.getCount();i++){
            Disco disco=new Disco();
            disco.setNombre(c.getString(c.getColumnIndex(MediaStore.Audio.Media.ALBUM)));
            disco.setInterprete(c.getLong(c.getColumnIndex(MediaStore.Audio.Media.ARTIST_ID)));
            disco.setId(c.getLong(c.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID)));
            lista.add(disco);

            contexto.getContentResolver().insert(uri, disco.getContentValues());
            c.moveToNext();
        }

        return lista;
    }
    public List<Interprete> listaInterprete (){
        Uri uri = Contrato.TablaInterprete.CONTENT_URI;

        List<Interprete> lista=new ArrayList<Interprete>();
        c.moveToFirst();
        for (int i=0;i<c.getCount();i++){
            Interprete interprete=new Interprete();
            interprete.setNombre(c.getString(c.getColumnIndex(MediaStore.Audio.Media.ARTIST)));
            interprete.setId(c.getLong(c.getColumnIndex(MediaStore.Audio.Media.ARTIST_ID)));
            lista.add(interprete);

            contexto.getContentResolver().insert(uri, interprete.getContentValues());
            c.moveToNext();
        }

        return lista;
    }

}
