package com.example.artinstituteofchicagoapp.helpers

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.artinstituteofchicagoapp.R
import com.example.artinstituteofchicagoapp.object_classes.Data
import com.squareup.picasso.Picasso

class ImgAdapter(private val artworksList: MutableList<Data>) :
	RecyclerView.Adapter<ImgAdapter.ViewHolder>() {
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		val view = LayoutInflater.from(parent.context)
			.inflate(R.layout.grid_member, parent, false)
		return ViewHolder(view)
	}

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		Log.d("onBindViewHolder", "Item count: $itemCount")
		return holder.bind(artworksList[position])
	}

	override fun getItemCount(): Int {
		return artworksList.size
	}

	class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
		private var artworkImg = itemView.findViewById<ImageView>(R.id.artworkImg)
		private var artworkTitle = itemView.findViewById<TextView>(R.id.artworkTitle)
		private var artworkArtist = itemView.findViewById<TextView>(R.id.artworkArtist)

		fun bind(artwork: Data) {
			Picasso.get()
				.load("https://www.artic.edu/iiif/2/${artwork.image_id}/full/843,/0/default.jpg/")
				.into(artworkImg)
			artworkTitle.text = artwork.title
			artworkArtist.text = artwork.artist_display
		}
	}
}
