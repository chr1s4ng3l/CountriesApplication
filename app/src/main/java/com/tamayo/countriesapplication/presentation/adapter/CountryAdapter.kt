package com.tamayo.countriesapplication.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tamayo.countriesapplication.databinding.ItemCountryBinding
import com.tamayo.countriesapplication.domain.CountriesDomain

/**
 * Adapter class for displaying countries in a RecyclerView.
 *
 * @param countryList the mutable list of countries to display
 */
class CountryAdapter(
    private val countryList: MutableList<CountriesDomain> = mutableListOf()
) : RecyclerView.Adapter<CountryViewHolder>() {

    /**
     * Updates the items in the adapter with the new list of countries.
     *
     * @param newItems the new list of countries to update the adapter with
     */
    @SuppressLint("NotifyDataSetChanged")
    fun updateItems(newItems: List<CountriesDomain>) {
        if (countryList != newItems) {
            countryList.clear()
            countryList.addAll(newItems)
            notifyDataSetChanged()
        }
    }

    /**
     * Creates a new view holder for displaying a country item.
     *
     * @param parent the parent view group
     * @param viewType the view type of the new view holder
     * @return the created [CountryViewHolder] instance
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder =
        CountryViewHolder(
            ItemCountryBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    /**
     * Returns the number of countries in the adapter.
     *
     * @return the number of countries
     */
    override fun getItemCount(): Int = countryList.size

    /**
     * Binds the country data to the view holder at the specified position.
     *
     * @param holder the view holder to bind data to
     * @param position the position of the country item
     */
    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) =
        holder.bind(countryList[position])
}
