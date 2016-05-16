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
import android.widget.Toast;


import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.GoogleMap.OnMyLocationButtonClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;

import java.lang.reflect.Method;

public class MapsActivity extends ActionBarActivity implements
        OnMapReadyCallback,
        OnMyLocationButtonClickListener,
        OnMarkerClickListener,
        ActivityCompat.OnRequestPermissionsResultCallback{

    private boolean mPermissionDenied = false;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;
    private GoogleMap mMap;

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



    }

   // Metodo para hacer clickeable el marker
    private void setMarker() {

        mMap.setOnMarkerClickListener(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        //mMap.setOnMarkerClickListener(this);
        //Propiedades del mapa
        mMap = googleMap;
        LatLng eafit = new LatLng(6.200072, -75.577730);
        mMap.addMarker(new MarkerOptions().position(eafit).title("Porteria 1 Peatonal Av. Las Vegas Eafit")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.location)));
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

        // Markers

        LatLng gym = new LatLng(6.198904, -75.578045);
        LatLng cafeteriap = new LatLng(6.199213, -75.578434);
        LatLng canchas3 = new LatLng(6.198529, -75.578365);
        LatLng canchas2 = new LatLng(6.199694, -75.578378);
        LatLng peatonal5 = new LatLng(6.199203, -75.579390);
        LatLng peatonal3 = new LatLng(6.197665, -75.578389);
        LatLng vehicular2 = new LatLng(6.199538, -75.577791);
        LatLng peatonal7 = new LatLng(6.202943, -75.577850);
        LatLng vehicular8 = new LatLng(6.201817, -75.577513);
        LatLng vehicular6 = new LatLng(6.201551, -75.578933);

        LatLng bloq7 = new LatLng(6.199234, -75.578092);
        LatLng bloq12 = new LatLng(6.197330, -75.579146);
        LatLng bloq17 = new LatLng(6.199090, -75.578863);
        LatLng bloq18 = new LatLng(6.199368, -75.578926);
        LatLng bloq19 = new LatLng(6.197916, -75.579628);
        LatLng bloq20 = new LatLng(6.198479, -75.579092);
        LatLng bloq21 = new LatLng(6.198494, -75.579493);
        LatLng bloq22 = new LatLng(6.198755, -75.579217);
        LatLng bloq23 = new LatLng(6.198976, -75.579254);
        LatLng bloq26 = new LatLng(6.199832, -75.579076);
        LatLng bloq27 = new LatLng(6.200301, -75.579148);
        LatLng bloq28 = new LatLng(6.200336, -75.578966);
        LatLng bloq29 = new LatLng(6.200320, -75.578643);
        LatLng bloq30 = new LatLng(6.200634, -75.579070);
        LatLng bloq31 = new LatLng(6.200319, -75.578143);
        LatLng bloq32 = new LatLng(6.201051, -75.578436);
        LatLng bloq33 = new LatLng(6.200910, -75.578959);
        LatLng bloq34 = new LatLng(6.201117, -75.579036);
        LatLng bloq35 = new LatLng(6.201346, -75.578961);
        LatLng bloq37 = new LatLng(6.202009, -75.578880);
        LatLng bloq38 = new LatLng(6.201619, -75.578367);
        LatLng Canchas1 = new LatLng(6.202506, -75.578631);


        mMap.addMarker(new MarkerOptions().position(gym).title("Centro de Acondicionamiento Fisico")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.location)));
        mMap.addMarker(new MarkerOptions().position(canchas3).title("Cancha Sintetica")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.location)));
        mMap.addMarker(new MarkerOptions().position(peatonal3).title("Porteria 3 Vehicular y Peatonal")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.location)));
        mMap.addMarker(new MarkerOptions().position(vehicular2).title("Porteria 2 Vehicular")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.location)));
        mMap.addMarker(new MarkerOptions().position(peatonal5).title("Centro Argos para la Inovación")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.location)));
        mMap.addMarker(new MarkerOptions().position(peatonal7).title("Porteria 7 Peatonal")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.location)));
        mMap.addMarker(new MarkerOptions().position(vehicular6).title("Porteria 6 y Cafeteria")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.location)));
        mMap.addMarker(new MarkerOptions().position(vehicular8).title("Porteria 8 Vehicular")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.location)));

        mMap.addMarker(new MarkerOptions().position(Canchas1).title("Bloque 39 Canchas de tenis y futbol")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.location)));
        mMap.addMarker(new MarkerOptions().position(bloq38).title("Bloque 38 Departamento de ciencias basicas")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.location)));
        mMap.addMarker(new MarkerOptions().position(bloq37).title("Bloque 37 Instituto de Capacitación e Investigación del Plastico y del Caucho")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.location)));
        mMap.addMarker(new MarkerOptions().position(bloq35).title("Bloque 35 Aulas")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.location)));
        mMap.addMarker(new MarkerOptions().position(bloq34).title("Bloque 34 Aulas")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.location)));
        mMap.addMarker(new MarkerOptions().position(bloq33).title("Bloque 33 Oficina de Relaciones Internacionales")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.location)));
        mMap.addMarker(new MarkerOptions().position(bloq32).title("Bloque 32 Biblioteca Luis Echavarria Villegas")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.location)));
        mMap.addMarker(new MarkerOptions().position(bloq31).title("Bloque 31 Centro de Idiomas")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.location)));
        mMap.addMarker(new MarkerOptions().position(bloq30).title("Bloque 30 Departamento de Música")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.location)));
        mMap.addMarker(new MarkerOptions().position(bloq29).title("Bloque 29 Direccion Administrativa y Financiera")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.location)));
        mMap.addMarker(new MarkerOptions().position(bloq28).title("Bloque 28 Auditorio Fundadores")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.location)));
        mMap.addMarker(new MarkerOptions().position(bloq27).title("Bloque 27 Escuela de Derecho")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.location)));
        mMap.addMarker(new MarkerOptions().position(bloq26).title("Bloque 26 Escuela de Administarcion, Economia y Finanzas")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.location)));
        mMap.addMarker(new MarkerOptions().position(bloq23).title("Bloque 23 Aulas")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.location)));
        mMap.addMarker(new MarkerOptions().position(bloq22).title("Bloque 22 Laboratorios")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.location)));
        mMap.addMarker(new MarkerOptions().position(bloq21).title("Bloque 21 Talleres")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.location)));
        mMap.addMarker(new MarkerOptions().position(bloq20).title("Bloque 20 Talleres, Aulas, Oficina Representantes Estudiantiles")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.location)));
        mMap.addMarker(new MarkerOptions().position(bloq19).title("Bloque 19 Escuela de Ingenieria")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.location)));
        mMap.addMarker(new MarkerOptions().position(bloq18).title("Bloque 18 Rectoria, Dirección de docencia, Centro de Informatica, Departamento de practicas")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.location)));
        mMap.addMarker(new MarkerOptions().position(bloq17).title("Bloque 17 Laboratorio Financiero, Aulas")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.location)));
        mMap.addMarker(new MarkerOptions().position(bloq12).title("Bloque 12 Departamento de Desarrollo Artistico")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.location)));
        mMap.addMarker(new MarkerOptions().position(cafeteriap).title("Bloque 9 Cafeteria Principal")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.location)));
        mMap.addMarker(new MarkerOptions().position(bloq7).title("Bloque 7 Carnetizacion, Aulas, univesidad de los niños")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.location)));
        mMap.addMarker(new MarkerOptions().position(canchas2).title("Bloque 4 Piscina y Cancha cubierta")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.location)));
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


            switch (marker.getTitle()) {

                case "Centro de Acondicionamiento Fisico":
                    Toast.makeText(getApplicationContext(), "Centro de Acondicionamiento Fisico",
                            Toast.LENGTH_SHORT).show();
                     startActivity(intent);
                    break;
                case "Cancha Sintetica":
                    Toast.makeText(getApplicationContext(), "Cancha Sintetica",
                            Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    break;
                case "Porteria 3 Vehicular y Peatonal":
                    Toast.makeText(getApplicationContext(), "Porteria 3 Vehicular y Peatonal",
                            Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    break;
                case "Porteria 2 Vehicular":
                    Toast.makeText(getApplicationContext(), "Porteria 2 Vehicular",
                            Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    break;
                case "Centro Argos para la Inovación":
                    Toast.makeText(getApplicationContext(), "Centro Argos para la Inovación",
                            Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    break;
                case "Porteria 7 Peatonal":
                    Toast.makeText(getApplicationContext(), "Porteria 7 Peatonal",
                            Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    break;
                case "Porteria 6 y Cafeteria":
                    Toast.makeText(getApplicationContext(), "Porteria 6 y Cafeteria",
                            Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    break;
                case "Porteria 8 Vehicular":
                    Toast.makeText(getApplicationContext(), "Porteria 8 Vehicular",
                            Toast.LENGTH_SHORT).show();
                    startActivity(intent);

                    break;
                case "Bloque 4 Piscina y Cancha cubierta":
                    Toast.makeText(getApplicationContext(), "Bloque 4 Piscina y Cancha cubierta",
                            Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    break;
                case "Bloque 7 Carnetizacion, Aulas, univesidad de los niños":
                    Toast.makeText(getApplicationContext(), "Bloque 7 Carnetizacion, Aulas, univesidad de los niños",
                            Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    break;
                case "Bloque 9 Cafeteria Principal":
                    Toast.makeText(getApplicationContext(), "Bloque 9 Cafeteria Principal",
                            Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    break;
                case "Bloque 12 Departamento de Desarrollo Artistico":
                    Toast.makeText(getApplicationContext(), "Bloque 12 Departamento de Desarrollo Artistico",
                            Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    break;
                case "Bloque 17 Laboratorio Financiero, Aulas":
                    Toast.makeText(getApplicationContext(), "Bloque 17 Laboratorio Financiero, Aulas",
                            Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    break;
                case "Bloque 18Rectoria, Dirección de docencia, Centro de Informatica, Departamento de practicas":
                    Toast.makeText(getApplicationContext(), "Bloque 18Rectoria, Dirección de docencia, Centro de Informatica, Departamento de practicas",
                            Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    break;
                case "Bloque 19 Escuela de Ingenieria":
                    Toast.makeText(getApplicationContext(), "Bloque 19 Escuela de Ingenieria",
                            Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    break;
                case "Bloque 20 Talleres, Aulas, Oficina Representantes Estudiantiles":
                    Toast.makeText(getApplicationContext(), "Bloque 20 Talleres, Aulas, Oficina Representantes Estudiantiles",
                            Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    break;
                case "Bloque 21 Talleres":
                    Toast.makeText(getApplicationContext(), "Bloque 21 Talleres",
                            Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    break;
                case "Bloque 22 Laboratorios":
                    Toast.makeText(getApplicationContext(), "Bloque 22 Laboratorios",
                            Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    break;
                case "Bloque 23 Aulas":
                    Toast.makeText(getApplicationContext(), "Bloque 23 Aulas",
                            Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    break;
                case "Bloque 26 Escuela de Administarcion, Economia y Finanzas":
                    Toast.makeText(getApplicationContext(), "Bloque 26 Escuela de Administarcion, Economia y Finanzas",
                            Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    break;
                case "Bloque 27 Escuela de Derecho":
                    Toast.makeText(getApplicationContext(), "Bloque 27 Escuela de Derecho",
                            Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    break;
                case "Bloque 28 Auditorio Fundadores":
                    Toast.makeText(getApplicationContext(), "Bloque 28 Auditorio Fundadores",
                            Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    break;
                case "Bloque 29 Direccion Administrativa y Financiera":
                    Toast.makeText(getApplicationContext(), "Bloque 29 Direccion Administrativa y Financiera",
                            Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    break;
                case "Bloque 30 Departamento de Música":
                    Toast.makeText(getApplicationContext(), "Bloque 30 Departamento de Música",
                            Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    break;
                case "Bloque 31 Centro de Idiomas":
                    Toast.makeText(getApplicationContext(), "Bloque 31 Centro de Idiomas",
                            Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    break;
                case "Bloque 32 Biblioteca Luis Echavarria Villegas":
                    Toast.makeText(getApplicationContext(), "Bloque 32 Biblioteca Luis Echavarria Villegas",
                            Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    break;
                case "Bloque 33 Oficina de Relaciones Internacionales":
                    Toast.makeText(getApplicationContext(), "Bloque 33 Oficina de Relaciones Internacionales",
                            Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    break;
                case "Bloque 34 Aulas":
                    Toast.makeText(getApplicationContext(), "Bloque 31 Centro de Idiomas",
                            Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    break;
                case "Bloque 35 Aulas":
                    Toast.makeText(getApplicationContext(), "Bloque 35 Aulas",
                            Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    break;
                case "Bloque 37 Instituto de Capacitación e Investigación del Plastico y del Caucho":
                    Toast.makeText(getApplicationContext(), "Bloque 37 Instituto de Capacitación e Investigación del Plastico y del Caucho",
                            Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    break;
                case "Bloque 38 Departamento de ciencias basicas":
                    Toast.makeText(getApplicationContext(), "Bloque 38 Departamento de ciencias basicas",
                            Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    break;
                 case "Bloque 39 Canchas de tenis y futbol":
                     Toast.makeText(getApplicationContext(), "Bloque 39 Canchas de tenis y futbol",
                             Toast.LENGTH_SHORT).show();
                     startActivity(intent);
                    break;



                //if (marker.getTitle().equals("Rectoria, Dirección de docencia, Centro de Informatica, Departamento de practicas")){
            //final Context con = this;
            //Intent intent = new Intent(con, InfoBloq.class);
            //startActivity(intent);
        }

        return false;
    }

}
