package com.example.artinstituteofchicagoapp.view_models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DetailViewModel(
	val artistDisplay: String,
	val dateDisplay: String,
	val mediumDisplay: String,
	val placeOfOrigin: String?,
	val title: String,
) : Parcelable
