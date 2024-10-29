package com.example.noteapp.di.habits_di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.noteapp.feature.habit_tracker.data.data_source.HabitDao
import com.example.noteapp.feature.habit_tracker.data.data_source.HabitDatabase
import com.example.noteapp.feature.habit_tracker.data.repository.HabitRepositoryImpl
import com.example.noteapp.feature.habit_tracker.domain.repository.HabitRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HabitsAppModule {

    @Provides
    @Singleton
    fun provideHabitDatabase(app: Application) : HabitDatabase{

        return Room.databaseBuilder(app,
            HabitDatabase::class.java,
            HabitDatabase.DATABASE_NAME
            ).build()
    }

    @Provides
    @Singleton
    fun provideHabitDao(database: HabitDatabase): HabitDao {
        return database.habitDao()
    }

    @Provides
    @Singleton
    fun provideHabitRepository(dao: HabitDao) : HabitRepository{

        return HabitRepositoryImpl(dao)
    }
}