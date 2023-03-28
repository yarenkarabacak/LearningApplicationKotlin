package com.example.learningapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.learningapplication.R
import com.example.learningapplication.data_for_room.CharacterApplication
import com.example.learningapplication.databinding.FragmentCharactersBinding

class CharactersFragment : Fragment() {
    private lateinit var binding: FragmentCharactersBinding
    private lateinit var viewModel: CharacterViewModel

    private val viewModel2: CharacterDbViewModel by activityViewModels {
        CharacterDbViewModelFactory(
            (activity?.application as CharacterApplication).database.characterDao()
        )
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

    private fun addCharsList() {
        viewModel.charsList.observe(viewLifecycleOwner) {chars ->
            chars.let {
                for (c in chars) {
                    viewModel2.addNewCharacter(
                        c.name,
                        c.height,
                        c.mass,
                        c.hair_color,
                        c.skin_color,
                        c.eye_color,
                        c.birth_year,
                        c.gender,
                        c.filmUrls
                    )
                }
            }

        }


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonAdd.setOnClickListener {
            addCharsList()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : CharacterViewModel by viewModels()
        viewModel = tempViewModel

    }


}