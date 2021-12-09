package me.evieiles.addytrackerv4.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import me.evieiles.addytrackerv4.MedLog
import java.util.*

@Database(entities = [MedLog::class ], version =1)
@TypeConverters(LogTypeConverter::class)
abstract class LogDatabase :RoomDatabase() {

    //connect to DAO
    abstract fun logDao(): LogDao


}