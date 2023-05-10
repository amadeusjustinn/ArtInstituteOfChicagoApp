package com.example.artinstituteofchicagoapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.artinstituteofchicagoapp.view_models.DetailViewModel
import com.squareup.picasso.Picasso

class DetailViewFragment : Fragment() {
	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		return inflater.inflate(R.layout.fragment_detail_view, container, false)
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//		val detailImageView = view.findViewById<ImageView>(R.id.image_artwork_detailview)
//		setTransitionName(detailImageView, "hero_image")
		super.onViewCreated(view, savedInstanceState)
		val viewModel = arguments?.get("artwork") as DetailViewModel

		// Set views (top to bottom)
		val img = view.findViewById<ImageView>(R.id.image_artwork_detailview)
		Picasso.get()
			.load("https://www.artic.edu/iiif/2/${viewModel.image_id}/full/843,/0/default.jpg/")
			.placeholder(R.drawable.ic_no_image_available)
			.into(img)

		val title = view.findViewById<TextView>(R.id.text_title_detailview)
		title.text = viewModel.title

		val artist = view.findViewById<TextView>(R.id.text_artist_detailview)
		artist.text = viewModel.artistDisplay
	}
}
