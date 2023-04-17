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
import com.example.learningapplication.databinding.FragmentFilmsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FilmsFragment : Fragment() {

    private lateinit var binding: FragmentFilmsBinding
    private val viewModel: FilmViewModel by activityViewModels()


    var filmsListByCharacters = listOf<String>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_films, container, false)
        binding.toolbarFilmsTitle = "Films"
        binding.filmsFragment = this


       getFilmsFromCharacterAdapter()
       getFilteredFilmsFromViewModel()


        viewModel.loadingStatus.observe(viewLifecycleOwner, Observer {
            when(it) {
                true -> binding.progressBarFilms.visibility = View.VISIBLE
                false -> binding.progressBarFilms.visibility = View.INVISIBLE
            }

        })

        viewModel.filteredFilmsListByCharacter.observe(viewLifecycleOwner) {

            val adapter = FilmAdapter(requireContext(), it)
            binding.filmAdapter = adapter
        }

        return binding.root
    }

    private fun getFilmsFromCharacterAdapter(){
        var bundle = arguments
        var filmsFromBundle = bundle?.get("filmms") as Array<String>
        filmsListByCharacters = filmsFromBundle.toList()
    }

    private fun getFilteredFilmsFromViewModel() {
        viewModel.sendListToGetAndFilterFilms(filmsListByCharacters)
        viewModel.getFilteredFilmListFromRepo()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    }

