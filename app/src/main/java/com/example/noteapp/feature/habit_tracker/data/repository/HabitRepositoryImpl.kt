package com.example.noteapp.feature.habit_tracker.data.repository

import com.example.noteapp.feature.habit_tracker.data.data_source.Habit
import com.example.noteapp.feature.habit_tracker.data.data_source.HabitDao
import com.example.noteapp.feature.habit_tracker.domain.repository.HabitRepository
import javax.inject.Inject

class HabitRepositoryImpl @Inject constructor(private val dao: HabitDao) : HabitRepository {
    override suspend fun getAllHabits(): List<Habit> {
       return dao.getAllHabits()
    }

    override suspend fun insertHabit(habit: Habit) {
        dao.insertHabit(habit)
    }

    override suspend fun deleteHabit(habit: Habit) {
        dao.deleteHabit(habit)
    }
}