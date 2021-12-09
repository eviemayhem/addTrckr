package me.evieiles.addytrackerv4.ui.Logs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import me.evieiles.addytrackerv4.MedLog
import me.evieiles.addytrackerv4.R
import me.evieiles.addytrackerv4.databinding.RecyclerHolderBinding

class LogActivity : Fragment() {
    private lateinit var logRecyclerView: RecyclerView

    private var adapter: RecyclerAdapter? = null


    companion object {
        fun newInstance() = LogActivity()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.log_recyclerview, container, false)

        logRecyclerView = view.findViewById<RecyclerView>(R.id.logRecyclerView)
        logRecyclerView.layoutManager = LinearLayoutManager(context)

      updateUI()

        return view
    }

    private fun updateUI(){
        val viewModel: LogListViewModel by activityViewModels()
        val logs = viewModel.logs
        adapter = RecyclerAdapter(logs)
        logRecyclerView.adapter = adapter
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


        }


    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }


}