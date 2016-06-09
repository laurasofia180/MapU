package com.eafit.map_u.mapu;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.android.volley.toolbox.NetworkImageView;
import com.eafit.map_u.mapu.model.Bloque;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class InfoBloq extends ActionBarActivity {

    private String nombre, name;
    private List<Bloque> bloquedescripcion;
    private String descripcion;
    private int numSalones;
    private TextView title, description, nums;

    public void Datos(String nombre, List<Bloque> bloqueList) {
        this.nombre = nombre;
        this.bloquedescripcion = bloqueList;

        for (int i = 0; i < bloquedescripcion.size(); i++) {
            if (nombre.equals(bloquedescripcion.get(i).getNombre())) {
                name = bloquedescripcion.get(i).getNombre();
                descripcion = bloquedescripcion.get(i).getDescripcion();
                numSalones = bloquedescripcion.get(i).getNumSalones();
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_bloq);

        String tit = getIntent().getExtras().getString("title");
        String des = getIntent().getExtras().getString("des");
        int numSal = getIntent().getExtras().getInt("numClass");
        String printable = Integer.toString(numSal);
        String url = getIntent().getExtras().getString("url");
        Toast.makeText(this, url, Toast.LENGTH_LONG).show();


        new Download((ImageView) findViewById(R.id.bloque))
                .execute(url);

        title = (TextView) findViewById(R.id.textView2);
        description = (TextView) findViewById(R.id.textView4);
        nums = (TextView) findViewById(R.id.textView6);

        title.setText(tit);
        description.setText(des);
        nums.setText(printable);
    }


    /**
     * Clase Asincronica para bajar las imagenes
     */
    private class Download extends AsyncTask<String, Void, Bitmap> {
        ImageView image;

        public Download(ImageView image) {
            this.image = image;
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            Bitmap bitmap = null;
            try {
                //bitmap = BitmapFactory.decodeStream((InputStream)new URL(params[0]).getContent());
                InputStream in = new java.net.URL(params[0]).openStream();
                bitmap = BitmapFactory.decodeStream(in);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        protected void onPostExecute(Bitmap result) {
            image.setImageBitmap(result);
        }
    }
}