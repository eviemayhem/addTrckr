package me.evieiles.addytrackerv4.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import me.evieiles.addytrackerv4.R
import me.evieiles.addytrackerv4.databinding.FragmentHomeBinding
import me.evieiles.addytrackerv4.databinding.FragmentMedsBinding
import me.evieiles.addytrackerv4.ui.dashboard.MedFragment
import me.evieiles.addytrackerv4.ui.dashboard.MedFragment.Companion.newInstance
import java.lang.reflect.Array.newInstance
import java.util.*


class HomeFragment : Fragment(), View.OnClickListener {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })


        return root
    }

    //symptom button should go to symptom logger


    //crisis should go to crisis screener

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }






    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object{
        fun newInstance():HomeFragment{
            return HomeFragment()
        }
    }



    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }


}