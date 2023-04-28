package com.example.artinstituteofchicagoapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class MainMenuFragment : Fragment() {
	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		return inflater.inflate(R.layout.main_menu, container, false)
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		val fragmentManager = activity?.supportFragmentManager
		val btnShowArtworks = view.findViewById<Button>(R.id.showArtworks)
		btnShowArtworks.setOnClickListener {
			val galleryViewFragment = GalleryViewFragment()
			val transaction = fragmentManager?.beginTransaction()
			transaction?.replace(R.id.navHostFragment, galleryViewFragment)
				?.addToBackStack(null)
				?.commit()
		}
	}
}
