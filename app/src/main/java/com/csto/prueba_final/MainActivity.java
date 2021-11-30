package com.csto.prueba_final;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_votar,btn_resultado;
    RadioGroup RG_voto; RadioButton Rb_nulo,Rb_kast,Rb_boric;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_votar=(Button)findViewById(R.id.btn_votar);
        btn_resultado=(Button)findViewById(R.id.btn_resultados);
        RG_voto=(RadioGroup)findViewById(R.id.radio_gru);
        Rb_nulo=(RadioButton)findViewById(R.id.radio_nulo);
        Rb_boric=(RadioButton)findViewById(R.id.radio_boric);
        Rb_kast=(RadioButton)findViewById(R.id.radio_kast);
        ContentValues BD = new ContentValues();



        btn_votar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Rb_nulo.isChecked()==false || Rb_boric.isChecked()==false || Rb_kast.isChecked()==false){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("votara en blanco ?")
                            .setPositiveButton("listo", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    SQLiteDatabase db;
                                    Dbhelper conn = new Dbhelper(getApplicationContext());
                                    db = conn.getReadableDatabase();
                                    db.insert("votos",null,BD);
                                    Intent I = new Intent(getApplicationContext(),MainActivity2.class);
                                    startActivity(I);
                                }
                            })
                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                }
                            });
                    builder.create();
                    builder.show();
                }
                SQLiteDatabase db;
                Dbhelper conn = new Dbhelper(getApplicationContext());
                db= conn.getWritableDatabase();
                if(Rb_nulo.isChecked()==true){
                    BD.put("rb_nulo",Rb_nulo.getText().toString());
                    db.insert("votos",null,BD);
                    Toast.makeText(getApplicationContext(),"Guardado", Toast.LENGTH_LONG).show();
                    Intent I = new Intent(getApplicationContext(),MainActivity2.class);
                    startActivity(I);
                }
                if(Rb_boric.isChecked()==true){

                    BD.put("rb_boric",Rb_boric.getText().toString());
                    db.insert("votos",null,BD);
                    Toast.makeText(getApplicationContext(),"Guardado", Toast.LENGTH_LONG).show();
                    Intent I = new Intent(getApplicationContext(),MainActivity2.class);
                    startActivity(I);
                }
                if(Rb_kast.isChecked()==true){
                    BD.put("rb_kast",Rb_kast.getText().toString());
                    db.insert("votos",null,BD);
                    Toast.makeText(getApplicationContext(),"Guardado", Toast.LENGTH_LONG).show();
                    Intent I = new Intent(getApplicationContext(),MainActivity2.class);
                    startActivity(I);
                }


            }
        });
        btn_resultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(),MainActivity2.class);
                I.putExtra("Blanco","0");
                I.putExtra("Nulo","0");
                I.putExtra("Boric","0");
                I.putExtra("Kast","0");
                startActivity(I);
            }
        });
    }
}

