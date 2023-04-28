package com.example.artinstituteofchicagoapp.data_classes

data class SuggestAutocompleteAll(
	val contexts: Contexts,
	val input: List<String>,
	val weight: Int
)
