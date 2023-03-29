package com.example.learningapplication.ui

import androidx.lifecycle.*
import com.example.learningapplication.data_for_room.CharacterDao
import com.example.learningapplication.data_for_room.Character
import kotlinx.coroutines.launch

class CharacterDbViewModel(private val charDao: CharacterDao): ViewModel() {

    val allChars: LiveData<List<Character>> = charDao.getChars().asLiveData()

    private fun insertCharacter(char: Character) {
        viewModelScope.launch {
            charDao.insert(char)
        }
    }

    private fun getNewCharacter(charName: String, charHeight: Int, charMass: Int,
                                charHair_color: String, charSkin_color: String,
                             charEye_color: String, charBirth_year: String,
                             charGender: String, filmUrls: List<String>): Character {
        return Character(
            charName = charName,
            charHeight = charHeight,
            charMass = charMass,
            charHair_color = charHair_color,
            charSkin_color = charSkin_color,
            charEye_color = charEye_color,
            charBirth_year = charBirth_year,
            charGender = charGender,
            filmUrls = filmUrls)
    }

    fun addNewCharacter(charName: String, charHeight: Int, charMass: Int,
                        charHair_color: String, charSkin_color: String,
                        charEye_color: String, charBirth_year: String,
                        charGender: String, filmUrls: List<String>) {
        val newChar = getNewCharacter(charName,charHeight,charMass,charHair_color,
                        charSkin_color, charEye_color, charBirth_year, charGender, filmUrls)

        insertCharacter(newChar)
    }

}

class CharacterDbViewModelFactory(private val charDao: CharacterDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CharacterDbViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CharacterDbViewModel(charDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}