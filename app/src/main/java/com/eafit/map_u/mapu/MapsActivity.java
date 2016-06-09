package com.eafit.map_u.mapu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.app.ProgressDialog;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;

import java.util.List;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import com.android.volley.toolbox.JsonArrayRequest;

import com.android.volley.Response;
import com.android.volley.VolleyLog;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.android.volley.VolleyError;

import com.eafit.map_u.mapu.model.Bloque;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.GoogleMap.OnMyLocationButtonClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;

import com.eafit.map_u.mapu.controller.AppController;

import com.eafit.map_u.mapu.InfoBloq;

import java.lang.reflect.Method;


//ActionBarActivity
public class MapsActivity extends AppCompatActivity implements
        OnMapReadyCallback,
        OnMyLocationButtonClickListener,
        OnMarkerClickListener {
    //ActivityCompat.OnRequestPermissionsResultCallback{

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;
    private GoogleMap mMap;

    // Log tag
    private static final String TAG = MapsActivity.class.getSimpleName();
    // Movies json url
    private static final String url = "https://map-u.herokuapp.com/blocks.json";
    private List<Bloque> bloqueList = new ArrayList<Bloque>();

    //Propiedades mapa campus

    private int minZoom = 17;
    private final LatLng UniEafit = new LatLng(6.200696D, -75.578433D);
    private final LatLng bLCorner = new LatLng(6.1932748, -75.5823696);
    private final LatLng tRCorner = new LatLng(6.203500, -75.577057);
    private final LatLngBounds MapaCampusBounds = new LatLngBounds(bLCorner, tRCorner);

    private GoogleApiClient client;
    private InfoBloq bloq = new InfoBloq();

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        // Creating volley request obj
        JsonArrayRequest bloqueReq = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        // Parsing json
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject obj = response.getJSONObject(i);
                                Bloque bloque = new Bloque();
                                bloque.setURL(obj.getString("imagen"));
                                bloque.setNombre(obj.getString("nombre"));
                                bloque.setLatitud(((Number) obj.get("latitud"))
                                        .doubleValue());
                                bloque.setLongitud(((Number) obj.get("longitud"))
                                        .doubleValue());
                                bloque.setDescripcion(obj.getString("descripcion"));
                                bloque.setNumSalones(obj.getInt("numSalones"));
                                bloqueList.add(bloque);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        refreshMap();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
            }
        });
        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(bloqueReq);


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client2 = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    // Metodo para hacer clickeable el marker
    private void setMarker() {mMap.setOnMarkerClickListener(this);}

    //Para refrescar el mapa con los marcadores desde la base de datos
    public void refreshMap() {
        for (int i = 0; i < bloqueList.size(); i++) {
            System.out.println("Creando marcadores " +
                    "titulo " + bloqueList.get(i).getNombre() +
                    " lat " + bloqueList.get(i).getLatitud() +
                    " long " + bloqueList.get(i).getLongitud());

            String name = bloqueList.get(i).getNombre();
            double lat = bloqueList.get(i).getLatitud();
            double lon = bloqueList.get(i).getLongitud();

            mMap.addMarker(new MarkerOptions()
                    .position(new LatLng(bloqueList.get(i).getLatitud(), bloqueList.get(i).getLongitud()))
                    .title(bloqueList.get(i).getNombre())
                    .icon(BitmapDescriptorFactory.fromResource(R.mipmap.location)));
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
//        mMap.setOnMarkerClickListener(this);
        //Propiedades del mapa

        mMap = googleMap;

        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);

        LatLng eafit = new LatLng(6.200072, -75.577730);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMap().setPadding(0, 1000, 0, 0);

        // Me crea el marker en la posicion deseada en el mapa

        for (int i = 0; i < bloqueList.size(); i++) {
            System.out.println("Creando marcadores " +
                    "titulo " + bloqueList.get(i).getNombre() +
                    " lat " + bloqueList.get(i).getLatitud() +
                    " long " + bloqueList.get(i).getLongitud());

            //int id = bloqueList.get(i).getId();
            String name = bloqueList.get(i).getNombre();
            double lat = bloqueList.get(i).getLatitud();
            double lon = bloqueList.get(i).getLongitud();

            mMap.addMarker(new MarkerOptions()
                    .position(new LatLng(bloqueList.get(i).getLatitud(), bloqueList.get(i).getLongitud()))
                    .title(bloqueList.get(i).getNombre())
                    .icon(BitmapDescriptorFactory.fromResource(R.mipmap.location)));
        }

        mMap.moveCamera(CameraUpdateFactory.newLatLng(eafit));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(16.0f));
        mMap.setOnMarkerClickListener(this);

        // Ubicacion del Usuario

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
            //mMap.getUiSettings().setMyLocationButtonEnabled(true);
        } else {
            System.out.println("Dafuq");
        }

    }

    /**
     * Método que se llama cuando oprimo el My Location Button
     */
    @Override
    public boolean onMyLocationButtonClick() {
        return true;
    }

    /**
     * Método que se llama cuando oprimo el Marker para saltar a otra actividad
     */
    @Override
    public boolean onMarkerClick(Marker marker) {

        final Context con = this;
        Intent intent = new Intent(con, InfoBloq.class);

        for (int i = 0; i < bloqueList.size(); i++) {
            if (bloqueList.get(i).getNombre().equals(marker.getTitle())) {
                //Toast.makeText(this,marker.getTitle(),Toast.LENGTH_LONG).show();
                bloq.Datos(bloqueList.get(i).getNombre(), bloqueList);
                intent.putExtra("title", bloqueList.get(i).getNombre());
                intent.putExtra("des", bloqueList.get(i).getDescripcion());
                intent.putExtra("numClass", bloqueList.get(i).getNumSalones());
                intent.putExtra("url", bloqueList.get(i).getURL());
                startActivity(intent);
            }
        }
        return false;
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client2.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Maps Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.eafit.map_u.mapu/http/host/path")
        );
        AppIndex.AppIndexApi.start(client2, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Maps Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.eafit.map_u.mapu/http/host/path")
        );
        AppIndex.AppIndexApi.end(client2, viewAction);
        client2.disconnect();
    }
}