package com.tamayo.countriesapplication.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.tamayo.countriesapplication.R
import com.tamayo.countriesapplication.databinding.FragmentHomeBinding
import com.tamayo.countriesapplication.presentation.adapter.CountryAdapter
import com.tamayo.countriesapplication.presentation.viewmodel.CountriesViewModel
import com.tamayo.countriesapplication.utils.UIState
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {


    private val binding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
    }

    private val countryAdapter by lazy {
        CountryAdapter()
    }

    private val countriesViewModel: CountriesViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        showListOfCountries()
        getCountries()


        // Inflate the layout for this fragment
        return binding.root
    }


    private fun showListOfCountries() {
        binding.recyclerCountries.apply {
            layoutManager = LinearLayoutManager(
                requireContext(), LinearLayoutManager.VERTICAL, false
            )

            adapter = countryAdapter
        }
    }

    private fun getCountries() = lifecycleScope.launch {
        countriesViewModel.countries.collect() { state ->
            when (state) {
                is UIState.ERROR -> {
                    Toast.makeText(
                        requireContext(),
                        "Check your network connection",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                is UIState.LOADING -> {
                    //Progress bar
                }

                is UIState.SUCCESS -> {
                    countryAdapter.updateItems(state.data)
                }
            }
        }

    }

}