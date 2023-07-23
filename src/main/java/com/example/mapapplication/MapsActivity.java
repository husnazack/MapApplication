package com.example.mapapplication;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.mapapplication.databinding.ActivityMapsBinding;

import android.Manifest;

import java.util.Vector;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    MarkerOptions marker;
    LatLng centerlocation;

    Vector<MarkerOptions> markerOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        centerlocation = new LatLng(3.0,101);

        markerOptions = new Vector<>();

        markerOptions.add(new MarkerOptions().title("Pusat Kesihatan UiTM Shah Alam")
                .position(new LatLng(3.0684,101.4936))
                .snippet("Open Monday - Friday : 8am - 5pm")
        );

        markerOptions.add(new MarkerOptions().title("Shah Alam Hospital")
                .position(new LatLng(3.0710,101.4899))
                .snippet("Government Hospital : 24h")
        );

        markerOptions.add(new MarkerOptions().title("Avisena Women's & Children's Specialist Hospital")
                .position(new LatLng(3.072,101.5213))
                .snippet("Private Hospital : 24h")
        );

        markerOptions.add(new MarkerOptions().title("SALAM Shah Alam Specialist Hospital")
                .position(new LatLng(3.0497,101.5354))
                .snippet("Private Hospital : 24h")
        );

        markerOptions.add(new MarkerOptions().title("KPJ Selangor Specialist Hospital")
                .position(new LatLng(3.05718,101.5415))
                .snippet("Private Hospital : 24h")
        );
        markerOptions.add(new MarkerOptions().title("MSU Medical Centre")
                .position(new LatLng(3.0769,101.55296))
                .snippet("Private Hospital : 24h")
        );
        markerOptions.add(new MarkerOptions().title("Columbia Asia Extended Care Hospital")
                .position(new LatLng(3.0473,101.5050))
                .snippet("Private Hospital : 24h")
        );
        markerOptions.add(new MarkerOptions().title("Hospital UMRA")
                .position(new LatLng(3.0829,101.53986))
                .snippet("Private Hospital : 24h")
        );



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

        // Add a marker in Sydney and move the camera
        //LatLng sydney = new LatLng(-34, 151);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        for (MarkerOptions mark : markerOptions)
        {mMap.addMarker(mark);}

        enableMyLocation();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(centerlocation,6));
    }

    /**
     * Enables the My Location layer if the fine location permission has been granted.
     */
    private void enableMyLocation() {
        // 1. Check if permissions are granted, if so, enable the my location layer
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            if (mMap != null) {
                mMap.setMyLocationEnabled(true);
            }
        } else
            {
            String perms[]={"android.permission.ACCESS_FINE_LOCATION"};
            ActivityCompat.requestPermissions (this, perms,200);
            }

        }


    }