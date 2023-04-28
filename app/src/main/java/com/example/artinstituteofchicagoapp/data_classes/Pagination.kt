package com.example.artinstituteofchicagoapp.data_classes

data class Pagination(
	val current_page: Int,
	val limit: Int,
	val next_url: String,
	val offset: Int,
	val prev_url: String,
	val total: Int,
	val total_pages: Int
)
