package com.example.artinstituteofchicagoapp.services

import com.example.artinstituteofchicagoapp.object_classes.ImgData
import retrofit2.Call
import retrofit2.http.GET

interface JsonService {
	@GET("artworks")
	fun getArtworks(): Call<List<ImgData>>
}
