package ucsal.br.eventoja;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class FragmentMaps extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Double lat = null;
    private Double lng = null;
    private String nomeEvento = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Intent intent = getIntent();
        lat = Double.parseDouble(intent.getStringExtra("lat"));
        lng = Double.parseDouble(intent.getStringExtra("lng"));
        nomeEvento = intent.getStringExtra("nomeEvento");
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng posicao = new LatLng(lat, lng);
        mMap.addMarker(new MarkerOptions().position(posicao).title(nomeEvento));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(posicao, 18.0f));
    }
}
