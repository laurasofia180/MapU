package com.eafit.map_u.mapu;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.android.volley.toolbox.NetworkImageView;
import com.eafit.map_u.mapu.model.Bloque;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class InfoBloq extends ActionBarActivity {
    private String nombre, name;
    private List<Bloque> bloquedescripcion ;
    private String descripcion;
    private int numSalones;
    private TextView title, description, nums;


    public void Datos (String nombre, List<Bloque> bloqueList) {
        this.nombre = nombre;
        this.bloquedescripcion = bloqueList;

        for (int i = 0; i < bloquedescripcion.size(); i++) {
            if (nombre.equals(bloquedescripcion.get(i).getNombre())) {
                name      = bloquedescripcion.get(i).getNombre();
                descripcion = bloquedescripcion.get(i).getDescripcion();
                numSalones  = bloquedescripcion.get(i).getNumSalones();
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_bloq);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //fab.setOnClickListener(new View.OnClickListener() {
            /*@Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        String tit = getIntent().getExtras().getString("title");
        String des = getIntent().getExtras().getString("des");
        int numSal = getIntent().getExtras().getInt("numClass");
        String printable = Integer.toString(numSal);
        //Toast.makeText(this, dato_Recibido, Toast.LENGTH_LONG).show();

         title  = (TextView) findViewById(R.id.nombre);
         description  = (TextView) findViewById(R.id.descripcion);
         nums  = (TextView) findViewById(R.id.numSalones);

        title.setText(tit);
        description.setText(des);
        nums.setText(printable);
    }


 }
