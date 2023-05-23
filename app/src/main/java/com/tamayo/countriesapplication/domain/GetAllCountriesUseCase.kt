package com.tamayo.countriesapplication.domain

import com.tamayo.countriesapplication.utils.Instances.myRepository
import com.tamayo.countriesapplication.utils.UIState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Use case class for retrieving all countries.
 */
class GetAllCountriesUseCase {

    /**
     * Invokes the use case and returns the result as a flow of [UIState].
     *
     * @return a flow of [UIState] representing the loading, success, or error state
     */
    operator fun invoke(): Flow<UIState<List<CountriesDomain>>> = flow {
        myRepository.getAllCountriesFromApi().collect { data ->
            emit(data)
        }
    }
}