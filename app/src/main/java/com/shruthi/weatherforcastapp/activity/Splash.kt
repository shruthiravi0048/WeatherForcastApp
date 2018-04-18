package com.shruthi.weatherforcastapp.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.shruthi.weatherforcastapp.R

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class Splash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setSupportActionBar(toolbar)
        Handler().postDelayed(Runnable // Using handler with postDelayed called runnable run method

        {
            val intent = Intent(this,WeatherActivity::class.java);
            startActivity(intent);

            // close this activity

            finish()
        },  1* 1000)
        /*btn.setOnClickListener { view ->
            val intent = Intent(this,WeatherActivity::class.java);
            startActivity(intent);
        }*/
    }


}
