package com.example.citiesapp.ui.screens.model

import kotlinx.serialization.Serializable

@Serializable
data class CityModel(
    val city: String,
    val lat: String,
    val lng: String,
    val country: String,
    val iso2: String,
    val admin_name: String,
    val capital: String,
    val population: String,
    val population_proper: String
)
