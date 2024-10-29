package com.example.noteapp.core

sealed class Screens(val screens: String) {

    object ViewHabitScreen : Screens("view_habit")
    object AddHabitScreen:Screens("add_habit")
}