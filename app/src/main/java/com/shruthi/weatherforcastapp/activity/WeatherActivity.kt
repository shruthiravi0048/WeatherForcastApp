package com.shruthi.weatherforcastapp.activity

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import com.shruthi.weatherdemoapp.model.ForcastWeather
import com.shruthi.weatherdemoapp.model.Weather
import com.shruthi.weatherdemoapp.presenter.ItemPresenter
import com.shruthi.weatherforcastapp.R
import com.shruthi.weatherforcastapp.adapter.WeatherForcastListRVAdapter
import com.shruthi.weatherforcastapp.commonFunction.CommonFunc

import kotlinx.android.synthetic.main.activity_weather.*

class WeatherActivity : AppCompatActivity() , ItemPresenter.ItemsPresenterListner {
    private var mWeathertv: TextView? = null
    private var mWeatherForcastRv: RecyclerView?=null
    private var mLocationtv: TextView? = null
    private var weatherPresenter: ItemPresenter? = null
    private  var mWeatherList=ArrayList<Weather>()
    private  var mWeatherForcastList=ArrayList<ForcastWeather>()

    private lateinit var linearLayoutManager: LinearLayoutManager
    var weatheListRecyclerViewAdapter: WeatherForcastListRVAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
        // setSupportActionBar(toolbar)
        mSetViews()
        weatherPresenter = ItemPresenter(this,this)
        weatherPresenter!!.getService()

    }
    override fun mWeatherService(itemsservices: Weather) {
        mWeatherList.add(itemsservices)
        CommonFunc.logite("ddddd","dddd")
        mWeathertv!!.text = itemsservices.current!!.tempC.toString()+ 0x00B0.toChar()
        mLocationtv!!.text = itemsservices.location!!.name.toString()

    }

    override fun mWeatherForcastService(itemsservices: ForcastWeather) {
        mWeatherForcastList.add(itemsservices)

        linearLayoutManager = LinearLayoutManager(this)
        mWeatherForcastRv!!.layoutManager = linearLayoutManager

        weatheListRecyclerViewAdapter = WeatherForcastListRVAdapter(mWeatherForcastList,this)
        mWeatherForcastRv!!.setAdapter(weatheListRecyclerViewAdapter)
    }

    private fun mSetViews() {
        mWeathertv = findViewById(R.id.wethertemp) as TextView
        mLocationtv = findViewById(R.id.locationtv) as TextView
        mWeatherForcastRv = findViewById(R.id.weather_forcast_rv) as RecyclerView


        val llm = LinearLayoutManager(this)
        llm.orientation = LinearLayoutManager.VERTICAL
    }

}
