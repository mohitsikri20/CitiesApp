package com.example.citiesapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.citiesapp.repository.CitiesRepository
import com.example.citiesapp.ui.screens.model.CityModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CitiesViewModel @Inject constructor(
    private val repository: CitiesRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(UIState())
    val uiState = _uiState.asStateFlow()

    init {
        fetchCities()
    }

    private fun fetchCities() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(statesList = repository.getCitiesGroupedByState())
            }
        }
    }

    fun reverseList() {
        viewModelScope.launch {
            _uiState.update { currentState ->
                val reversedList = currentState.statesList
                    .toList().asReversed().toMap()
                currentState.copy(statesList = reversedList.toMap(), isReversed = uiState.value.isReversed.not(), isExpanded = false)
            }
        }

    }
    fun updateExpandedState(isExpanded: Boolean) {
        viewModelScope.launch {
            _uiState.update { it.copy(isExpanded = isExpanded) }
        }
    }
}

data class UIState(
    val statesList: Map<String, List<CityModel>> = emptyMap(),
    val isReversed: Boolean = false,
    val isExpanded: Boolean = false,
)