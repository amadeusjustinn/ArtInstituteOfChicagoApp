package com.example.artinstituteofchicagoapp.services

import com.example.artinstituteofchicagoapp.object_classes.ApiResp
import retrofit2.Call
import retrofit2.http.GET

interface GetService {
	@GET("artworks")
	fun getArtworks(): Call<ApiResp>
}
