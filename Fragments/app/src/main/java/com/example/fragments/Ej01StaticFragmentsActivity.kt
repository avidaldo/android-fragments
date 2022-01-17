package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragments.databinding.ActivityEj01StaticFragmentsBinding

// https://www.youtube.com/watch?v=Xut9BuA2CVI


class Ej01StaticFragmentsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEj01StaticFragmentsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEj01StaticFragmentsBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

}