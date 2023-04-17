package com.example.learningapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.learningapplication.R
import com.example.learningapplication.databinding.FragmentCharactersBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharactersFragment : Fragment() {
    private lateinit var binding: FragmentCharactersBinding

    private val viewModel: CharacterViewModel by activityViewModels()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_characters, container, false)
        binding.toolbarCharactersTitle = "Characters"
        binding.characterFragment = this


        viewModel.loadingStatus.observe(viewLifecycleOwner, Observer {
            when(it) {
                true -> binding.progressBarChars.visibility = View.VISIBLE
                false -> binding.progressBarChars.visibility = View.INVISIBLE
            }

        })
        viewModel.charsList.observe(viewLifecycleOwner) {

            val adapter = CharacterAdapter(requireContext(), it)
            binding.characterAdapter = adapter
        }

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonAdd.setOnClickListener {
            viewModel.addCharactersToDb()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


}