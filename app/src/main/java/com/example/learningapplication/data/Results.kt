package com.example.learningapplication.data

import com.google.gson.annotations.SerializedName

data class Results (@SerializedName("results") var results: List<Characters>){
}