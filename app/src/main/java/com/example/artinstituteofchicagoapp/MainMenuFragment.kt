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
		return inflater.inflate(R.layout.fragment_main_menu, container, false)
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		val fragmentManager = activity?.supportFragmentManager
		val btnShowArtworks = view.findViewById<Button>(R.id.button_show_artworks)
		btnShowArtworks.setOnClickListener {
			val transaction = fragmentManager?.beginTransaction()
			transaction?.apply {
				setReorderingAllowed(true)
				replace(R.id.navHostFragment, GalleryViewFragment())
				addToBackStack(null)
				commit()
			}
		}
	}
}
