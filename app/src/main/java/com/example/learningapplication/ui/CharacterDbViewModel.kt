package com.example.learningapplication.ui

import android.app.Application
import android.content.Context
import androidx.lifecycle.*
import com.example.learningapplication.data.Characters
import com.example.learningapplication.data_for_room.CharRoomDatabase
import com.example.learningapplication.data_for_room.CharacterDao
import com.example.learningapplication.data_for_room.Character
import com.example.learningapplication.data_for_room.CharacterDbRepo
import kotlinx.coroutines.launch

class CharacterDbViewModel(private val charDao: CharacterDao, mContext: Context): ViewModel() {

    var allCharsFromDb: LiveData<List<Character>> = MutableLiveData()
    val charDbRepo = CharacterDbRepo(CharRoomDatabase.getDatabase(mContext))

    fun getAllCharacters(): LiveData<List<Character>> {
        allCharsFromDb = charDbRepo.getCharsFromDatabase()
        return allCharsFromDb
    }



}

class CharacterDbViewModelFactory(private val charDao: CharacterDao, val mcontext: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CharacterDbViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CharacterDbViewModel(charDao, mcontext) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}