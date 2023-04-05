package com.example.learningapplication.data

import androidx.lifecycle.MutableLiveData
import com.example.learningapplication.retrofit.CharactersAPI
import com.example.learningapplication.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FilmsRepo(var charApi: CharactersAPI) {
    var filmList: MutableLiveData<List<Films>> = MutableLiveData()

    fun getFilms(list: List<String>) {

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
                filmList.value = filteredList

            }

            override fun onFailure(call: Call<FilmResults>, t: Throwable) {}
        })
        }

    fun showFilms() : MutableLiveData<List<Films>> {
        return filmList
    }

}

