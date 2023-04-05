package com.example.learningapplication.ui

import android.content.Context
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.learningapplication.data.Characters
import com.example.learningapplication.data.CharactersRepo
import com.example.learningapplication.data_for_room.CharRoomDatabase
import com.example.learningapplication.data_for_room.CharacterDao
import com.example.learningapplication.data_for_room.CharacterDbRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor (val charRepo: CharactersRepo,
                                              val charDbRepo: CharacterDbRepo) : ViewModel() {

    var charsList = MutableLiveData<List<Characters>>()

    init {
        showChars()
        charsList = charRepo.showCharacters()
    }

    fun showChars() {
        charRepo.getCharacters()
    }

    fun addCharsToDb() {
        for (c in charsList.value!!) {
            viewModelScope.launch {
                charDbRepo.addNewCharFromLive(c)
            }
        }
    }
}
