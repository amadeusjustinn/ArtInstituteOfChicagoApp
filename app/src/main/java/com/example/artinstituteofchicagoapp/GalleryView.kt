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

	/**
	 * Contains a single observable variable to "refresh" the adapter
	 * when the API has responded with data. Images will appear as a grid.
	 */
	class HasLoaded(imgAdapter: ImgAdapter) {
		/**
		 * Single boolean variable that tells the adapter to "refresh" upon modification
		 */
		private var status: Boolean by Delegates.observable(false) { property, oldVal, newVal ->
			imgAdapter.notifyDataSetChanged()
		}

		/**
		 * Changes `status` to trigger the callback function.
		 * @param status New status
		 */
		fun setVal(status: Boolean) {
			// In case of repeated calls
			if (this.status != status) {
				this.status = status
			}
		}
	}
}
