package com.example.examenandroid2trimestre

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var centroAdapter: CentroAdapter
    private var listaCentros: MutableList<Centro> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listaCentros = getAllCentros() // Asegúrate de que esta línea esté llamando correctamente a tu función.
        configurarRecyclerView()
    }

    private fun prepararListaCentros() {
        listaCentros.clear()
        listaCentros.addAll(getAllCentros())
    }

    private fun configurarRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView)
        centroAdapter = CentroAdapter(listaCentros, object : CentroAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                val centroSeleccionado = listaCentros[position]
                val intent = Intent(this@MainActivity, CentroDetalleActivity::class.java).apply {
                    putExtra("nombreCentro", centroSeleccionado.nombre)
                    putExtra("latitudCentro", centroSeleccionado.latitud)
                    putExtra("longitudCentro", centroSeleccionado.longitud)
                    putExtra("direccionCentro", centroSeleccionado.direccion) // Asegúrate de agregar esto
                    putExtra("ciudadCentro", centroSeleccionado.ciudad) // Asegúrate de agregar esto
                }

                startActivity(intent)
            }
        })
        recyclerView.adapter = centroAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
