package me.evieiles.addytrackerv4.database

import androidx.room.Dao
import androidx.room.Query
import me.evieiles.addytrackerv4.MedLog
import java.util.*


@Dao
interface LogDao {

    @Query("SELECT * FROM medlog")
    fun getLogs():List<MedLog>

    @Query("Select * FROM medlog WHERE id=(:id)")
    fun getLog(id:UUID):MedLog?
}