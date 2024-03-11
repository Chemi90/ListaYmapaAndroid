package com.example.examenandroid2trimestre

import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.model.Marker

class CentroDetalleActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var mapa: GoogleMap
    private var nombreCentro: String? = null
    private var latitudCentro: Double = 0.0
    private var longitudCentro: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_centro_detalle)

        // Recupera los datos del Intent
        nombreCentro = intent.getStringExtra("nombreCentro")
        latitudCentro = intent.getDoubleExtra("latitudCentro", 0.0)
        longitudCentro = intent.getDoubleExtra("longitudCentro", 0.0)

        // Configura el mapa
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mapa = googleMap
        val ubicacionCentro = LatLng(latitudCentro, longitudCentro)

        // Asume que ya has obtenido la dirección y la ciudad del Intent
        val direccionCentro = intent.getStringExtra("direccionCentro") ?: ""
        val ciudadCentro = intent.getStringExtra("ciudadCentro") ?: ""

        mapa.addMarker(MarkerOptions().position(ubicacionCentro).title(nombreCentro).snippet(direccionCentro))
        mapa.moveCamera(CameraUpdateFactory.newLatLngZoom(ubicacionCentro, 15f))

        mapa.setInfoWindowAdapter(object : GoogleMap.InfoWindowAdapter {
            override fun getInfoWindow(marker: Marker): View? {
                return null // Usar el diseño predeterminado
            }

            override fun getInfoContents(marker: Marker): View {
                val infoView = layoutInflater.inflate(R.layout.custom_info_window, null)
                val infoTitle = infoView.findViewById<TextView>(R.id.title)
                val infoSnippet = infoView.findViewById<TextView>(R.id.snippet)

                infoTitle.text = marker.title
                infoSnippet.text = "${marker.snippet}, $ciudadCentro"

                return infoView
            }
        })
    }

}


