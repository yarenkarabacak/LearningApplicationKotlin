package com.example.learningapplication.data_for_room

import android.app.Application

class CharacterApplication : Application() {
    val database: CharRoomDatabase by lazy { CharRoomDatabase.getDatabase(this) }
}