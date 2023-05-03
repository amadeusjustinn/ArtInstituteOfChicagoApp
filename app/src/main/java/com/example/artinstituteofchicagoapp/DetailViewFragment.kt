package com.example.artinstituteofchicagoapp

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.core.view.ViewCompat.setTransitionName
import androidx.fragment.app.Fragment

class DetailViewFragment : Fragment() {
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		val detailImageView = view.findViewById<ImageView>(R.id.image_artwork_detailview)
		setTransitionName(detailImageView, "hero_image")
	}
}
