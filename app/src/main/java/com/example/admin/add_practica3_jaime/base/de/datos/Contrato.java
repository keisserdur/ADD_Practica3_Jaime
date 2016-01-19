package com.example.admin.add_practica3_jaime.base.de.datos;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Admin on 18/01/2016.
 */
public class Contrato {
    private Contrato(){

    }

    public static abstract class TablaDisco implements BaseColumns{
        public static final String TABLADISCO ="disco";
        public static final String NOMBRE ="nombre";
        public static final String ID_INTERPRETE ="interprete";

        public final static String AUTHORITY = "com.example.admin.add_practica3_jaime.ProveedorDisco";

        public final static Uri CONTENT_URI =
                Uri.parse("content://" + AUTHORITY + "/" + TABLADISCO);
        public final static String SINGLE_MIME =
                "vnd.android.cursor.item/vnd." + AUTHORITY + TABLADISCO;
        public final static String MJLTIPLE_MIME =
                "vnd.android.cursor.dir/vnd." + AUTHORITY + TABLADISCO;

    }
    public static abstract class TablaInterprete implements BaseColumns{
        public static final String TABLA ="interprete";
        public static final String NOMBRE ="nombre";

        public final static String AUTHORITY = "com.example.admin.add_practica3_jaime.ProveedorInterprete";

        public final static Uri CONTENT_URI =
                Uri.parse("content://" + AUTHORITY + "/" + TABLA);
        public final static String SINGLE_MIME =
                "vnd.android.cursor.item/vnd." + AUTHORITY + TABLA;
        public final static String MJLTIPLE_MIME =
                "vnd.android.cursor.dir/vnd." + AUTHORITY + TABLA;

    }
    public static abstract class TablaCancion implements BaseColumns{
        public static final String TABLA ="cancion";
        public static final String TITULO ="titulo";
        public static final String ID_DISCO ="disco";
        public static final String DURATION ="duration";

        public final static String AUTHORITY = "com.example.admin.add_practica3_jaime.ProveedorCancion";

        public final static Uri CONTENT_URI =
                Uri.parse("content://" + AUTHORITY + "/" + TABLA);
        public final static String SINGLE_MIME =
                "vnd.android.cursor.item/vnd." + AUTHORITY + TABLA;
        public final static String MJLTIPLE_MIME =
                "vnd.android.cursor.dir/vnd." + AUTHORITY + TABLA;

    }
}
