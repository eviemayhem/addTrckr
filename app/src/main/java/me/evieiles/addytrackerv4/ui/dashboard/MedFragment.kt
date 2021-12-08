package me.evieiles.addytrackerv4.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import me.evieiles.addytrackerv4.R
import me.evieiles.addytrackerv4.databinding.FragmentMedsBinding

class MedFragment : Fragment() {


    private lateinit var medFragViewModel: MedFragViewModel
    private var _binding: FragmentMedsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        medFragViewModel =
            ViewModelProvider(this).get(MedFragViewModel::class.java)


        _binding = FragmentMedsBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }
    companion object{
        fun newInstance(): MedFragment {
            return MedFragment()
        }


    }
    public fun newInstance(): MedFragment {
        return MedFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //CorticoSpinner Settings
        val corticoSpinner: Spinner = binding.cortSteroid
        val steroids = resources.getStringArray(R.array.steroids)
        val arrayAdapter1 = ArrayAdapter.createFromResource(requireContext(), R.array.steroids, android.R.layout.simple_spinner_dropdown_item)
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        corticoSpinner.adapter = arrayAdapter1

        //Secondary Med Spinner Settings
        val secondarySpinner: Spinner = binding.secondSteroid
        val secondMeds = resources.getStringArray(R.array.secondaryMeds)
        val arrayAdapter2 = ArrayAdapter.createFromResource(requireContext(), R.array.secondaryMeds, android.R.layout.simple_spinner_dropdown_item)
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        secondarySpinner.adapter = arrayAdapter2

        //Third med Spinner Settings
        val thirdSpinner : Spinner = binding.thirdMed
        val thirdMeds = resources.getStringArray(R.array.thirdMeds)
        val arrayAdapter3 = ArrayAdapter.createFromResource(requireContext(), R.array.thirdMeds, android.R.layout.simple_spinner_dropdown_item)
        arrayAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        thirdSpinner.adapter = arrayAdapter3




        //use On item selected listener
        //Position will correlate to item index to figure out which one was selected.
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}