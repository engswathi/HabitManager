package com.example.noteapp.feature.note.domain.model

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Timestamp

@Entity
data class Note(val title : String,
    val content : String,
//    val timestamp: Timestamp,
    val color : Int,
    @PrimaryKey
    val id : Int ? = null
    ){

    companion object{

        val noteColors = listOf(Color.Blue,Color.Red,Color.Green,Color.Cyan)
    }
}
