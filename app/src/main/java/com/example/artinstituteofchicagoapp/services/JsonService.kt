package com.example.artinstituteofchicagoapp.services

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.beust.klaxon.Klaxon
import com.example.artinstituteofchicagoapp.helpers.ImgAdapter
import com.example.artinstituteofchicagoapp.object_classes.ApiResp
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface JsonService {
	fun loadArtworks(galleryView: RecyclerView, context: Context) {
		val service = ServiceBuilder.buildService(GetService::class.java)
		val requestCall = service.getArtworks()

		requestCall.enqueue(object : Callback<ApiResp> {
			override fun onResponse(call: Call<ApiResp>, response: Response<ApiResp>) {
				Log.d("Response", "onResponse: ${response.body()}")
				if (response.isSuccessful) {
					val apiResp = response.body()
					val apiRespJson = Klaxon().parse<ApiResp>(Gson().toJson(apiResp))
					val artworksList = apiRespJson!!.data

					Log.d("Response", "Api response size: ${artworksList.size}")
					galleryView.apply {
						setHasFixedSize(true)
						layoutManager = GridLayoutManager(context, 2)
						adapter = ImgAdapter(artworksList)
					}
				} else {
					Toast.makeText(
						context,
						"An error has occurred.\n${response.message()}",
						Toast.LENGTH_SHORT
					).show()
				}
			}

			override fun onFailure(call: Call<ApiResp>, t: Throwable) {
				Toast.makeText(context, "An error has occurred.\n${t}", Toast.LENGTH_SHORT).show()
			}
		})
	}
}
