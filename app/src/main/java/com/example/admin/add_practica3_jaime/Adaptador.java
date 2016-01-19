package com.example.admin.add_practica3_jaime;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.admin.add_practica3_jaime.base.de.datos.Contrato;

/**
 * Created by Admin on 19/01/2016.
 */
public class Adaptador extends CursorAdapter {

    public Adaptador(Context context,Cursor c){
        super(context, c, true);

    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater i=LayoutInflater.from(parent.getContext());
        View vista =i.inflate(R.layout.item,parent,false);


        return vista;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView t1, t2, t3,t4;
        t1 = (TextView) view.findViewById(R.id.textView2);
        t2 = (TextView) view.findViewById(R.id.textView3);
        t3 = (TextView) view.findViewById(R.id.textView4);
        t4 = (TextView) view.findViewById(R.id.textView5);

        String autor = "", titulo = "", strdisco = "", duracion = "";


        titulo = cursor.getString(cursor.getColumnIndex(Contrato.TablaCancion.TITULO));
        duracion = cursor.getLong(cursor.getColumnIndex(Contrato.TablaCancion.DURATION)) / 1000 + " segundos";

        Cursor disco = context.getContentResolver().query(Contrato.TablaDisco.CONTENT_URI, null, Contrato.TablaDisco._ID + "=?", new String[]{"" + cursor.getLong(cursor.getColumnIndex(Contrato.TablaCancion.ID_DISCO))}, null);
        disco.moveToFirst();
        if (disco.getCount() > 0) {
            strdisco = disco.getString(disco.getColumnIndex(Contrato.TablaDisco.NOMBRE));
            Cursor interprete = context.getContentResolver().query(Contrato.TablaInterprete.CONTENT_URI, null, Contrato.TablaInterprete._ID + "=?", new String[]{"" + disco.getLong(disco.getColumnIndex(Contrato.TablaDisco.ID_INTERPRETE))}, null);
            interprete.moveToFirst();
            if(interprete.getCount()>0)
                autor = interprete.getString(interprete.getColumnIndex(Contrato.TablaInterprete.NOMBRE));
        }

        if(!titulo.isEmpty()){
            t1.setText(titulo);
        }else {
            t1.setText("Sin titulo");
        }
        if (!strdisco.isEmpty()) {
            t2.setText(strdisco);
        } else{
            t2.setText("Unknown");
        }
        if(!duracion.isEmpty()) {
            t3.setText(duracion);
        }
        if(!autor.isEmpty()) {
            t4.setText(autor);
        }else{
            t4.setText("Unknown artist");
        }

    }
}
