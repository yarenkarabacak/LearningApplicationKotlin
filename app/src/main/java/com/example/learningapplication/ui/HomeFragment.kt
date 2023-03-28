package com.example.learningapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.learningapplication.R
import com.example.learningapplication.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.toolbarHome.title = "Home Page"

        binding.buttonShow.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.home_to_chars)
        }

        binding.buttonDbShow.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.home_to_db_chars)
        }

        return binding.root
    }

}