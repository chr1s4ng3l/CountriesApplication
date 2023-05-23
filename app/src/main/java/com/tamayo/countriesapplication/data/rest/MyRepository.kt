package com.tamayo.countriesapplication.data.rest

import com.tamayo.countriesapplication.domain.CountriesDomain
import com.tamayo.countriesapplication.utils.UIState
import kotlinx.coroutines.flow.Flow

/**
 * Repository interface for accessing country-related data.
 */
interface MyRepository {

    /**
     * Retrieves all countries from the API and returns the result as a flow of [UIState].
     * @return a flow of [UIState] representing the loading, success, or error state
     */
    fun getAllCountriesFromApi(): Flow<UIState<List<CountriesDomain>>>

}