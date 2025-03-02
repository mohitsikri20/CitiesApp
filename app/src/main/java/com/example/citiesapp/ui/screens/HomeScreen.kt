package com.example.citiesapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.citiesapp.ui.components.ExpandableStateCard
import com.example.citiesapp.viewmodel.CitiesViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: CitiesViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val cities = uiState.statesList
    println("cities: $cities")

    Column(modifier = modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
            .padding(8.dp)) {
            items(cities.entries.toList()) { (state, city) ->
                ExpandableStateCard(state = state , cityList = city)
            }
        }
        Button(
            onClick = {
                viewModel.reverseList()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(text = "Reverse")
        }
    }



}