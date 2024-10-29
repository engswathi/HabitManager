package com.example.noteapp.feature.habit_tracker.domain.repository

import com.example.noteapp.feature.habit_tracker.data.data_source.Habit

interface HabitRepository {

    suspend fun getAllHabits() : List<Habit>

    suspend fun insertHabit(habit: Habit)

    suspend fun deleteHabit(habit: Habit)
}