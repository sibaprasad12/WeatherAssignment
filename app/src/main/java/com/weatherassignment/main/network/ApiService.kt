package com.weatherassignment.main.network

import com.weatherassignment.main.data.WeatherDetails
import com.weatherassignment.main.data.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Sibaprasad Mohanty on 14/07/21.
 * Spm Limited
 * sp.dobest@gmail.com
 */

interface ApiService {

    @GET("/posts")
    suspend fun getWeatherListForCity(): Response<List<WeatherDetails>>

    @GET("forecast")
    suspend fun getWeatherOfCity(@Query("q") cityName: String, @Query("APPID") appid: String): Response<WeatherResponse>

}