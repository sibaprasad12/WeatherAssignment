package com.weatherassignment.main.data

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.android.parcel.Parcelize


/**
 * Created by Sibaprasad Mohanty on 06/08/21.
 * Spm Limited
 * sp.dobest@gmail.com
 */

@Keep
data class WeatherDetails(
    val clouds: Clouds,
    val dt: Int,
    val dt_txt: String,
    val main: Main,
    val rain: Rain,
    val sys: Sys,
    val weather: List<Weather>,
    val wind: Wind
)

@Keep
data class Clouds(
    val all: Int // 75
)

@Keep
data class Coord(
    val lat: Double, // 19.0144
    val lon: Double // 72.8479
)

@Keep
data class Main(
    val feels_like: Double, // 306.69
    val humidity: Int, // 89
    val pressure: Int, // 1005
    val temp: Double, // 301.14
    val temp_max: Double, // 303.09
    val temp_min: Double // 301.14
)

@Keep
data class Sys(
    val country: String, // IN
    val id: Int, // 9052
    val sunrise: Int, // 1628297245
    val sunset: Int, // 1628343685
    val type: Int // 1
)

@Keep
data class Weather(
    val description: String, // haze
    val icon: String, // 50n
    val id: Int, // 721
    val main: String // Haze
)

@Keep
data class Wind(
    val deg: Int, // 250
    val speed: Double // 3.09
)

@Parcelize
@Keep
data class Rain(
    val `3h`: Double
) : Parcelable