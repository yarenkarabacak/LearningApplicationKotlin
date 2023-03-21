package com.example.learningapplication.ui

import android.content.ClipData
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.learningapplication.data.Characters
import com.example.learningapplication.data.CharactersRepo
import com.example.learningapplication.data.Films
import com.example.learningapplication.data.FilmsRepo

class FilmViewModel: ViewModel() {

    val filmRepo = FilmsRepo()
    var listOfFilms = MutableLiveData<List<Films>>()



    fun displayFilms(tempList: List<String>) {
        filmRepo.getFilms(tempList)
    }
    fun loadFilms() {
        listOfFilms = filmRepo.showFilms()
    }




}