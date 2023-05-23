package com.tamayo.countriesapplication.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tamayo.countriesapplication.domain.CountriesDomain
import com.tamayo.countriesapplication.utils.Instances.getAllCountriesUseCase
import com.tamayo.countriesapplication.utils.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * View model class for handling countries-related data and operations.
 */
class CountriesViewModel : ViewModel() {

    // Mutable state flow for holding the countries UI state
    private val _countries: MutableStateFlow<UIState<List<CountriesDomain>>> =
        MutableStateFlow(UIState.LOADING)

    // Immutable state flow for accessing the countries UI state
    val countries: StateFlow<UIState<List<CountriesDomain>>> get() = _countries.asStateFlow()

    /**
     * Initializes the view model by fetching the countries.
     */
    init {
        getCountries()
    }

    /**
     * Fetches the countries using the [getAllCountriesUseCase] and updates the countries state.
     */
    private fun getCountries() = viewModelScope.launch {
        getAllCountriesUseCase.invoke().collect { state ->
            _countries.value = state
        }
    }
}