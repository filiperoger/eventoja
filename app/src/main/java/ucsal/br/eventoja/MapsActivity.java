package ucsal.br.eventoja;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends SupportMapFragment implements OnMapReadyCallback {

    private GoogleMap mMap = null;
    String[] arrayArgumentos = null;

    public MapsActivity() {
    }

    @SuppressLint("ValidFragment")
    public MapsActivity(String[] arrayArgumentos) {
        this.arrayArgumentos = arrayArgumentos;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng local = new LatLng(Double.parseDouble(arrayArgumentos[0]), Double.parseDouble(arrayArgumentos[1]));
        mMap.addMarker(new MarkerOptions().position(local).title(arrayArgumentos[2]));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(local));
    }
}