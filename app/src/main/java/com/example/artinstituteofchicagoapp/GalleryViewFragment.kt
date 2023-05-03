package com.example.artinstituteofchicagoapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.artinstituteofchicagoapp.data_classes.Data
import com.example.artinstituteofchicagoapp.helpers.GalleryAdapter
import com.example.artinstituteofchicagoapp.services.JsonService
import kotlin.properties.Delegates

class GalleryViewFragment : Fragment(), JsonService {
	private val artworksList = mutableListOf<Data>()
	private val imgAdapter = GalleryAdapter(artworksList)
	private val hasLoaded = HasLoaded(imgAdapter)
	private var recyclerView: RecyclerView? = null

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		//prepareTransitions()
		return inflater.inflate(R.layout.fragment_gallery_view, container, false)
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

//		val recyclerView = view.findViewById<RecyclerView>(R.id.galleryView)
//		val galleryImageView = recyclerView.findViewById<ImageView>(R.id.image_artwork_gridview)
//		Log.d("type", recyclerView::class.java.typeName)
//		setTransitionName(galleryImageView, "item_image")
		imgAdapter.onItemClick = { artwork -> Log.d("clicked", artwork.title) }

		recyclerView = view.findViewById(R.id.galleryView)
		recyclerView?.apply {
			setHasFixedSize(true)
			layoutManager = GridLayoutManager(context, 2)
			adapter = imgAdapter
		}

		loadArtworks(artworksList, hasLoaded, context)
	}

//	private fun prepareTransitions() {
//		exitTransition = TransitionInflater.from(context)
//			.inflateTransition(R.transition.image_shared_element)
//		setExitSharedElementCallback(object : SharedElementCallback() {
//			override fun onMapSharedElements(
//				names: MutableList<String>,
//				sharedElements: MutableMap<String, View>
//			) {
//				// Locate the ViewHolder for the clicked position.
//				val selectedViewHolder = recyclerView?.findViewHolderForAdapterPosition(MainActivity.currentPosition)
//
//				// Map the first shared element name to the child ImageView.
//			}
//		}
//		)
//	}

	/**
	 * Contains a single observable variable to "refresh" the adapter
	 * when the API has responded with data. Images will appear as a grid.
	 */
	class HasLoaded(galleryAdapter: GalleryAdapter) {
		/**
		 * Single boolean variable that tells the adapter to "refresh" upon modification
		 */
		private var status: Boolean by Delegates.observable(false) { property, oldVal, newVal ->
			galleryAdapter.notifyDataSetChanged()
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
