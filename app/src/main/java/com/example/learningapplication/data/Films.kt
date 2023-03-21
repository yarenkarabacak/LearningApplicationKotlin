package com.example.learningapplication.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Films (@SerializedName("title") var title: String,
                  @SerializedName("episode_id") var episode_id: Int,
                  //@SerializedName("opening_crawl") var opening_crawl: String,
                  @SerializedName("director") var director: String,
                  @SerializedName("producer") var producer: String,
                  @SerializedName("release_date") var release_date: String,
                  @SerializedName("url") var url: String) : Serializable {



}