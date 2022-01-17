package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.fragments.databinding.FragmentBlueBinding


class BlueFragment : Fragment() {

    /**
     * https://developer.android.com/topic/libraries/view-binding#fragments
     *
     * El binding de Fragments hace uso de una backing property:
     * https://kotlinlang.org/docs/properties.html#backing-properties */

    /* Propiedad de apoyo (backing property) nullable que existirá solo entre onCreateView y onDestroyView */
    private var _binding: FragmentBlueBinding? = null

    /* Propiedad a la que accederemos solo sabiendo que ya no es null (con !! declaramos que no lo será) */
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflamos el layout
        _binding = FragmentBlueBinding.inflate(inflater, container, false)

        // Ahora la propiedad binding sabemos que ya no es null
        binding.buttonBlue.setOnClickListener {
            Toast.makeText(activity, "Click en azul", Toast.LENGTH_SHORT).show()
        }


        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

        /* Los fragments duran más que sus views, por eso deben limpiarse las referencias a su binding class
        * Es también por esto por lo que no se deben declarar como lateinit. Ya que esto llevaría a no poder
        * reasignarlos a null cuando la vista se destruye, llevando a fugas de memoria (memory leaks)
        * https://stackoverflow.com/questions/70065804/why-not-use-lateinit-modifier-in-andrioid-fragment-data-binding */
    }

}