package com.example.learningapplication.retrofit

import com.example.learningapplication.retrofit.RetrofitClient.Companion.dgetClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiUtils {

    companion object {
        val BASE_URL = "https://swapi.py4e.com/api/"

        fun getClient(baseUrl: String): Retrofit {
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        fun getCharacterDAO(): CharactersDAO {
            return getClient(BASE_URL).create(CharactersDAO::class.java)
        }

    }



}