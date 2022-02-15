package me.evieiles.addytrackerv4

import android.util.Log
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class MedLog(@PrimaryKey val id: UUID = UUID.randomUUID(),
                  var title:String = "",
                  var date:Date = Date(),
                  var cortSteroid:String = "",
                  var med2:String ="",
                  var med3:String = "",
                  var erInj:Boolean=false,
                  var symptoms:String="",

)
