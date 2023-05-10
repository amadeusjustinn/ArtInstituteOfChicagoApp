package com.example.artinstituteofchicagoapp.helpers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.ViewCompat.setTransitionName
import androidx.recyclerview.widget.RecyclerView
import com.example.artinstituteofchicagoapp.R
import com.example.artinstituteofchicagoapp.data_classes.Data
import com.squareup.picasso.Picasso

class GalleryAdapter(private val artworksList: MutableList<Data>) :
	RecyclerView.Adapter<GalleryAdapter.ViewHolder>() {
	var onItemClick: ((Data) -> Unit)? = null

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		val view = LayoutInflater.from(parent.context)
			.inflate(R.layout.grid_member, parent, false)
		return ViewHolder(view)
	}

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		return holder.bind(artworksList[position])
	}

	override fun getItemCount(): Int {
		return artworksList.size
	}

	inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
		private var artworkImg = itemView.findViewById<ImageView>(R.id.image_artwork_galleryview)
		private var artworkTitle = itemView.findViewById<TextView>(R.id.text_title_galleryview)
		private var artworkArtist =
			itemView.findViewById<TextView>(R.id.text_artist_galleryview)

		init {
			itemView.setOnClickListener { onItemClick?.invoke(artworksList[adapterPosition]) }
		}

		fun bind(artwork: Data) {
//			setTransitionName(artworkImg, artwork.id.toString())
			Picasso.get()
				.load("https://www.artic.edu/iiif/2/${artwork.image_id}/full/843,/0/default.jpg/")
				.placeholder(R.drawable.ic_no_image_available)
				.into(artworkImg)
			artworkTitle.text = artwork.title
			artworkArtist.text = artwork.artist_display
		}
	}
}
