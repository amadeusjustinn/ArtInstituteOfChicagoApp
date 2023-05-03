package com.example.artinstituteofchicagoapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager

class ImagePagerFragment : Fragment() {
	private var pager: ViewPager? = null

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		pager = inflater.inflate(R.layout.fragment_pager, container, false) as ViewPager
//		pager.apply {
//			adapter = ImageP
//		}
		return pager
	}
}
