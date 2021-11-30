package com.csto.prueba_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView tex_BLANCO,tex_NULO,tex_BORIC,tex_kast;
    Button btn_volver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tex_BLANCO =(TextView) findViewById(R.id.text_blanco);
        tex_NULO = (TextView)findViewById(R.id.text_nulo);
        tex_BORIC =(TextView)findViewById(R.id.text_b);
        tex_kast =(TextView)findViewById(R.id.text_k);

        btn_volver= (Button)findViewById(R.id.BTN_VOLVER);

        Integer Blanco=0,Nulo=0,Boric=0, Kast=0;

        SQLiteDatabase db;
        Dbhelper conn = new Dbhelper(getApplicationContext());
        db= conn.getReadableDatabase();
        Cursor C =db.query("voto",null,null,null,null,null,null);
        if(C!=null)
        {
            if(C.moveToFirst())
            {
                do{
                    if(C.getString(2).equals("N"))
                    {
                        Nulo++; //incrementar el contador total

                    }
                    if (C.getString(2).equals("B"))
                    {
                        Boric++; //incrementar el contador total
                    }
                    if (C.getString(2).equals("K"))
                    {
                        Kast++; //incrementar el contador total
                    }
                    else
                    {
                        Blanco++; //incrementar el contador total

                    }
                }
                while(C.moveToNext());
            }

        }
        tex_BLANCO.setText(""+Blanco);
        tex_NULO.setText(""+Nulo);
        tex_BORIC.setText(""+Boric);
        tex_kast.setText(""+Kast);

        btn_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent I = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(I);

            }
        });

    }
}
