package com.example.learningapplication.data_for_room

import android.text.TextUtils.getChars
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.learningapplication.data.Characters
import kotlinx.coroutines.launch

class CharacterDbRepo(private val database: CharRoomDatabase) {


    var allChars: LiveData<List<Character>> = MutableLiveData()

    fun getCharsFromDatabase(): LiveData<List<Character>> {
        allChars = database.characterDao().getChars().asLiveData()
        return allChars
    }


    suspend fun insertCharacter(char: Character) {
        database.characterDao().insert(char)
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

    suspend fun addNewCharacter(charName: String, charHeight: Int, charMass: Int,
                        charHair_color: String, charSkin_color: String,
                        charEye_color: String, charBirth_year: String,
                        charGender: String, filmUrls: List<String>): Character {

        val newChar = getNewCharacter(charName,charHeight,charMass,charHair_color,
            charSkin_color, charEye_color, charBirth_year, charGender, filmUrls)
        insertCharacter(newChar)

        return newChar
    }

    suspend fun addNewCharFromLive(c: Characters) {
        addNewCharacter(
            c.name,
            c.height,
            c.mass,
            c.hair_color,
            c.skin_color,
            c.eye_color,
            c.birth_year,
            c.gender,
            c.filmUrls
        )
    }


}