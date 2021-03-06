package com.example.myapmaps;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

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

        // Add a marker in Sydney and move the camera
        LatLng home = new LatLng(-2.82330, 120.14314);
        LatLng alfamidi = new LatLng( -2.847244, 120.123472);
        mMap.addMarker(new MarkerOptions().position(home).title("Home").
                snippet("Fatika Mawar").icon(BitmapFromVector(getApplicationContext(),R.drawable.start)));
        mMap.addMarker(new MarkerOptions().position(alfamidi).title("AlfaMidi").
                snippet("Fatika Mawar").icon(BitmapFromVector(getApplicationContext(),R.drawable.finisih)));
        mMap.addPolyline(new PolylineOptions().add(
                home,
                new LatLng(-2.822990, 120.142978),
                new LatLng(-2.823717, 120.141947),
                new LatLng(-2.825348, 120.139961),
                new LatLng(-2.825583, 120.139717),
                new LatLng(-2.829186, 120.134193),
                new LatLng(-2.838203, 120.124353),
                new LatLng(-2.839554, 120.122675),
                new LatLng(-2.843283, 120.120992),
                new LatLng(-2.845444, 120.121682),
                new LatLng(-2.846226, 120.122532),
                new LatLng(-2.846477, 120.122851),
                new LatLng(-2.847182, 120.123550),
                alfamidi
                ).width(20)
                        .color(Color.rgb(0, 129, 227))
        );
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(home, 14.5f));
    }

    private BitmapDescriptor BitmapFromVector(Context context, int vectorResId) {
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorResId);

        vectorDrawable.setBounds(0, 0, vectorDrawable.getIntrinsicWidth(),
                vectorDrawable.getIntrinsicHeight());

        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(),
                vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bitmap);

        vectorDrawable.draw(canvas);

        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }
}