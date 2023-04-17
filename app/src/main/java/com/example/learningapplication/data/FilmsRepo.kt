package com.example.learningapplication.data

import androidx.lifecycle.MutableLiveData
import com.example.learningapplication.retrofit.StarWarsAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FilmsRepo(var charApi: StarWarsAPI) {
    private var filmsListByCharacter: MutableLiveData<List<Films>> = MutableLiveData()
    private val loading = MutableLiveData<Boolean>()
    fun getAndFilterFilms(list: List<String>) {
        loading.postValue(true)

        charApi.getFilmsFromApi().enqueue(object : Callback<FilmResults> {
            override fun onResponse(call: Call<FilmResults>?, response: Response<FilmResults>) {
                val filmsList = response.body()!!.results
                var filteredList = mutableListOf<Films>()
                for (f in filmsList) {
                    for (l in list) {
                        if (f.url.equals(l)) {
                            filteredList.add(f)
                        }
                    }
                }
                filmsListByCharacter.value = filteredList
                loading.postValue(false)

            }

            override fun onFailure(call: Call<FilmResults>, t: Throwable) {
                loading.postValue(false)
            }
        })
        }

    fun sendFilteredFilmsList() : MutableLiveData<List<Films>> {
        return filmsListByCharacter
    }
    fun getLoadingStatus(): MutableLiveData<Boolean> {
        return loading
    }

}

