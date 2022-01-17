package com.avidaldo.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.avidaldo.navigation.databinding.FragmentBlueBinding




class BlueFragment : Fragment() {

    private var _binding: FragmentBlueBinding? = null
    // La propiedad solo es válida entre onCreateView y onDestroyView.
    private val binding get() = _binding!!
    // el getter accederá al binding solo cuando este ya exista


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBlueBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)

        binding.button.setOnClickListener {
            Toast.makeText(activity, "click en azul", Toast.LENGTH_SHORT).show()
            navController.navigate(R.id.action_blueFragment_to_redFragment)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}