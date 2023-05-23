package com.tamayo.countriesapplication.utils

import com.google.gson.Gson
import com.tamayo.countriesapplication.data.rest.MyRepositoryImpl
import com.tamayo.countriesapplication.data.rest.NetworkServiceApi
import com.tamayo.countriesapplication.domain.GetAllCountriesUseCase
import com.tamayo.countriesapplication.utils.Constants.BASE_URL
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Singleton class that provides instances of various dependencies used in the application.
 */
object Instances {

    // Logging interceptor for HTTP requests and responses
    private val loggingInterceptor =
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

    // OkHttpClient for making HTTP requests
    private val okHttp =
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .build()

    // Gson instance for JSON serialization and deserialization
    private val gson = Gson()

    // Retrofit instance for network communication
    private val retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttp)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    // API service interface for network requests
    val serviceApi = retrofit.create(NetworkServiceApi::class.java)

    // Implementation of the repository
    val myRepository = MyRepositoryImpl()

    // Use case for getting all countries
    val getAllCountriesUseCase = GetAllCountriesUseCase()

    //Dispatcher
    val ioDispatcher = Dispatchers.IO
}
