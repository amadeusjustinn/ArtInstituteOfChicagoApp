package com.example.artinstituteofchicagoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.artinstituteofchicagoapp.helpers.ImgAdapter
import com.example.artinstituteofchicagoapp.object_classes.Data
import com.example.artinstituteofchicagoapp.services.JsonService
import kotlin.properties.Delegates

class GalleryView : AppCompatActivity(), JsonService {
	private val artworksList = mutableListOf<Data>()
	private val imgAdapter = ImgAdapter(artworksList)
	private val hasLoaded = HasLoaded(imgAdapter)

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.gallery_view)

		val galleryView = findViewById<RecyclerView>(R.id.GalleryView)
		galleryView.apply {
			setHasFixedSize(true)
			layoutManager = GridLayoutManager(this@GalleryView, 2)
			adapter = imgAdapter
		}

		loadArtworks(artworksList, hasLoaded, this@GalleryView)
	}

	class HasLoaded(imgAdapter: ImgAdapter) {
		private var status: Boolean by Delegates.observable(false) { property, oldVal, newVal ->
			imgAdapter.notifyDataSetChanged()
		}

		fun setVal(status: Boolean) {
			if (this.status != status) {
				this.status = status
			}
		}
	}
}
