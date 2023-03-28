package com.example.learningapplication.data_for_room

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*


class FilmTypeConverters {

    var gson = Gson()

    @TypeConverter
    fun stringToSomeObjectList(filmUrls: String?): List<String?>? {
        if (filmUrls == null) {
            return Collections.emptyList()
        }
        val listType: Type = object : TypeToken<List<String?>?>() {}.type
        return gson.fromJson<List<String?>>(filmUrls, listType)
    }

    @TypeConverter
    fun someObjectListToString(filmUrls: List<String?>?): String? {
        if (filmUrls == null) {
            return null
        }
        val listType: Type = object : TypeToken<List<String?>?>() {}.type
        return gson.toJson(filmUrls, listType)
    }

}


