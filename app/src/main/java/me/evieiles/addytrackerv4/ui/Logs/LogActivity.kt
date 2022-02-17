package me.evieiles.addytrackerv4.ui.Logs

import android.content.ContentValues.TAG
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import me.evieiles.addytrackerv4.MedLog
import me.evieiles.addytrackerv4.R
import me.evieiles.addytrackerv4.databinding.RecyclerHolderBinding
import java.util.*

class LogActivity : Fragment() {
    private lateinit var logRecyclerView: RecyclerView
    /**Required interface for hosting activities*/
    interface Callbacks {
        fun onLogSelected(logId: UUID)
    }
    private var callbacks: Callbacks? = null

//    private var adapter: RecyclerAdapter? = null
    private var adapter: RecyclerAdapter? = RecyclerAdapter(emptyList())

    private val logListViewModel : LogListViewModel by lazy {
        ViewModelProvider(this).get(LogListViewModel::class.java)
    }

    companion object {
        fun newInstance() = LogActivity()
    }

    //Callback attachment
    override fun onAttach(context: Context){
        super.onAttach(context)
        callbacks = context as Callbacks?
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.log_recyclerview, container, false)

        logRecyclerView = view.findViewById<RecyclerView>(R.id.logRecyclerView)
        logRecyclerView.layoutManager = LinearLayoutManager(context)
        logRecyclerView.adapter = adapter

//      updateUI()

        return view
    }

    //updates and refreshes UI when called
    private fun updateUI(logs: List<MedLog>){
        adapter = RecyclerAdapter(logs)
        logRecyclerView.adapter = adapter
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logListViewModel.logListLiveData.observe(
            viewLifecycleOwner,
            Observer{logs ->
                logs?.let {
                    Log.i(TAG, "Got Logs ${logs.size}")
                    updateUI(logs)
                }
            }
        )
    }

    //callback detach
    override fun onDetach(){
        super.onDetach()
        callbacks = null
    }


    //holds the layout view for reycler view
    private inner class RecyclerHolder(var rHolderBinding: RecyclerHolderBinding): RecyclerView.ViewHolder(rHolderBinding.root){
        val logTextView:TextView = rHolderBinding.logTypeText
        val dateTextView:TextView = rHolderBinding.dateText
        val cortTextView:TextView = rHolderBinding.cortSteroidText
        val med2TextView:TextView = rHolderBinding.med2Text
        val med3TextView:TextView = rHolderBinding.med3Text
        val erInjTextView:TextView = rHolderBinding.erInjText
        val sympTextView:TextView = rHolderBinding.sympText

    }

    //recyclerView Adapter
    private inner class RecyclerAdapter(var logs: List<MedLog>)
        : RecyclerView.Adapter<RecyclerHolder>(){

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
                RecyclerHolder {
            val view = RecyclerHolderBinding.inflate(layoutInflater, parent, false)
            return RecyclerHolder(view)
        }


        override fun getItemCount() =logs.size



        override fun onBindViewHolder(holder: RecyclerHolder, position: Int) {
            val log = logs[position]
            holder.apply {
                logTextView.text = log.title
                dateTextView.text = log.date.toString()
                cortTextView.text = log.cortSteroid
                med2TextView.text = log.med2
                med3TextView.text = log.med3
                erInjTextView.text = log.erInj.toString()
                sympTextView.text = log.symptoms
            }

            fun onClick(v : View?){
                callbacks?.onLogSelected(log.id)
            }
        }


    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }


}