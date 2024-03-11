package com.example.examenandroid2trimestre

data class Centro(
    val nombre: String,
    val direccion: String,
    val ciudad: String,
    val imagenId: Int, // Este es el cambio, de 'imagen' a 'imagenId'
    val latitud: Double,
    val longitud: Double
)
