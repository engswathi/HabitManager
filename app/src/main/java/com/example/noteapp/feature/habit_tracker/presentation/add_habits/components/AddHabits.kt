package com.example.noteapp.feature.habit_tracker.presentation.add_habits.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.noteapp.core.Screens
import com.example.noteapp.feature.habit_tracker.data.data_source.Habit
import com.example.noteapp.feature.habit_tracker.presentation.viewmodels.HabitViewModel

@SuppressLint("SuspiciousIndentation")
@Composable
    fun AddHabits(viewModel: HabitViewModel = hiltViewModel()
                  ,navController: NavController) {
        var textField1 by remember { mutableStateOf("") }
        var textField2 by remember { mutableStateOf("") }


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            TextField(
                value = textField1,
                onValueChange = { textField1 = it
                                },
                label = { Text("First Field") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = textField2,
                onValueChange = { textField2 = it },
                label = { Text("Second Field") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {

                 var habit = Habit(title = textField1, content = textField2)
                           viewModel.addHabit(habit)
                          navController.navigate(Screens.ViewHabitScreen.screens)
                },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Submit")
            }
        }
    }
