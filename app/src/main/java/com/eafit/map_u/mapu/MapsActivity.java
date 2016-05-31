package com.eafit.map_u.mapu;

import android.content.Intent;
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

import java.lang.reflect.Method;


//ActionBarActivity
public class MapsActivity extends AppCompatActivity  implements
        OnMapReadyCallback,
        OnMyLocationButtonClickListener,
        OnMarkerClickListener{
        //ActivityCompat.OnRequestPermissionsResultCallback{

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;
    private GoogleMap mMap;

    // Log tag
    private static final String TAG = MapsActivity.class.getSimpleName();
    // Movies json url
    private static final String url = "https://mapu.herokuapp.com/blocks.json";
    private List<Bloque> bloqueList = new ArrayList<Bloque>();

    //Propiedades mapa campus

    private int minZoom = 17;
    private final LatLng UniEafit = new LatLng(6.200696D, -75.578433D);
    private final LatLng bLCorner = new LatLng(6.1932748, -75.5823696);
    private final LatLng tRCorner = new LatLng(6.203500, -75.577057 );
    private final LatLngBounds MapaCampusBounds = new LatLngBounds(bLCorner, tRCorner);

    private GoogleApiClient client;

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
                                bloque.setId(obj.getInt("id"));
                                bloque.setNombre(obj.getString("nombre"));
                                bloque.setLatitud(((Number) obj.get("latitud"))
                                        .doubleValue());
                                bloque.setLongitud(((Number) obj.get("longitud"))
                                        .doubleValue());
                                // adding motel to motels array
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


    }

   // Metodo para hacer clickeable el marker
    private void setMarker() {

        mMap.setOnMarkerClickListener(this);
    }

   //Para refrescar el mapa con los marcadores desde la base de datos
    public void refreshMap(){
        for (int i = 0; i < bloqueList.size(); i++) {
            System.out.println("Creando marcadores "+
                    "titulo "+bloqueList.get(i).getNombre()+
                    " lat "+bloqueList.get(i).getLatitud()+
                    " long "+bloqueList.get(i).getLongitud());

            int id = bloqueList.get(i).getId();
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
        LatLng eafit = new LatLng(6.200072, -75.577730);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMap().setPadding(0, 1000, 0, 0);

        // Me crea el marker en la posicion deseada en el mapa

        for (int i = 0; i < bloqueList.size(); i++) {
            System.out.println("Creando marcadores "+
                    "titulo "+bloqueList.get(i).getNombre()+
                    " lat "+bloqueList.get(i).getLatitud()+
                    " long "+bloqueList.get(i).getLongitud());

            int id = bloqueList.get(i).getId();
            String name = bloqueList.get(i).getNombre();
            double lat = bloqueList.get(i).getLatitud();
            double lon = bloqueList.get(i).getLongitud();

            mMap.addMarker(new MarkerOptions()
                    .position(new LatLng(bloqueList.get(i).getLatitud(), bloqueList.get(i).getLongitud()))
                    .title(bloqueList.get(i).getNombre())
                    .icon(BitmapDescriptorFactory.fromResource(R.mipmap.location)));
        }

//        mMap.addMarker(new MarkerOptions().position(eafit).title("Porteria 1 Peatonal Av. Las Vegas Eafit")
//                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.location)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(eafit));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(16.0f));
        mMap.setOnMarkerClickListener(this);
        // Ubicacion del Usuario

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
        } else {
            System.out.println("Dafuq");
        }
        mMap.getUiSettings().setMyLocationButtonEnabled(true);

    }
    /**
     * Método que se llama cuando oprimo el My Location Button
     */
    @Override
    public boolean onMyLocationButtonClick() {
        return false;
    }

    /**
     *
     * Método que se llama cuando oprimo el Marker me salta a otra actividad
     */
        @Override
        public boolean onMarkerClick(Marker marker) {

            final Context con = this;
            Intent intent = new Intent(con, InfoBloq.class);
            for (int i = 0;i<bloqueList.size();i++){
                if(bloqueList.get(i).getNombre().equals(marker.getTitle())){
                    Toast.makeText(this,marker.getTitle(),
                            Toast.LENGTH_LONG).show();
                    startActivity(intent);
                }
            }
            if (marker.getTitle().equals("Rectoria, Dirección de docencia, Centro de Informatica, Departamento de practicas")){
                //final Context con = this;
                //Intent intent = new Intent(con, InfoBloq.class);

            }
        return false;
    }

}
