package com.weatherassignment.main.network

import com.weatherassignment.main.data.WeatherDetails
import com.weatherassignment.main.data.WeatherResponse
import retrofit2.Response

/**
 * Created by Sibaprasad Mohanty on 14/07/21.
 * Spm Limited
 * sp.dobest@gmail.com
 */

interface ApiHelper {
    suspend fun getWeatherDetails(): Response<List<WeatherDetails>>
    suspend fun getWeatherForCity(cityName:String, apiKey:String) : Response<WeatherResponse>
}