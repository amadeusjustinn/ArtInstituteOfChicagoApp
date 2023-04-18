package com.example.artinstituteofchicagoapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		val btnShowArtworks = findViewById<Button>(R.id.showArtworks)
		btnShowArtworks.setOnClickListener {
			val intent = Intent(this, GalleryView::class.java)
			startActivity(intent)
		}
	}
}
