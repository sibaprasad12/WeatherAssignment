package com.weatherassignment.main.utils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.weatherassignment.main.ui.adapter.WeatherAdapter

/**
 * Created by Sibaprasad Mohanty on 30/06/21.
 * Spm Limited
 * sp.dobest@gmail.com
 */

class BindingUtils {
    companion object {
        @JvmStatic
        @BindingAdapter("adapter")
        fun setRecyclerViewAdapter(recyclerViewMovie: RecyclerView, adapter: WeatherAdapter) {
            recyclerViewMovie.adapter = adapter
            recyclerViewMovie.layoutManager = LinearLayoutManager(recyclerViewMovie.context)
        }
    }
}