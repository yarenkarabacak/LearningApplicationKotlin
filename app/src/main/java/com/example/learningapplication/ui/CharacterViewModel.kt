package com.example.learningapplication.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.learningapplication.data.Characters
import com.example.learningapplication.data.CharactersRepo
import com.example.learningapplication.data_for_room.CharacterDbRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor (val charRepo: CharactersRepo,
                                              val charDbRepo: CharacterDbRepo) : ViewModel() {

    var charsList = MutableLiveData<List<Characters>>()
    var loadingStatus: MutableLiveData<Boolean>

    init {
        showChars()
        charsList = charRepo.sendCharacterList()
        loadingStatus = charRepo.getLoadingStatus()

    }

    fun showChars() {
        charRepo.getAllCharacters()
    }

    fun addCharactersToDb() {
        for (c in charsList.value!!) {
            viewModelScope.launch {
                withContext(Dispatchers.IO) {
                    charDbRepo.addNewCharacterFromLiveData(c)
                }
            }
        }
    }


}
