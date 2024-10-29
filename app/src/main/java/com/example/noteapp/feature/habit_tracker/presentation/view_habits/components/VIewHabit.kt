package com.example.noteapp.feature.habit_tracker.presentation.view_habits.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.noteapp.core.Screens
import com.example.noteapp.feature.habit_tracker.data.data_source.Habit
import com.example.noteapp.feature.habit_tracker.presentation.viewmodels.HabitViewModel

@Composable
fun ViewHabit(viewModel:HabitViewModel = hiltViewModel(),navController: NavHostController) {

    val habitList by viewModel.habits.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.SpaceEvenly
        ) {

            items(habitList) { habit ->
                displayHabit(habit)
            }
        }

        Scaffold(
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {

                              navController.navigate(Screens.AddHabitScreen.screens)
                    },
                    containerColor = MaterialTheme.colorScheme.primary // Set the background color
                ) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Add Note")
                }
            }
        ) {
            paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)  // Applies padding to avoid overlap with FAB or other Scaffold elements
            ) {
                }
        }
            // Your main content goes here
            // Modifier.padding(paddingValues) to account for the FAB
            // Example: Text("Your main content")
        }


    }




@Composable
fun displayHabit(habit: Habit) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = habit.title,
                fontSize = 20.sp,
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(modifier = Modifier.height(8.dp)) // Spacer for padding between title and content
            Text(text = habit.content, fontSize = 16.sp, style = MaterialTheme.typography.bodyLarge)
        }
    }


}

//@Composable
//@Preview(showBackground = true)
//fun showHabits(){
//
//
//
//    val notesList = listOf(
//        Habit(1, "Note 1", "This is the content for note 1."),
//        Habit(2, "Note 2", "This is the content for note 2."),
//        Habit(3, "Note 3", "This is the content for note 3.")
//    )
//    ViewHabit(habitList = notesList, rememberNavController())
//}

