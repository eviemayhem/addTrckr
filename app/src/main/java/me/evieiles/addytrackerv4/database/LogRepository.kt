package me.evieiles.addytrackerv4.database

import android.content.Context
import java.lang.IllegalStateException

class LogRepository private constructor(context: Context) {
    companion object{
        private var INSTANCE: LogRepository? = null

        fun initialize(context:Context){
            if(INSTANCE == null){
                INSTANCE = LogRepository(context)
            }
        }
        fun get(): LogRepository{
            return INSTANCE?:
            throw IllegalStateException("MedLog repository must be initialized.")
        }
    }
}