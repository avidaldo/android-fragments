package com.avidaldo.navigationdrawer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.avidaldo.navigationdrawer.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var btnActivity : Button

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.btnHome.setOnClickListener {
            Toast.makeText(activity, "Inicio", Toast.LENGTH_SHORT).show()
        }

/*        // handle the button from the host activity using findViewById method
        btnActivity = activity!!.findViewById<Button>(R.id.btnActivity)
        btnActivity.setOnClickListener {
            Toast.makeText(activity, "Fragment Home", Toast.LENGTH_SHORT).show()
        }*/


        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        btnActivity.setOnClickListener {  } // Si no se hace esto y el botón no se reasigna para otros fragments, fallaría
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }

}