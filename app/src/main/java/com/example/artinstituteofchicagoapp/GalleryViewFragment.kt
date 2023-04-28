package com.example.artinstituteofchicagoapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.artinstituteofchicagoapp.data_classes.Data
import com.example.artinstituteofchicagoapp.helpers.ImgAdapter
import com.example.artinstituteofchicagoapp.services.JsonService
import kotlin.properties.Delegates

class GalleryViewFragment : Fragment(), JsonService {
	private val artworksList = mutableListOf<Data>()
	private val imgAdapter = ImgAdapter(artworksList)
	private val hasLoaded = HasLoaded(imgAdapter)

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		return inflater.inflate(R.layout.fragment_gallery_view, container, false)
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		val galleryView = view.findViewById<RecyclerView>(R.id.galleryView)
		galleryView.apply {
			setHasFixedSize(true)
			layoutManager = GridLayoutManager(context, 2)
			adapter = imgAdapter
		}

		loadArtworks(artworksList, hasLoaded, context)
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
