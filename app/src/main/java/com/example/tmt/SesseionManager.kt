package com.example.tmt

import android.content.Context
import android.content.SharedPreferences

class SesseionManager(applicationContext: Context) {

    //Initialize variable
    private var sharedPreferences: SharedPreferences? = null
    private var editor: SharedPreferences.Editor? = null

    fun SesseionManger(context: Context) {
        sharedPreferences = context.getSharedPreferences("AppKey", 0)
        // Initialize editor
        editor = sharedPreferences?.edit()
        //Apply editor
        editor?.apply()
    }

    fun setFlag(flag: Boolean?) {
        //Put boolean value
        if (flag != null) {
            editor?.putBoolean("KEY_FLAG", flag)
        }
        editor?.commit()
    }

        fun getFlag(): Boolean? {
        return sharedPreferences?.getBoolean("KEY_FLAG", false)
    }

    fun setCurrentTime(currentTime: String?) {
        editor?.putString("KEY_TIME", currentTime)
        editor?.commit()
    }

    fun getCurrentTime(): String? {
        return sharedPreferences?.getString("KEY_TIME", "")
    }

}
