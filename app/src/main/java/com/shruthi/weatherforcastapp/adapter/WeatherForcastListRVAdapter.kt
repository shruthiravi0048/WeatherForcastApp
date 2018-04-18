package com.shruthi.weatherforcastapp.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.shruthi.weatherdemoapp.model.ForcastWeather
import com.shruthi.weatherforcastapp.R
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.util.*

class WeatherForcastListRVAdapter(var mWeatherForcastList: ArrayList<ForcastWeather>,var context: Context):
        RecyclerView.Adapter<WeatherForcastListRVAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
       return mWeatherForcastList.size
    }
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): WeatherForcastListRVAdapter.ViewHolder {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.weather_forcast_row, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: WeatherForcastListRVAdapter.ViewHolder, position: Int) {
        val datalist = mWeatherForcastList[position]
        holder.mTvtemptext.text= datalist.forecast!!.forecastday!!.get(position).day!!.avgtempC.toString()+ 0x00B0.toChar()

        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm")
       val currdate = formatter.format(Date(System.currentTimeMillis()))

        if(currdate==datalist.forecast!!.forecastday!!.get(position).date){
            holder.mTvdayName.text="today"//datalist.forecast!!.forecastday!!.get(position).date
        }else{
            holder.mTvdayName.text=datalist.forecast!!.forecastday!!.get(position).date
        }


        holder.mTvCondition.text=datalist.current!!.condition!!.text
        Picasso.get()
                .load(datalist.current!!.condition!!.icon)
                .resize(50, 50)
                .centerCrop()
                .into(holder.mImgCondition)
    }

     class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val mTvdayName: TextView = itemView.findViewById(R.id.daytext) as TextView
        val mImgCondition: ImageView = itemView.findViewById(R.id.conditionimg) as ImageView
        val mTvCondition: TextView = itemView.findViewById(R.id.conditiontext) as TextView
        val mTvtemptext: TextView = itemView.findViewById(R.id.temptext) as TextView
    }

}