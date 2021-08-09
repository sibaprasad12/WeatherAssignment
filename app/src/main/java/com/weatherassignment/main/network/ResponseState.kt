package com.weatherassignment.main.network


/**
 * Created by Sibaprasad Mohanty on 14/07/21.
 * Spm Limited
 * sp.dobest@gmail.com
 */

data class ResponseState<out T>(val status: Status, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T): ResponseState<T> =
            ResponseState(status = Status.SUCCESS, data = data, message = null)

        fun <T> error(data: T?, message: String): ResponseState<T> =
            ResponseState(status = Status.ERROR, data = data, message = message)

        fun <T> loading(data: T?): ResponseState<T> =
            ResponseState(status = Status.LOADING, data = data, message = null)
    }
}