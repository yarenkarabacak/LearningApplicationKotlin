package com.example.learningapplication.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object {
        val BASE_URL = "https://swapi.py4e.com/api/"

        fun getClient(baseUrl: String): Retrofit {
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        fun getCharacterApi(): CharactersAPI {
            return getClient(BASE_URL).create(CharactersAPI::class.java)
        }

    }



}