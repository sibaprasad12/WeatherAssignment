package com.weatherassignment.main.utils

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.round

/**
 * Created by Sibaprasad Mohanty on 22/07/21.
 * Spm Limited
 * sp.dobest@gmail.com
 */

class CommonUtils {

    companion object {

        fun checkPermission(applicationContext: Context): Boolean {
            val result = ContextCompat.checkSelfPermission(
                applicationContext,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
            return result == PackageManager.PERMISSION_GRANTED
        }

        fun requestPermission(
            applicationContext: Activity,
            permissionArray: Array<String>,
            PERMISSION_REQUEST_CODE: Int
        ) {
            if (!checkPermission(applicationContext)) {
                ActivityCompat.requestPermissions(
                    applicationContext,
                    permissionArray,
                    PERMISSION_REQUEST_CODE
                )
            }
        }

        fun getDateInddMMMYYYYFormat(weatherDate: String = "2019-08-15 21:06:30"): String {

            var formattedDate = ""

            val originalFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            val targetFormat = SimpleDateFormat("dd MMM yyyy")

            val date: Date
            try {
                date = originalFormat.parse(weatherDate)
                formattedDate = targetFormat.format(date)

            } catch (ex: Exception) {
                ex.stackTrace
            }
            return formattedDate
        }

        /**
         * Params : date: String in yyyy-MM-dd HH:mm:ss
         * It convert date to dd hh:mm aa format
         * 2013-02-27 21:06:30 - 9:06 PM
         *
         * Default Date parameter is 2019-08-15 21:06:30
         */
        fun getDateInddHHmmFormat(weatherDate: String = "2019-08-15 21:06:30"): String {

            var formattedTime = ""

            val originalFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            val targetFormat = SimpleDateFormat("hh:mm aa")

            val date: Date
            try {
                date = originalFormat.parse(weatherDate)
                formattedTime = targetFormat.format(date)
            } catch (ex: ParseException) {
                ex.stackTrace
            }
            return formattedTime
        }

        /**
         * Params : date: String in yyyy-MM-dd HH:mm:ss
         * It convert date to EEEE format
         * 2013-02-27 21:06:30 - MONDAY
         *
         * Default Date parameter is 2019-08-15 21:06:30
         */
        fun getDayOftheWeek(weatherDate: String = "2019-08-15 21:06:30"): String {

            var formattedDay = ""

            val originalFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            val targetFormat = SimpleDateFormat("EEEE")

            val date: Date
            try {
                date = originalFormat.parse(weatherDate)
                formattedDay = targetFormat.format(date)
            } catch (ex: ParseException) {
                ex.stackTrace
            }
            return formattedDay
        }

        /**
         * Check internet connection
         */
        fun isNetworkAvailable(activity: AppCompatActivity): Boolean {
            val connectivityManager =
                activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = connectivityManager.activeNetworkInfo
            return networkInfo != null && networkInfo.isConnected
        }

        fun getCelciousFromKalvin(tempInKalvin: Double): String {
            val tempInCelcious: Double = round((tempInKalvin - 273.15) * 100) / 100
            return tempInCelcious.toString() + 0x00B0.toChar() + " C"
        }
    }
}