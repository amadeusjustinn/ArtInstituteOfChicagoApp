package com.example.artinstituteofchicagoapp.helpers

import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.example.artinstituteofchicagoapp.DetailViewFragment
import com.example.artinstituteofchicagoapp.GalleryViewFragment
import com.example.artinstituteofchicagoapp.R
import com.example.artinstituteofchicagoapp.data_classes.Data
import com.example.artinstituteofchicagoapp.view_models.DetailViewModel

interface FromGalleryToDetail {
	fun passData(artwork: Data, temp: GalleryViewFragment, fragmentManager: FragmentManager?) {
		// Create view model, put in a Bundle
		val bundle = Bundle()
		val vm = DetailViewModel(
			artwork.artist_display,
			artwork.date_display,
			artwork.image_id,
			artwork.medium_display,
			artwork.place_of_origin,
			artwork.title
		)
		bundle.putParcelable("artwork", vm)

		// Attach Bundle to new Fragment
		val detailViewFragment = DetailViewFragment()
		detailViewFragment.arguments = bundle

		// Navigate to
		val transaction = fragmentManager?.beginTransaction()
		transaction?.apply {
			setReorderingAllowed(true)
			replace(R.id.navHostFragment, detailViewFragment)
//			add(R.id.navHostFragment, detailViewFragment)
			addToBackStack(null)
			commit()
		}
	}
}
