package com.example.learningapplication.ui

import android.app.Application
import android.content.Context
import androidx.lifecycle.*
import com.example.learningapplication.data.Characters
import com.example.learningapplication.data_for_room.CharRoomDatabase
import com.example.learningapplication.data_for_room.CharacterDao
import com.example.learningapplication.data_for_room.Character
import com.example.learningapplication.data_for_room.CharacterDbRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDbViewModel @Inject constructor(val charDbRepo: CharacterDbRepo):
    ViewModel() {

    var allCharsFromDb: LiveData<List<Character>> = MutableLiveData()

    fun getAllCharacters(): LiveData<List<Character>> {
        allCharsFromDb = charDbRepo.getCharsFromDatabase()
        return allCharsFromDb
    }

}
