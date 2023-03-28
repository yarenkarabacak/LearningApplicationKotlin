package com.example.learningapplication.data_for_room

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(charr: Character)

    @Query("SELECT * from character ")
    fun getChars(): Flow<List<Character>>
}