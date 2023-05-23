package com.tamayo.countriesapplication.domain

import com.tamayo.countriesapplication.data.model.CountriesResponseItem
import com.tamayo.countriesapplication.data.model.Currency
import com.tamayo.countriesapplication.data.model.Language
/**
 * Represents a domain model of a country.
 *
 * @property capital the capital of the country
 * @property code the code of the country
 * @property currency the currency used in the country
 * @property demonym the demonym of the country
 * @property flag the flag of the country
 * @property language the primary language spoken in the country
 * @property name the name of the country
 * @property region the region where the country is located
 */
data class CountriesDomain(
    val capital: String? = null,
    val code: String? = null,
    val currency: Currency? = null,
    val demonym: String? = null,
    val flag: String? = null,
    val language: Language? = null,
    val name: String? = null,
    val region: String? = null
)

/**
 * Extension function to map a list of [CountriesResponseItem] to a list of [CountriesDomain].
 *
 * @return a list of [CountriesDomain] objects
 */
fun List<CountriesResponseItem>?.mapToDomain(): List<CountriesDomain> =
    this?.map { item ->
        CountriesDomain(
            capital = item.capital,
            code = item.code,
            currency = item.currency,
            demonym = item.demonym,
            flag = item.flag,
            language = item.language,
            name = item.name,
            region = item.region
        )
    } ?: emptyList()