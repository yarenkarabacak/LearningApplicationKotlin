package com.example.learningapplication.data

import com.google.gson.annotations.SerializedName

data class FilmResults (@SerializedName("results") var results: List<Films>) {
}