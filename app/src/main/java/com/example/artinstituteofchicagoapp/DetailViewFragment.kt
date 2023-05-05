package com.example.artinstituteofchicagoapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.artinstituteofchicagoapp.view_models.DetailViewModel

class DetailViewFragment : Fragment() {
	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		return inflater.inflate(R.layout.fragment_detail_view, container, false)
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//		val detailImageView = view.findViewById<ImageView>(R.id.image_artwork_detailview)
//		setTransitionName(detailImageView, "hero_image")
		super.onViewCreated(view, savedInstanceState)
		Log.d("onvc", "onvc")
		val temp = arguments?.get("artwork") as DetailViewModel

		val title = view.findViewById<TextView>(R.id.text_title_detailview)
		Log.d("title", temp.title)
		title?.text = temp.title
	}
}
