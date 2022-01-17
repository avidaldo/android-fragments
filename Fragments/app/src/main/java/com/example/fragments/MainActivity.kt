package com.example.fragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragments.databinding.ActivityMainBinding

// https://developer.android.com/guide/fragments

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ej1.setOnClickListener { startActivity(Intent(this, Ej01StaticFragmentsActivity::class.java)) }
        binding.ej2.setOnClickListener { startActivity(Intent(this, Ej02DynamicFragmentsActivity::class.java)) }

    }

}