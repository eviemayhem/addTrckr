package me.evieiles.addytrackerv4

import android.app.Application
import me.evieiles.addytrackerv4.database.LogRepository

class AddyIntentApplication : Application(){
    override fun onCreate(){
        super.onCreate()
        LogRepository.initialize(this)
    }
}