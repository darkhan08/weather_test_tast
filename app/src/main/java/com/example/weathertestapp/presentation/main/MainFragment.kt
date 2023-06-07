package com.example.weathertestapp.presentation.main

import android.os.Bundle
import android.view.View
import com.example.weathertestapp.databinding.FragmentMainBinding
import com.example.weathertestapp.presentation.main.adapter.CitiesAdapter
import com.example.weathertestapp.presentation.main.viewModel.MainViewModel
import com.example.weathertestapp.presentation.utils.BaseFragment
import com.example.weathertestapp.presentation.utils.replaceFragment
import com.example.weathertestapp.presentation.utils.visible
import com.example.weathertestapp.presentation.weather_details.WeatherDetailsFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {
    private val viewModel: MainViewModel by viewModel()
    private lateinit var adapter: CitiesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
        setupView()
    }

    private fun setupViewModel() {
        viewModel.citiesLiveData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        viewModel.loaderLiveData.observe(viewLifecycleOwner) {
            binding.loaderView.visible(it)
        }
    }

    private fun setupView() = with(binding) {
        viewModel.getCitiesByCountry()
        adapter = CitiesAdapter {
            navToWeatherDetails(it)
        }
        rvCities.adapter = adapter
    }

    private fun navToWeatherDetails(cityName: String) {
        (requireActivity() as MainActivity).replaceFragment(
            WeatherDetailsFragment.newInstance(
                cityName
            ), addToBackStack = true
        )
    }
}