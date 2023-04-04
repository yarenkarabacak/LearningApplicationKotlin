package com.example.learningapplication.data

import androidx.lifecycle.MutableLiveData
import com.example.learningapplication.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class CharactersRepo() {

    var characterList: MutableLiveData<List<Characters>> = MutableLiveData()
    var charApi = RetrofitClient.getCharacterApi()

    fun getCharacters() {

        charApi.getCharactersFromApi().enqueue(object : Callback<CharacterResults> {
            override fun onResponse(call: Call<CharacterResults>, response: Response<CharacterResults>) {
                if (response.isSuccessful) {
                    val chars = response.body()!!.results
                    characterList.value = chars
                }
            }
            override fun onFailure(call: Call<CharacterResults>, t: Throwable) {}
        })
        println(charApi.getCharactersFromApi().isExecuted)

    }

    fun showCharacters(): MutableLiveData<List<Characters>> {
        return characterList
    }


}