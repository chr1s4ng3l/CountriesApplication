package com.tamayo.countriesapplication.data.rest

import com.tamayo.countriesapplication.domain.CountriesDomain
import com.tamayo.countriesapplication.domain.mapToDomain
import com.tamayo.countriesapplication.utils.CustomExceptions
import com.tamayo.countriesapplication.utils.Instances.ioDispatcher
import com.tamayo.countriesapplication.utils.Instances.serviceApi
import com.tamayo.countriesapplication.utils.UIState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

/**
 * Implementation of the [MyRepository] interface.
 */
class MyRepositoryImpl : MyRepository {

    /**
     * Retrieves all countries from the API and returns the result as a flow of [UIState].
     * @return a flow of [UIState] representing the loading, success, or error state
     */
    override fun getAllCountriesFromApi(): Flow<UIState<List<CountriesDomain>>> = flow {
        emit(UIState.LOADING)

        try {

            val response = serviceApi.getAllCountries()

            if (response.isSuccessful) {
                response.body()?.let { data ->

                    emit(UIState.SUCCESS(data.mapToDomain()))

                } ?: throw CustomExceptions.NullResponse()
            } else {
                throw CustomExceptions.FailResponse(response.errorBody()?.string())
            }


        } catch (error: Exception) {

            UIState.ERROR(error)
        }

    }.flowOn(ioDispatcher)

}