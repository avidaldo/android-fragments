package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.fragments.databinding.ActivityEj02DynamicFragmentsBinding


// https://www.youtube.com/watch?v=vkN3TtIdZgw&list=PL0bfr51v6JJEh1xtggpg57wN6m5Us3cb1&index=40


class Ej02DynamicFragmentsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEj02DynamicFragmentsBinding

    lateinit var fragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEj02DynamicFragmentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val redFragment = RedFragment.newInstance()
        val blueFragment = BlueFragment()

        fragment = redFragment


        binding.button.setOnClickListener {

            fragment = if (fragment == redFragment) blueFragment else redFragment


            /* Modo tradicional de cambiar un fragment */
            //supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, fragment).commit()


            /**
             * https://developer.android.com/guide/fragments/transactions
             *
             * Con la dependencia "androidx.fragment:fragment-ktx:$fragment_version"
             * se puede utilizar el bloque commit del modo siguiente, que ya realiza la transacción automáticamente.
             */
            supportFragmentManager.commit {
                addToBackStack(null) /* Este método permite añadir a la pila los cambios de fragments,
                de modo que el botón "atrás" regresará a la transacción previa */
                replace(R.id.fragmentContainerView, fragment)
            }





        }

    }


}