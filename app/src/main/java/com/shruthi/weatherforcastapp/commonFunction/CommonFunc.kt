package com.shruthi.weatherforcastapp.commonFunction

import android.util.Log

class CommonFunc {
    companion object{
        val isTestVersion = true

        fun logite(tag: String, msg: String) {
            if (isTestVersion)
                Log.e(tag, msg)
        }
    }

}