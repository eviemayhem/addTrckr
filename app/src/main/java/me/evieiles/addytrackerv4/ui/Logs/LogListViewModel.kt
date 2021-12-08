package me.evieiles.addytrackerv4.ui.Logs

import android.util.Log
import androidx.lifecycle.ViewModel
import me.evieiles.addytrackerv4.MedLog

class LogListViewModel: ViewModel(){


    public val logs = mutableListOf<MedLog>()

    init{
        for (i in 0 until 100){
            val log = MedLog()
            log.title = "Log #$i"
            logs += log
        }
    }
}