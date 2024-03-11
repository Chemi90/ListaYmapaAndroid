package com.example.examenandroid2trimestre

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CentroViewHolder(itemView: View, listener: CentroAdapter.OnItemClickListener) : RecyclerView.ViewHolder(itemView) {
    val nombreTextView: TextView = itemView.findViewById(R.id.tvCentroName)
    val imageViewCentro: ImageView = itemView.findViewById(R.id.imageViewCentro)

    init {
        itemView.setOnClickListener {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }
}
