package com.shruthi.weatherdemoapp.presenter

import android.content.Context
import com.shruthi.weatherdemoapp.model.ForcastWeather
import com.shruthi.weatherdemoapp.model.Weather
import com.shruthi.weatherforcastapp.commonFunction.CommonFunc
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ItemPresenter {
    var context: Context
    var mListner: ItemsPresenterListner? = null
    val key: String = "08226925cc82476ea4e155657181604"
    val q: String = "Paris"
    var itemservice: RestCall

    constructor(context: Context, mListner: ItemsPresenterListner) {
        this.context = context
        this.mListner = mListner
        this.itemservice = RestCall()
    }
    interface ItemsPresenterListner {
        fun mWeatherService(itemsservices: Weather)
        fun mWeatherForcastService(itemsservices: ForcastWeather)
    }

     fun getService() {
        itemservice.getAPI().getWeather(key, q).enqueue(object : Callback<Weather> {
            override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
                CommonFunc.logite("","responsebody"+response.body())
                var wetherlist = response.body() as Weather
                mListner!!.mWeatherService(wetherlist)
            }

            override fun onFailure(call: Call<Weather>, t: Throwable) {
                CommonFunc.logite("","responeerr"+t.message)
                CommonFunc.logite("","responeerr"+t.stackTrace)
                CommonFunc.logite("","responeerr"+t.toString())

            }
        })

         itemservice.getAPI().getWeatherForcast(key,q).enqueue(object :Callback<ForcastWeather>{
             override fun onFailure(call: Call<ForcastWeather>?, t: Throwable?) {
                 CommonFunc.logite("","responeerr"+t!!.message)
                 CommonFunc.logite("","responeerr"+t.stackTrace)
                 CommonFunc.logite("","responeerr"+t.toString())

             }

             override fun onResponse(call: Call<ForcastWeather>?, response: Response<ForcastWeather>?) {
                 var wetherlist = response!!.body() as ForcastWeather
                 mListner!!.mWeatherForcastService(wetherlist)
             }

         })
     }
}