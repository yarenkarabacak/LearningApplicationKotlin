package com.example.learningapplication.dependency_injection

import android.app.Application
import com.example.learningapplication.data_for_room.CharRoomDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HiltApplication : Application() {

}