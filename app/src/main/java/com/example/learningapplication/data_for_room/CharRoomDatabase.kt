package com.example.learningapplication.data_for_room


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import retrofit2.Converter

@TypeConverters(FilmTypeConverters::class)
@Database(entities = [Character::class], version = 2, exportSchema = false)

abstract class CharRoomDatabase: RoomDatabase() {
    abstract fun characterDao(): CharacterDao

    companion object {
        @Volatile
        private var INSTANCE: CharRoomDatabase? = null
        fun getDatabase(context: Context): CharRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CharRoomDatabase::class.java,
                    "char_database").fallbackToDestructiveMigration().build()
                INSTANCE = instance

                return instance
            }

        }

    }
}