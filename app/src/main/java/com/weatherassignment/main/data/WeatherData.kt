package com.weatherassignment.main.data

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.Ignore


/**
 * Created by Sibaprasad Mohanty on 06/08/21.
 * Spm Limited
 * sp.dobest@gmail.com
 */

@Keep
@Entity
data class WeatherData(
    val base: String, // stations
    @Ignore
    val clouds: Clouds1,
    val cod: Int, // 200
    @Ignore
    val coord: Coord1,
    val dt: Int, // 1628279315
    val id: Int, // 1275339
    @Ignore
    val main: Main1,
    val name: String, // Mumbai
    @Ignore
    val sys: Sys1,
    val timezone: Int, // 19800
    val visibility: Int, // 3000
    @Ignore
    val weather: List<Weather1>,
    @Ignore
    val wind: Wind1
)

@Keep
data class Clouds1(
    val all: Int // 75
)

@Keep
data class Coord1(
    val lat: Double, // 19.0144
    val lon: Double // 72.8479
)

@Keep
data class Main1(
    val feels_like: Double, // 306.69
    val humidity: Int, // 89
    val pressure: Int, // 1005
    val temp: Double, // 301.14
    val temp_max: Double, // 303.09
    val temp_min: Double // 301.14
)

@Keep
data class Sys1(
    val country: String, // IN
    val id: Int, // 9052
    val sunrise: Int, // 1628297245
    val sunset: Int, // 1628343685
    val type: Int // 1
)

@Keep
data class Weather1(
    val description: String, // haze
    val icon: String, // 50n
    val id: Int, // 721
    val main: String // Haze
)

@Keep
data class Wind1(
    val deg: Int, // 250
    val speed: Double // 3.09
)