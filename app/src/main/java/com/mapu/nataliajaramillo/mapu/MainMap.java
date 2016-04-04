package com.mapu.nataliajaramillo.mapu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import java.util.ArrayList;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnCameraChangeListener;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.GoogleMap.OnMapLongClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainMap extends AppCompatActivity implements OnMapRedyCallBack {

    private GoogleMap MapaCampus;

    //Propiedades del mapa del campus.             y          x
    private final LatLng Eafit = new LatLng(6.200696,-75.578433); //Encontrado en GoogleMaps.
    private int minZoom = 17;
    private final LatLng bLCorner = new LatLng(6.1932748,-75.5823696);
    private final LatLng tRCorner = new LatLng(6.203500,-75.577057);
    private final LatLngBounds MapaCampusBounds = new LatLngBounds(bLCorner, tRCorner);

}
