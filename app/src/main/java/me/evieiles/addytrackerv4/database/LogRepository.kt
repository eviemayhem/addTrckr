package me.evieiles.addytrackerv4.database

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.room.Room
import me.evieiles.addytrackerv4.MedLog
import java.lang.IllegalStateException
import java.util.*
import java.util.concurrent.Executors

private const val DATABASE_NAME = "log-database"

class LogRepository private constructor(context: Context) {

    private val database: LogDatabase = Room.databaseBuilder(
        context.applicationContext,
        LogDatabase::class.java,
        DATABASE_NAME).build()

    private val logDao = database.logDao()
    private val executor = Executors.newSingleThreadExecutor()

    fun getLogs(): LiveData<List<MedLog>> = logDao.getLogs()

    fun getLog(id: UUID): LiveData<MedLog?> = logDao.getLog(id)

    fun updateLog(log : MedLog){
        executor.execute{
            logDao.updateLog(log)
        }
    }

    fun addLog(log: MedLog){
        executor.execute{
            logDao.addLog(log)
        }
    }

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