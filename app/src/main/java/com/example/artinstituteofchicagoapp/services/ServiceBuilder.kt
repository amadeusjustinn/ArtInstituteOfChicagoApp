package com.example.artinstituteofchicagoapp.services

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {
    private const val URL: String = "https://api.artic.edu/api/v1/artworks"

    // HTTP client
    private val okHttp: OkHttpClient.Builder = OkHttpClient.Builder()

    // Retrofit builder
    private val builder: Retrofit.Builder = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttp.build())

    // Retrofit instance
    private val retrofit: Retrofit = builder.build()

    fun <T> buildService(serviceType: Class<T>): T {
        return retrofit.create(serviceType)
    }
}