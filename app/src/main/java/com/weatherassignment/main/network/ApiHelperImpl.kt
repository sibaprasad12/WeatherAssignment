package com.weatherassignment.main.network

/**
 * Created by Sibaprasad Mohanty on 17/07/21.
 * Spm Limited
 * sp.dobest@gmail.com
 */

import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {

    override suspend fun getWeatherDetails() = apiService.getWeatherListForCity()

    override suspend fun getWeatherForCity(cityName: String, apiKey: String) =
        apiService.getWeatherOfCity(cityName, apiKey)
}