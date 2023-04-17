package com.example.learningapplication.data_for_room

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCharacterToDb(charr: Character)

    @Query("SELECT * FROM character ")
    fun getCharactersFromDb(): Flow<List<Character>>

    @Query("SELECT count(*) FROM character ")
    fun DbCharacterCounter(): Flow<Int>

}