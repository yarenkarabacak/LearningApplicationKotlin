package com.example.learningapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.learningapplication.R
import com.example.learningapplication.databinding.FragmentFilmsBinding


class FilmsFragment : Fragment() {

    private lateinit var binding: FragmentFilmsBinding
    private lateinit var viewModel: FilmViewModel


    var listOfFilmsByChar = listOf<String>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_films, container, false)
        binding.toolbarFilmsTitle = "Films"
        binding.filmsFragment = this



        var bundle = arguments
        var filmsFromBundle = bundle?.get("filmms") as Array<String>
        listOfFilmsByChar = filmsFromBundle.toList()


        viewModel.displayFilms(listOfFilmsByChar)
        viewModel.loadFilms()

        viewModel.listOfFilms.observe(viewLifecycleOwner) {
            val adapter = FilmAdapter(requireContext(), it)
            binding.filmAdapter = adapter

        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : FilmViewModel by viewModels()
        viewModel = tempViewModel

    }

    }
