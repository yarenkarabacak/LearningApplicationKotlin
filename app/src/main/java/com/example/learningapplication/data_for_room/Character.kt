package com.example.learningapplication.data_for_room

import androidx.room.*
import com.google.gson.annotations.SerializedName

@Entity(tableName = "character")
data class Character(@PrimaryKey(autoGenerate = true) val char_id: Int = 0,
                     @ColumnInfo(name = "name") var charName: String,
                     @ColumnInfo(name = "height") var charHeight: Int,
                     @ColumnInfo(name = "mass") var charMass: Int,
                     @ColumnInfo(name = "hair_color") var charHair_color: String,
                     @ColumnInfo(name = "skin_color") var charSkin_color: String,
                     @ColumnInfo(name = "eye_color") var charEye_color: String,
                     @ColumnInfo(name = "birth_year") var charBirth_year: String,
                     @ColumnInfo(name = "gender") var charGender: String,
                     //@ColumnInfo(name = "filmUrls") var filmUrls: List<String>,
                     @field:TypeConverters(FilmTypeConverters::class) var filmUrls: List<String> )

/*@Entity(tableName = "film_url")
data class FilmUrls(@PrimaryKey(autoGenerate = true) val url_id: Int = 0,
                    @ColumnInfo(name = "char_id") var charId: Int = 0,
                    @ColumnInfo(name = "film_url") var filmUrlFromList: String)

/*data class UrlsFromCharacters(
    @Embedded val char: Character,
    @Relation(parentColumn = "char_id", entityColumn = "url_id"),
    var UrlList = List<String)*/