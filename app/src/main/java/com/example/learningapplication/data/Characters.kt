package com.example.learningapplication.data

import androidx.lifecycle.LiveData
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Characters(@SerializedName("name") var name: String,
                      @SerializedName("height") var height: Int,
                      @SerializedName("mass") var mass: Int,
                      @SerializedName("hair_color") var hair_color: String,
                      @SerializedName("skin_color") var skin_color: String,
                      @SerializedName("eye_color") var eye_color: String,
                      @SerializedName("birth_year") var birth_year: String,
                      @SerializedName("gender") var gender: String,
                      @SerializedName("films") var filmUrls: List<String>) : Serializable {


}