package me.evieiles.addytrackerv4.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import me.evieiles.addytrackerv4.MedLog
import me.evieiles.addytrackerv4.database.LogDetailViewModel
import me.evieiles.addytrackerv4.databinding.FragmentNotificationsBinding
import me.evieiles.addytrackerv4.ui.dashboard.MedFragment
import java.util.*

private const val ARG_LOG_ID = "log_id"
private const val TAG = "LogFragment"
class LogFragment : Fragment() {

    private lateinit var logFragmentViewModel: LogFragmentViewModel
    private var _binding: FragmentNotificationsBinding? = null

    private val logDetailViewModel: LogDetailViewModel by lazy {
        ViewModelProvider(this).get(LogDetailViewModel::class.java)
    }

    private lateinit var log: MedLog
    override fun onStop(){
        super.onStop()
        logDetailViewModel.saveLog(log)
    }

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        log = MedLog()

        val logId: UUID = arguments?.getSerializable(ARG_LOG_ID) as UUID
        logDetailViewModel.loadLog(logId)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        logFragmentViewModel =
            ViewModelProvider(this).get(LogFragmentViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textNotifications
        logFragmentViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
    companion object {
        fun newInstance(logId: UUID): LogFragment {
            val args = Bundle().apply {
                putSerializable(ARG_LOG_ID, logId)
            }
            return LogFragment().apply {
                arguments = args
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logDetailViewModel.logLiveData.observe(
            viewLifecycleOwner, androidx.lifecycle.Observer { log ->
                log?.let {
                    this.log = log
//                    updateUI()
                }
            })
    }

        override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}