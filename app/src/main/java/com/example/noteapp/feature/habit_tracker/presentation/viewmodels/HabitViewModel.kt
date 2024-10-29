package com.example.noteapp.feature.habit_tracker.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp.feature.habit_tracker.data.data_source.Habit
import com.example.noteapp.feature.habit_tracker.data.repository.HabitRepositoryImpl
import com.example.noteapp.feature.habit_tracker.domain.repository.HabitRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HabitViewModel @Inject constructor(
    private val repository: HabitRepository // Injecting the repository
) : ViewModel() {

    private val _habits = MutableStateFlow<List<Habit>>(emptyList())
    val habits: StateFlow<List<Habit>> = _habits

    fun addHabit(habit: Habit) {
        viewModelScope.launch {
            repository.insertHabit(habit)
            fetchHabits()
        }
    }

    fun fetchHabits(){
        viewModelScope.launch {
            _habits.value = repository.getAllHabits()
        }

    }
}