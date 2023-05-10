package com.example.artinstituteofchicagoapp.data_classes

/**
 * Class for typical API response.
 * Documentation can be found at http://api.artic.edu/docs/#collections.
 */
data class ApiResp(
	val config: Config,
	val `data`: List<Data>,
	val info: Info,
	val pagination: Pagination
)
