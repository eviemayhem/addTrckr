package me.evieiles.addytrackerv4

import java.util.*

data class MedLog(val id: UUID = UUID.randomUUID(),
                  var title:String = "",
                  var date:Date = Date(),
                  var cortSteroid:String = "",
                  var med2:String ="",
                  var med3:String = "",
                  var erInj:Boolean=false,
                  var symptoms:String="")
