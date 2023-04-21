package com.example.artinstituteofchicagoapp.services

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.example.artinstituteofchicagoapp.GalleryView
import com.example.artinstituteofchicagoapp.object_classes.ApiResp
import com.example.artinstituteofchicagoapp.object_classes.Data
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface JsonService {
	fun loadArtworks(
		artworksList: MutableList<Data>,
		obs: GalleryView.HasLoaded,
		context: Context
	) {
		val service = ServiceBuilder.buildService(GetService::class.java)
		val requestCall = service.getArtworks()

		requestCall.enqueue(object : Callback<ApiResp> {
			override fun onResponse(call: Call<ApiResp>, response: Response<ApiResp>) {
				val apiResp = response.body()
				Log.d("Response", "onResponse: $apiResp")
				if (response.isSuccessful) {
					for (artwork in apiResp!!.data) {
						artworksList.add(artwork)
					}
					Log.d("isSuccessful", "Api response size: ${artworksList.size}")
					obs.setVal(true)
				} else {
					Log.d("isNotSuccessful", "JsonService onResponse")
					Toast.makeText(
						context,
						"onResponse | An error has occurred.\n${response.errorBody()}",
						Toast.LENGTH_SHORT
					).show()
				}
			}

			override fun onFailure(call: Call<ApiResp>, t: Throwable) {
				Toast.makeText(
					context,
					"onFailure | An error has occurred.\n${t}",
					Toast.LENGTH_SHORT
				).show()
			}
		})
	}
}
