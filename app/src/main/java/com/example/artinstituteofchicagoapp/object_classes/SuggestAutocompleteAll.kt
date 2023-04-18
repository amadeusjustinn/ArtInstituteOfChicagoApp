package com.example.artinstituteofchicagoapp.object_classes

data class SuggestAutocompleteAll(
    val contexts: Contexts,
    val input: List<String>,
    val weight: Int
)