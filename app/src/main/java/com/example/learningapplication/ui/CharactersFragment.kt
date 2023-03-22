package com.example.learningapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.learningapplication.R
import com.example.learningapplication.databinding.FragmentCharactersBinding

class CharactersFragment : Fragment() {
    private lateinit var binding: FragmentCharactersBinding
    private lateinit var viewModel: CharacterViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_characters, container, false)
        binding.toolbarCharactersTitle = "Characters"
        binding.characterFragment = this



        viewModel.charsList.observe(viewLifecycleOwner) {
            val adapter = CharacterAdapter(requireContext(), it)
            binding.characterAdapter = adapter

        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : CharacterViewModel by viewModels()
        viewModel = tempViewModel

    }


}