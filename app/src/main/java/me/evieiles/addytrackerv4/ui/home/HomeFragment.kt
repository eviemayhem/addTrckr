package me.evieiles.addytrackerv4.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import me.evieiles.addytrackerv4.R
import me.evieiles.addytrackerv4.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

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

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        //Medcheck button functionality
//        val medCheck = binding.medCheck //Assigns button a variable
//        medCheck.setOnClickListener{
//            val intent = Intent(requireContext(), R.layout.fragment_meds::class.java) //Tells button which view to switch to
//            startActivity(intent)//Starts that view
//
//            @Override
//            public void onClick(View v) {
//                Fragment fragment = new tasks();
//                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.content_frame, fragment);
//                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit();
//        }
//
//        //Crisis Screening Button Functionality
//        val crisisCheck =binding.crisisCheck
//        crisisCheck.setOnClickListener{
//            val intent = Intent(requireContext(), R.layout.crisis_fragment::class.java)
//            startActivity(intent)
//        }
//        //Log Button Functionality
//        val sympCheck = binding.sympCheck
//        sympCheck.setOnClickListener{
//            val intent = Intent(requireContext(), R.layout.fragment_notifications::class.java)
//            startActivity(intent)
//        }
//
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object{
        fun newInstance():HomeFragment{
            return HomeFragment()
        }
    }
}