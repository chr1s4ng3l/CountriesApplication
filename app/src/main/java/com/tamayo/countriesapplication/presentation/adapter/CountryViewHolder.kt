package com.tamayo.countriesapplication.presentation.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.tamayo.countriesapplication.databinding.ItemCountryBinding
import com.tamayo.countriesapplication.domain.CountriesDomain

/**
 * ViewHolder class for displaying a country item in the RecyclerView.
 *
 * @param binding the binding object for the country item view
 */
class CountryViewHolder(private val binding: ItemCountryBinding) : ViewHolder(binding.root) {

    /**
     * Binds the country data to the view holder.
     *
     * @param country the country object to bind
     */
    @SuppressLint("SetTextI18n")
    fun bind(country: CountriesDomain) {
        binding.textViewName.text = "${country.name}, "

        if(country.capital?.isNotEmpty() == true){
            binding.textViewCapital.text = country.capital
        } else{
            binding.textViewCapital.text = "Capital not available"
        }
        binding.textViewRegion.text = country.region ?: "Region not available"
        binding.textViewCode.text = country.code ?: "Code not available"
    }

}