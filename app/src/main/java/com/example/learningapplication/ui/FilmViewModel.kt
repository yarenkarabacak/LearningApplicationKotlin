package com.example.learningapplication.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.learningapplication.data.Films
import com.example.learningapplication.data.FilmsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FilmViewModel @Inject constructor (val filmRepo: FilmsRepo): ViewModel() {

    var filteredFilmsListByCharacter = MutableLiveData<List<Films>>()
    var loadingStatus: MutableLiveData<Boolean>

    init {
        loadingStatus = filmRepo.getLoadingStatus()
    }
    fun sendListToGetAndFilterFilms(tempList: List<String>) {
        filmRepo.getAndFilterFilms(tempList)
    }
    fun getFilteredFilmListFromRepo() {
        filteredFilmsListByCharacter = filmRepo.sendFilteredFilmsList()
    }




}