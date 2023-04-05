package com.example.learningapplication.ui

import android.content.ClipData
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.learningapplication.data.Characters
import com.example.learningapplication.data.CharactersRepo
import com.example.learningapplication.data.Films
import com.example.learningapplication.data.FilmsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FilmViewModel @Inject constructor (val filmRepo: FilmsRepo): ViewModel() {

    var listOfFilms = MutableLiveData<List<Films>>()

    fun displayFilms(tempList: List<String>) {
        filmRepo.getFilms(tempList)
    }
    fun loadFilms() {
        listOfFilms = filmRepo.showFilms()
    }




}