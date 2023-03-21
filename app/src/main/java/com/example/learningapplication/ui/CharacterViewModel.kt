package com.example.learningapplication.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.learningapplication.data.Characters
import com.example.learningapplication.data.CharactersRepo
import com.example.learningapplication.data.Films
import com.example.learningapplication.data.FilmsRepo
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class CharacterViewModel : ViewModel() {

    val charRepo = CharactersRepo()
    var charsList = MutableLiveData<List<Characters>>()


    init {
        showChars()
        charsList = charRepo.showCharacters()
        println(charsList.value.toString())

    }

    fun showChars() {
        charRepo.getCharacters()
    }



}