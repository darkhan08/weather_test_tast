package com.example.weathertestapp.presentation.weather_details

import android.os.Bundle
import android.view.View
import com.example.weathertestapp.databinding.FragmentWeatherDetailsBinding
import com.example.weathertestapp.presentation.utils.BaseFragment
import com.example.weathertestapp.presentation.utils.visible
import com.example.weathertestapp.presentation.weather_details.adapter.ForecastAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class WeatherDetailsFragment :
    BaseFragment<FragmentWeatherDetailsBinding>(FragmentWeatherDetailsBinding::inflate) {
    private val viewModel: WeatherDetailsViewModel by viewModel()
    private val adapter: ForecastAdapter by lazy { ForecastAdapter() }
    private lateinit var city: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
        setupView()
    }

    private fun setupViewModel() {
        viewModel.forecastLiveData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        viewModel.loaderLiveData.observe(viewLifecycleOwner) {
            binding.loaderView.visible(it)
        }

        viewModel.currentWeatherLiveData.observe(viewLifecycleOwner) {
            adapter.submitList(mutableListOf(it))
        }
    }

    private fun setupView() = with(binding) {
        city = arguments?.getString(KEY_CITY_NAME).orEmpty()
        viewModel.getCurrentWeather(city)
        rvForecast.adapter = adapter
        btnCurrent.setOnClickListener {
            viewModel.getCurrentWeather(city)
        }
        btnForecast.setOnClickListener {
            viewModel.getForecast(city)
        }
    }

    companion object {
        private const val KEY_CITY_NAME = "CITY_NAME"

        @JvmStatic
        fun newInstance(cityName: String) =
            WeatherDetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(KEY_CITY_NAME, cityName)
                }
            }
    }
}