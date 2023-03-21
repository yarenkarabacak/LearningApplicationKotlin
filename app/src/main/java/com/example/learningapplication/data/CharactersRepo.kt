package com.example.learningapplication.data

import androidx.lifecycle.MutableLiveData
import com.example.learningapplication.retrofit.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class CharactersRepo() {

    var characterList: MutableLiveData<List<Characters>>
    var charDao = ApiUtils.getCharacterDAO()
    var allCharactersList = listOf<Characters>()

    init {
        characterList = MutableLiveData()

    }



    fun getCharacters() {

        charDao.allCharacters().enqueue(object : Callback<Results> {
            override fun onResponse(call: Call<Results>, response: Response<Results>) {
                if (response.isSuccessful) {
                    val chars = response.body()!!.results
                    characterList.value = chars
                }

            }

            override fun onFailure(call: Call<Results>, t: Throwable?) {}
        })
        println(charDao.allCharacters().isExecuted)

    }

    fun showCharacters(): MutableLiveData<List<Characters>> {
        return characterList
    }

    fun allListChars(): List<Characters> {
        return allCharactersList
    }

}