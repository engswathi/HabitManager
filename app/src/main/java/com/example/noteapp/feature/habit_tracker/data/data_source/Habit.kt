package com.example.noteapp.feature.habit_tracker.data.data_source

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
data class Habit(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var title: String = "",
    var content: String = ""
)
