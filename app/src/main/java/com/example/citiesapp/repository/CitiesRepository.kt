package com.example.citiesapp.repository

import android.content.Context
import com.example.citiesapp.ui.screens.model.CityModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import javax.inject.Inject

class CitiesRepository @Inject constructor(@ApplicationContext private val context: Context) {

   suspend fun getCitiesGroupedByState(): Map<String, List<CityModel>> {
        return withContext(Dispatchers.IO) {
            val json = readJsonFromAssets("au.json")
            val citiesList: List<CityModel> = Json.decodeFromString(json)
            citiesList.groupBy { it.admin_name }
        }
    }

    private fun readJsonFromAssets(fileName: String): String {
        return context.assets.open(fileName).bufferedReader().use { it.readText() }
    }

}