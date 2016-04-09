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
        LatLng bloq31 = new LatLng(6.200319, -75.578143);
        LatLng bloq29 = new LatLng(6.200320, -75.578643);
        LatLng bloq28 = new LatLng(6.200336, -75.578966);
        LatLng bloq27 = new LatLng(6.200301, -75.579148);
        LatLng bloq30 = new LatLng(6.200634, -75.579070);
        LatLng bloq32 = new LatLng(6.201051, -75.578436);
        mMap.addMarker(new MarkerOptions().position(bloq32).title("Biblioteca Luis Echavarria Villegas"));
        mMap.addMarker(new MarkerOptions().position(bloq30).title("Departamento de Música"));
        mMap.addMarker(new MarkerOptions().position(bloq27).title("Escuela de Derecho"));
        mMap.addMarker(new MarkerOptions().position(bloq28).title("Auditorio Fundadores"));
        mMap.addMarker(new MarkerOptions().position(bloq29).title("Direccion Administrativa y Financiera"));
        mMap.addMarker(new MarkerOptions().position(bloq31).title("Centro de Idiomas"));
        mMap.addMarker(new MarkerOptions().position(eafit).title("Eafit"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(eafit));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(17.0f));
    }

}
