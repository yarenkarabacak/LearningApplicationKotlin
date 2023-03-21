package com.example.learningapplication.retrofit

import com.example.learningapplication.data.FilmResults
import com.example.learningapplication.data.Films
import com.example.learningapplication.data.Results
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface CharactersDAO {
    @GET("people")
    fun allCharacters(): Call<Results>

    @GET("films")
    fun allFilms(): Call<FilmResults>

    @GET
    fun getFilmDetails(@Url url : String):Call<Films>

}