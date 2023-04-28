package com.example.artinstituteofchicagoapp

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.core.view.ViewCompat.setTransitionName
import androidx.fragment.app.Fragment

class DetailView : Fragment() {
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		val galleryImageView = view.findViewById<ImageView>(R.id.detailArtworkImg)
		setTransitionName(galleryImageView, "hero_image")
	}
}
