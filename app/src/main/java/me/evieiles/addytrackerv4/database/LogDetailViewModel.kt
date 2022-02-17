package me.evieiles.addytrackerv4.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import me.evieiles.addytrackerv4.MedLog
import java.util.*

class LogDetailViewModel(): ViewModel(){
    private val logRepository = LogRepository.get()
    private val logIdLiveData = MutableLiveData<UUID>()

    var logLiveData: LiveData<MedLog?> =
            Transformations.switchMap(logIdLiveData) { logId -> logRepository.getLog(logId)
            }
    fun loadLog(logId: UUID){
        logIdLiveData.value = logId
    }

    fun saveLog(log : MedLog){
        logRepository.updateLog(log)
    }
}