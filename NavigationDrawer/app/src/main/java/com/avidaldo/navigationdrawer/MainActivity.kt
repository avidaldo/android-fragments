package com.avidaldo.navigationdrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.replace
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.avidaldo.navigationdrawer.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar


/*
https://www.youtube.com/watch?v=l-jdSOUpSIA
https://www.youtube.com/watch?v=bqC0y_VLq5Q
https://developer.android.com/guide/navigation/navigation-ui#add_a_navigation_drawer
https://www.geeksforgeeks.org/view-binding-with-fragments-in-android-jetpack/
 */

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.contentMain.toolbar)

        val toggle = ActionBarDrawerToggle(this, binding.root, binding.contentMain.toolbar, R.string.open, R.string.close)

        binding.root.addDrawerListener(toggle)
        toggle.syncState() // Añade a la toolbar el icono para mostrar el Drawer


        binding.navMenu.setNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.home -> cambio(HomeFragment.newInstance(), R.string.home)
                R.id.about -> cambio(AboutFragment.newInstance(), R.string.about)
                R.id.contact -> cambio(ContactFragment.newInstance(), R.string.contact)
                R.id.rating -> cambio(RatingFragment.newInstance(), R.string.rating)
            }
            true
        }

    }

    private fun cambio(fragment: Fragment, titleResource: Int) {

        binding.root.closeDrawer(GravityCompat.START)  // Para cerrar el Drawer cuando se selecciona un item

        supportFragmentManager.commit {
            replace(R.id.fragmentContainerView, fragment)
        }

        binding.contentMain.toolbar.title = getString(titleResource)
    }

}
