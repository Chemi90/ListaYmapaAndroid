package com.example.examenandroid2trimestre

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

    class CentroAdapter(private val listaCentros: List<Centro>, private val listener: OnItemClickListener) : RecyclerView.Adapter<CentroViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CentroViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.centro_item, parent, false)
        return CentroViewHolder(itemView, listener)
    }

        override fun onBindViewHolder(holder: CentroViewHolder, position: Int) {
            val centroActual = listaCentros[position]
            holder.nombreTextView.text = centroActual.nombre
            holder.imageViewCentro.setImageResource(centroActual.imagenId)
        }

    override fun getItemCount() = listaCentros.size

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}
