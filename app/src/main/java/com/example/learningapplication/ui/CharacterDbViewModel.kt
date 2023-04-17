package com.example.learningapplication.ui

import androidx.lifecycle.*
import com.example.learningapplication.data_for_room.Character
import com.example.learningapplication.data_for_room.CharacterDbRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterDbViewModel @Inject constructor(val charDbRepo: CharacterDbRepo):
    ViewModel() {

    var CharactersListFromDb: LiveData<List<Character>> = MutableLiveData()

    fun getAllCharacters(): LiveData<List<Character>> {
        CharactersListFromDb = charDbRepo.getCharactersFromDatabase()
        return CharactersListFromDb
    }

}
