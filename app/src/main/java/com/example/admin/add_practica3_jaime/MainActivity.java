package com.example.admin.add_practica3_jaime;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.example.admin.add_practica3_jaime.POJO.Cancion;
import com.example.admin.add_practica3_jaime.POJO.Disco;
import com.example.admin.add_practica3_jaime.POJO.Interprete;
import com.example.admin.add_practica3_jaime.base.de.datos.Contrato;
import com.example.admin.add_practica3_jaime.base.de.datos.ObtenerDatos;

import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>{

    private List<Cancion> canciones;
    private List<Disco> discos;
    private List<Interprete> interpretes;
    private Adaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        ObtenerDatos datos=new ObtenerDatos(this);

        Cursor c=getContentResolver().query(Contrato.TablaCancion.CONTENT_URI,null,null,null,null);

        adaptador = new Adaptador(this,c);
        final ListView lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(adaptador);
        getLoaderManager().initLoader(1, null, this);

    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        Uri uri = Contrato.TablaCancion.CONTENT_URI;
        return new CursorLoader(
                this, uri, null, null, null,
                Contrato.TablaCancion.TITULO +" collate localized asc");

    }
    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        adaptador.swapCursor(data);
    }
    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        adaptador.swapCursor(null);
    }

}
