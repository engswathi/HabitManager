package com.example.noteapp.feature.habit_tracker.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Habit::class],
    version = 1)
abstract class HabitDatabase : RoomDatabase(){


    abstract fun habitDao(): HabitDao

    companion object{
        const val DATABASE_NAME = "habit_database"
    }
}