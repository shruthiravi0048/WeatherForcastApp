package com.shruthi.weatherdemoapp.presenter

import com.shruthi.weatherdemoapp.model.ForcastWeather
import com.shruthi.weatherdemoapp.model.Weather
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

class RestCall {

    private val baseUrl = "http://api.apixu.com"
        interface WeatherApiInterface
    {

        @GET ("/v1/current.json?")
        fun getWeather(@Query("key") cityID: String, @Query("q") cityname: String): Call<Weather>

        @GET ("/v1/forecast.json?")
        fun getWeatherForcast(@Query("key") cityID: String, @Query("q") cityname: String): Call<ForcastWeather>



    }
 fun getAPI(): WeatherApiInterface {
        val retrofit = Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build()
        return retrofit.create(WeatherApiInterface::class.java)
    }
}