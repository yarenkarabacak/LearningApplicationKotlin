package com.example.learningapplication.dependency_injection

import android.content.Context
import androidx.room.Room
import com.example.learningapplication.data.CharactersRepo
import com.example.learningapplication.data.FilmsRepo
import com.example.learningapplication.data_for_room.CharRoomDatabase
import com.example.learningapplication.data_for_room.CharacterDao
import com.example.learningapplication.data_for_room.CharacterDbRepo
import com.example.learningapplication.retrofit.CharactersAPI
import com.example.learningapplication.retrofit.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideCharactersRepo(charApi: CharactersAPI) : CharactersRepo {
        return CharactersRepo(charApi)
    }
    @Provides
    @Singleton
    fun provideCharacterDbRepo(charDao: CharacterDao) : CharacterDbRepo {
        return CharacterDbRepo(charDao)
    }

    @Provides
    @Singleton
    fun provideFilmsRepo(charApi: CharactersAPI) : FilmsRepo {
        return FilmsRepo(charApi)
    }

    @Provides
    @Singleton
    fun provideCharDao(@ApplicationContext context: Context) : CharacterDao {
        var db = Room.databaseBuilder(context,
            CharRoomDatabase::class.java,
            "char_database").fallbackToDestructiveMigration().build()

        return db.characterDao()
    }

    @Provides
    @Singleton
    fun provideCharApi() : CharactersAPI{
        return RetrofitClient.getCharacterApi()
    }

}