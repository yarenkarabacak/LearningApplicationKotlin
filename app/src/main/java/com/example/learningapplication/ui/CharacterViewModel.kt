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
import kotlinx.coroutines.launch

class CharacterViewModel(mContext: Context) : ViewModel() {

    val charRepo = CharactersRepo()
    var charsList = MutableLiveData<List<Characters>>()
    val charDbRepo = CharacterDbRepo(CharRoomDatabase.getDatabase(mContext))




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
class CharacterViewModelFactory(val mcontext: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CharacterViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CharacterViewModel(mcontext) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}