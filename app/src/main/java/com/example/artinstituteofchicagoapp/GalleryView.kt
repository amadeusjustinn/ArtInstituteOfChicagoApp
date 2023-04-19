package com.example.artinstituteofchicagoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.artinstituteofchicagoapp.services.JsonService

class GalleryView : AppCompatActivity(), JsonService {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.gallery_view)
		loadArtworks(findViewById(R.id.GalleryView), this@GalleryView)
	}
}
