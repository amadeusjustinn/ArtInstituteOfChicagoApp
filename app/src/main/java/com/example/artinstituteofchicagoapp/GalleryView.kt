package com.example.artinstituteofchicagoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.artinstituteofchicagoapp.services.JsonService
import com.example.artinstituteofchicagoapp.services.ServiceBuilder

class GalleryView : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.gallery_view)
	}

	private fun loadArtworks() {
		TODO("Move this to a separate file")
		val service = ServiceBuilder.buildService(JsonService::class.java)
		val requestCall = service.getArtworks()
//		requestCall.enqueue(object : Callback<ApiResp> {
//			override fun onResponse(call: Call<ApiResp>, response: Response<ApiResp>) {
//				Log.d("Response", "onResponse: ${response.body()}")
//				if (response.isSuccessful) {
//					val apiResp: ApiResp? = response.body()
//					val gson = Gson()
//					val apiRespJson: ApiResp? = Klaxon().parse<ApiResp>(gson.toJson(apiResp))
//					val artworksList = apiRespJson?.data
//					Log.d("Response", "Api")
//				}
//			}
//		})
	}
}
