package me.evieiles.addytrackerv4.crisis

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.evieiles.addytrackerv4.R

class crisis : Fragment() {

    companion object {
        fun newInstance() = crisis()
    }

    private lateinit var viewModel: CrisisViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.crisis_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CrisisViewModel::class.java)
        // TODO: Use the ViewModel
    }

}