package com.example.learningapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.learningapplication.R
import com.example.learningapplication.data_for_room.CharacterApplication
import com.example.learningapplication.databinding.FragmentCharactersBinding

class CharactersFragment : Fragment() {
    private lateinit var binding: FragmentCharactersBinding

    private val viewModel: CharacterViewModel by activityViewModels {
        CharacterViewModelFactory(
            (requireContext()))
    }


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


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonAdd.setOnClickListener {
            viewModel.addCharsToDb()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


}