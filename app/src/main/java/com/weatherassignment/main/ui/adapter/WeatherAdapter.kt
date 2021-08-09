package com.weatherassignment.main.ui.adapter


/**
 * Created by Sibaprasad Mohanty on 06/08/21.
 * Spm Limited
 * sp.dobest@gmail.com
 */


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.weatherassignment.main.data.WeatherDetails
import com.weatherassignment.main.databinding.ItemviewWeatherBinding

/**
 * Created by Sibaprasad Mohanty on 21/07/21.
 * Spm Limited
 * sp.dobest@gmail.com
 */

class WeatherAdapter() :
    RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {

    private var weatherList: ArrayList<WeatherDetails> = ArrayList()

    class WeatherViewHolder(private val binding: ItemviewWeatherBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            obj: WeatherDetails,
            isFromFavoriteTab: Boolean
        ) {
//            binding.setVariable(BR.popularTvShow, obj)
//            binding.setVariable(BR.isNormalTvShowFragment, isFromFavoriteTab)
//            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val tvshowBinding: ItemviewWeatherBinding =
            ItemviewWeatherBinding.inflate(inflater, parent, false)
        return WeatherViewHolder(tvshowBinding)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val item = differ.currentList[position]
    }

    override fun getItemCount() = differ.currentList.size

    private val WeatherDetails_DIFF_CALLBACK: DiffUtil.ItemCallback<WeatherDetails> =
        object : DiffUtil.ItemCallback<WeatherDetails>() {
            override fun areItemsTheSame(
                @NonNull oldWeatherDetails: WeatherDetails,
                @NonNull newWeatherDetails: WeatherDetails
            ): Boolean {
                return oldWeatherDetails.id == newWeatherDetails.id
            }

            override fun areContentsTheSame(
                @NonNull oldWeatherDetails: WeatherDetails,
                @NonNull newWeatherDetails: WeatherDetails
            ): Boolean {
                return oldWeatherDetails.id == newWeatherDetails.id
            }
        }

    private val differ: AsyncListDiffer<WeatherDetails> =
        AsyncListDiffer(this, WeatherDetails_DIFF_CALLBACK)

    fun setWeatherDetailsList(weatherDetailsList: ArrayList<WeatherDetails>) {
        weatherList = weatherDetailsList
        differ.submitList(weatherDetailsList)
    }
}