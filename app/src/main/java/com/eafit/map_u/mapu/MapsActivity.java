package com.eafit.map_u.mapu;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import java.util.HashMap;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    //Propiedades mapa campus

    private int minZoom = 17;
    private final LatLng bLCorner = new LatLng(6.1932748,-75.5823696);
    private final LatLng tRCorner = new LatLng(6.203500,-75.577057);
    private final LatLngBounds MapaCampusBounds = new LatLngBounds(bLCorner, tRCorner);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Propiedades del mapa

        LatLng eafit = new LatLng(6.200072, -75.577730);
        LatLng peatonal5 = new LatLng(6.199203, -75.579390);
        LatLng bloq18 = new LatLng(6.199368, -75.578926);
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
        LatLng PorteriaRegional1= new LatLng(6.201551, -75.578933);
        LatLng bloq37 = new LatLng(6.202009, -75.578880);
        LatLng bloq38 = new LatLng(6.201619, -75.578367);
        LatLng Canchas1 = new LatLng(6.202506, -75.578631);
        LatLng Porteria4sur= new LatLng(6.202943, -75.577850);

        mMap.addMarker(new MarkerOptions().position(Porteria4sur).title("Porteria Peatonal 4 sur"));
        mMap.addMarker(new MarkerOptions().position(Canchas1).title("Canchas de tenis y futbol"));
        mMap.addMarker(new MarkerOptions().position(bloq38).title("Departamento de ciencias basicas"));
        mMap.addMarker(new MarkerOptions().position(bloq37).title("Instituto de Capacitación e Investigación del Plastico y del Caucho"));
        mMap.addMarker(new MarkerOptions().position(PorteriaRegional1).title("Porteria Regional 1 y Cafeteria"));
        mMap.addMarker(new MarkerOptions().position(bloq35).title("Bloque 35 Aulas"));
        mMap.addMarker(new MarkerOptions().position(bloq34).title("Bloque 34 Aulas"));
        mMap.addMarker(new MarkerOptions().position(bloq33).title("Oficina de Relaciones Internacionales"));
        mMap.addMarker(new MarkerOptions().position(bloq32).title("Biblioteca Luis Echavarria Villegas"));
        mMap.addMarker(new MarkerOptions().position(bloq31).title("Centro de Idiomas"));
        mMap.addMarker(new MarkerOptions().position(bloq30).title("Departamento de Música"));
        mMap.addMarker(new MarkerOptions().position(bloq29).title("Direccion Administrativa y Financiera"));
        mMap.addMarker(new MarkerOptions().position(bloq28).title("Auditorio Fundadores"));
        mMap.addMarker(new MarkerOptions().position(bloq27).title("Escuela de Derecho"));
        mMap.addMarker(new MarkerOptions().position(bloq26).title("Escuela de Administarcion, Economia y Finanzas"));
        mMap.addMarker(new MarkerOptions().position(bloq18).title("Rectoria, Dirección de docencia, Centro de Informatica, Departamento de practicas"));
        mMap.addMarker(new MarkerOptions().position(peatonal5).title("Centro Argos para la Inovación"));

        mMap.addMarker(new MarkerOptions().position(eafit).title("Porteria peatonal 1 Eafit"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(eafit));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(17.0f));
    }

}
