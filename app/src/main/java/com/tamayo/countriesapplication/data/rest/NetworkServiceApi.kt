package com.tamayo.countriesapplication.data.rest

import com.tamayo.countriesapplication.data.model.CountriesResponseItem
import com.tamayo.countriesapplication.utils.Constants.ENDPOINT
import retrofit2.Response
import retrofit2.http.GET

/**
 * Interface defining the network service API for making HTTP requests related to countries.
 */
interface NetworkServiceApi {

    /**
     * Retrieves all countries from the server.
     *
     * @return a [Response] containing a list of [CountriesResponseItem] objects
     */
    @GET(ENDPOINT)
    suspend fun getAllCountries(): Response<List<CountriesResponseItem>>
}