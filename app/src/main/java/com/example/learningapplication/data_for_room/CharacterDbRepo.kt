package com.example.learningapplication.data_for_room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import com.example.learningapplication.data.Characters
import kotlin.properties.Delegates

class CharacterDbRepo(val charDao: CharacterDao) {


    private var allCharactersList: LiveData<List<Character>> = MutableLiveData()
    private var dbCharCounter: LiveData<Int> = MutableLiveData()


    fun getCharactersFromDatabase(): LiveData<List<Character>> {
        allCharactersList = charDao.getCharactersFromDb().asLiveData()
        return allCharactersList
    }


    suspend fun insertCharacter(char: Character) {

        charDao.insertCharacterToDb(char)

    }

    private fun createNewCharacterObject(charName: String, charHeight: Int, charMass: Int,
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

    suspend fun addNewCharacterToDb(charName: String, charHeight: Int, charMass: Int,
                                    charHair_color: String, charSkin_color: String,
                                    charEye_color: String, charBirth_year: String,
                                    charGender: String, filmUrls: List<String>) {

        val newChar = createNewCharacterObject(charName,charHeight,charMass,charHair_color,
            charSkin_color, charEye_color, charBirth_year, charGender, filmUrls)
        insertCharacter(newChar)
    }

    suspend fun addNewCharacterFromLiveData(c: Characters) {

        addNewCharacterToDb(
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

    fun dbCharacterCounter() : LiveData<Int> {
        dbCharCounter = charDao.DbCharacterCounter().asLiveData()
        return dbCharCounter
    }


}