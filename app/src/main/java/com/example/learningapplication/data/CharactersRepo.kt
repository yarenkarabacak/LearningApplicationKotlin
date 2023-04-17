package com.example.learningapplication.data

import androidx.lifecycle.MutableLiveData
import com.example.learningapplication.retrofit.StarWarsAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class CharactersRepo(var charApi: StarWarsAPI) {

    private var characterList: MutableLiveData<List<Characters>> = MutableLiveData()
    private val loading = MutableLiveData<Boolean>()

    fun getAllCharacters() {
        loading.postValue(true)

        charApi.getCharactersFromApi().enqueue(object : Callback<CharacterResults> {
            override fun onResponse(call: Call<CharacterResults>, response: Response<CharacterResults>) {
                if (response.isSuccessful) {
                    val chars = response.body()!!.results
                    characterList.value = chars
                }
                loading.postValue(false)
            }

            override fun onFailure(call: Call<CharacterResults>, t: Throwable) {
                loading.postValue(false)
            }
        })
        println(charApi.getCharactersFromApi().isExecuted)

    }

    fun sendCharacterList(): MutableLiveData<List<Characters>> {
        return characterList
    }

    fun getLoadingStatus(): MutableLiveData<Boolean> {
        return loading
    }


}