package com.csto.prueba_final;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Dbhelper  extends SQLiteOpenHelper {
 public  static String Nombre_BD="VOTITO.db";
    public  static  int Version_DB=1;
    public  static  String tabla_votos= "create table votos (id_voto integer  primary key autoincrement,voto_blaco integer,voto_nulo integer,voto_boric integer,voto_kast integer)";

    public Dbhelper(Context context) {
        super(context, Nombre_BD, null, Version_DB);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(tabla_votos);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists votos");
        sqLiteDatabase.execSQL(tabla_votos);

    }
}
