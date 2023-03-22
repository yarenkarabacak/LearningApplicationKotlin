package com.example.learningapplication.retrofit

import com.example.learningapplication.data.FilmResults
import com.example.learningapplication.data.Films
import com.example.learningapplication.data.CharacterResults
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface CharactersAPI {
    @GET("people")
    fun allCharacters(): Call<CharacterResults>

    @GET("films")
    fun allFilms(): Call<FilmResults>

    @GET
    fun getFilmDetails(@Url url : String):Call<Films>

}