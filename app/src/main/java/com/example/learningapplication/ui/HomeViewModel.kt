package com.example.learningapplication.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.learningapplication.data_for_room.CharacterDbRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val charDbRepo: CharacterDbRepo) : ViewModel() {

    var numberOfCharacters: LiveData<Int>


    init {
        numberOfCharacters = charDbRepo.dbCharacterCounter()
    }

}