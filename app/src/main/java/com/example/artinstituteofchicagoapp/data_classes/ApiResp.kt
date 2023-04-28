package com.example.artinstituteofchicagoapp.data_classes

data class ApiResp(
	val config: Config,
	val `data`: List<Data>,
	val info: Info,
	val pagination: Pagination
)
