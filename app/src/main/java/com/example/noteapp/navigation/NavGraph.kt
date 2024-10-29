package com.example.noteapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.noteapp.core.Screens
import com.example.noteapp.feature.habit_tracker.data.data_source.Habit
import com.example.noteapp.feature.habit_tracker.presentation.add_habits.components.AddHabits
import com.example.noteapp.feature.habit_tracker.presentation.view_habits.components.ViewHabit
import com.example.noteapp.feature.habit_tracker.presentation.viewmodels.HabitViewModel

@Composable
fun SetUpNavGraph(navController : NavHostController,viewModel: HabitViewModel){

    NavHost(navController = navController,
        startDestination = Screens.ViewHabitScreen.screens ){
        composable("view_habit") { ViewHabit(viewModel,navController) }
        composable("add_habit") { AddHabits(viewModel,navController) }
    }



}