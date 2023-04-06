package com.example.learningapplication.retrofit

import com.example.learningapplication.data.FilmResults
import com.example.learningapplication.data.CharacterResults
import retrofit2.Call
import retrofit2.http.GET

interface StarWarsAPI {
    @GET("people")
    fun getCharactersFromApi(): Call<CharacterResults>

    @GET("films")
    fun getFilmsFromApi(): Call<FilmResults>
}