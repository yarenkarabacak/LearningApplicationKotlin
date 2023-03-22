package com.example.learningapplication.data

import com.google.gson.annotations.SerializedName

data class CharacterResults (@SerializedName("results") var results: List<Characters>){
}